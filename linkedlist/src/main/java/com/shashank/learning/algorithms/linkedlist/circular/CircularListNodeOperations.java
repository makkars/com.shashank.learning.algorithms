package com.shashank.learning.algorithms.linkedlist.circular;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;

public class CircularListNodeOperations extends ListNodeOperations
{

    @Override
    public int size(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");

        int size = 1;
        ListNode currentNode = headNode;
        while (currentNode.getNext() != headNode)
        {
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }

    @Override
    public ListNode getNode(ListNode headNode, int index)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");

        int count = 0;
        ListNode currentNode = headNode;
        while (currentNode.getNext() != headNode)
        {
            ++count;
            if (count == index)
            {
                break;
            }
            currentNode = currentNode.getNext();
        }

        // When currentNode.getNext() != headNode , it meant you have found what you are looking.
        // If they are equal, it means you have index which is out of size
        Preconditions.checkArgument(currentNode.getNext() != headNode, "Index should be <= " + count);
        return currentNode;
    }

    @Override
    public void initialValidation(ListNode headNode, ListNode nodeToInsert, int position)
    {
        Preconditions.checkArgument(!(nodeToInsert != null && headNode != null), "Input headNode/nodeToInsert can't be null");
        int size = size(headNode);
        Preconditions.checkArgument(!(position < 1 || position > size + 1), "Position Argument should be in between 1 to " + (size + 1));
    }

    public ListNode insertOnHead(ListNode headNode, ListNode nodeToInsert)
    {
        return null;
    }

    public ListNode insertInLast(ListNode headNode, ListNode nodeToInsert)
    {
        return null;
    }

    public ListNode deleteHeadNode(ListNode headNode)
    {
        return null;
    }

    public ListNode deleteEndNode(ListNode headNode)
    {
        return null;
    }
}
