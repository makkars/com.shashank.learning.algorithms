package com.shashank.learning.algorithms.linkedlist.problems;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNodeOperations;

public class SinglyProblemPractice
{
    public static ListNode middleElementOfList(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "headNode can't be null");

        ListNode previousNode = headNode;
        ListNode currentNode = previousNode.getNext();

        int switchIncremental = 1;
        while (currentNode.getNext() != null)
        {
            if (switchIncremental == 0)
            {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                switchIncremental = 1;
            } else
            {
                currentNode = currentNode.getNext();
                switchIncremental = 0;
            }
        }
        return previousNode;
    }

    public static ListNode getElementFromEndUsingSizeList(ListNode headNode, int elementFromEnd)
    {
        int size = new SinglyListNodeOperations().size(headNode);

        Preconditions.checkArgument((elementFromEnd > 0 && elementFromEnd < size), "Element Position should be in between : [1," + size + "]");

        int elementToFetch = size - elementFromEnd + 1;

        return new SinglyListNodeOperations().getNodeByPosition(headNode, elementToFetch);
    }

    public static ListNode getElementFromEnd(ListNode headNode, int elementFromEnd)
    {
        Preconditions.checkArgument((elementFromEnd > 0), "Element Position should be > 0");
        int middleElementPosition = getMiddleNodePosition(headNode);

        int elementPosition;

        if (middleElementPosition > elementFromEnd)
        {
            elementPosition = middleElementPosition + (middleElementPosition - elementFromEnd);
        } else if (middleElementPosition < elementFromEnd)
        {
            elementPosition = middleElementPosition - (elementFromEnd - middleElementPosition);
        } else
        {
            elementPosition = middleElementPosition;
        }

        return new SinglyListNodeOperations().getNodeByPosition(headNode, elementPosition);
    }

    public static ListNode getElementFromEndEffectiveSolution(ListNode headNode, int elementFromEnd)
    {
        Preconditions.checkArgument(headNode != null, "headNode can't be null");
        ListNode tempNode = headNode;
        ListNode nodeToReturnFromEnd = headNode;

        for (int i = 1; i < elementFromEnd; i++)
        {
            if (tempNode.getNext() == null)
            {
                throw new IllegalArgumentException("Not enough elements in the list");
            }
            tempNode = tempNode.getNext();
        }

        while (tempNode != null)
        {
            tempNode = tempNode.getNext();
            nodeToReturnFromEnd = nodeToReturnFromEnd.getNext();
        }
        return nodeToReturnFromEnd;
    }

    /**
     * @param headNode
     * @return middle element position
     * @throws IllegalArgumentException if headNode is null
     */
    public static int getMiddleNodePosition(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "headNode can't be null");
        ListNode previousNode = headNode;
        ListNode currentNode = previousNode.getNext();

        int position = 1;

        if (currentNode == null)
        {
            return position;
        }

        int listSize = 2;
        boolean flag = false;
        while (currentNode.getNext() != null)
        {
            if (flag)
            {
                previousNode = currentNode;
                currentNode = previousNode.getNext();
                flag = false;
                position++;
            } else
            {
                currentNode = currentNode.getNext();
                flag = true;
            }
            listSize++;
        }

        if (listSize % 2 == 0)
        {
            return position;
        } else
        {
            return position + 1;
        }
    }
}