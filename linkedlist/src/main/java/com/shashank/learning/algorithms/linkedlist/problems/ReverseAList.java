package com.shashank.learning.algorithms.linkedlist.problems;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNode;

public class ReverseAList
{
    public static ListNode reverseList(ListNode headNode)
    {
        ListNode temp = null, next = null, currentNode = headNode;

        while (currentNode.getNext() != null)
        {
            next = currentNode.getNext();
            currentNode.setNext(temp);

            temp = currentNode;
            currentNode = next;
        }
        // currentNode will be the new headNode
        return currentNode;
    }

    public static ListNode reverseListByRecursion(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode Can't be Null");
        return reverseListByRecursionInternal(null, headNode);
    }

    private static ListNode reverseListByRecursionInternal(ListNode previousNode, ListNode currentNode)
    {
        if (currentNode == null)
        {
            return previousNode;
        }

        ListNode nextToCurrentNode = currentNode.getNext();
        currentNode.setNext(previousNode);

        return reverseListByRecursionInternal(currentNode, nextToCurrentNode);
    }
}