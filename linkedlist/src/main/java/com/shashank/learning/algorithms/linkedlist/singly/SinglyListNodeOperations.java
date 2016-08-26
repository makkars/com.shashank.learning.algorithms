package com.shashank.learning.algorithms.linkedlist.singly;

import com.google.common.base.Preconditions;

/**
 * Created by eshmakk on 8/26/2016.
 */
public class SinglyListNodeOperations
{
    public static int listLength(SinglyListNode headNode)
    {
        int length = 0;
        if (headNode == null)
        {
            return length;
        }

        SinglyListNode currentNode = headNode;
        while (currentNode != null)
        {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public static SinglyListNode insertionOperation(SinglyListNode headNode, SinglyListNode nodeToInsert, int position)
    {
        if (headNode == null)
        {
            return nodeToInsert;
        }

        int size = listLength(headNode);

        Preconditions.checkArgument(!(position < 1 || position > size + 1),
                "Position Argument should be in between 1 to " + (size + 1));

        // Insertion on head
        if (position == 1)
        {
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else
        {
            // Insertion in the middle or in the end
            SinglyListNode previousNode = headNode;
            int count = 1;
            while (count < position-1)
            {
                previousNode = previousNode.getNext();
                count++;
            }

            SinglyListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    public static SinglyListNode getNode(SinglyListNode headNode, int index)
    {
        Preconditions.checkArgument(headNode != null, "SinglyListNode can not be null");

        SinglyListNode currentNode = headNode;
        int size = 0;
        while(currentNode != null)
        {
            if(index == size)
            {
                break;
            }
            else
            {
                currentNode = currentNode.getNext();
            }
            size++;
        }

        Preconditions.checkArgument(currentNode != null, "Index should be less then "+size);
        return currentNode;
    }
}
