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
            if (count == index)
            {
                return currentNode;
            }
            currentNode = currentNode.getNext();
            ++count;
        }

        /*
        When currentNode.getNext() != headNode , it meant you have found what you are looking.
        If they are equal, it means you have index which is out of size
        This condition is to true when while loop completes without breaking.
        */
        if (currentNode.getNext() == headNode && index > count)
        {
            throw new IllegalArgumentException("Index should be <= " + count);
        }
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
        Preconditions.checkArgument((headNode != null && nodeToInsert != null), "Input arguments can't be null");
        ListNode currentNode = headNode;

        while (currentNode.getNext() != headNode)
        {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(nodeToInsert);
        nodeToInsert.setNext(headNode);

        return nodeToInsert;
    }

    public ListNode insertInLast(ListNode headNode, ListNode nodeToInsert)
    {
        Preconditions.checkArgument((headNode != null && nodeToInsert != null), "Input arguments can't be null");
        ListNode currentNode = headNode;

        while (currentNode.getNext() != headNode)
        {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(nodeToInsert);
        nodeToInsert.setNext(headNode);

        return headNode;
    }

    public ListNode deleteHeadNode(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");
        ListNode previousNode = headNode;

        while (previousNode.getNext() != headNode)
        {
            previousNode = previousNode.getNext();
        }

        ListNode currentHeadNode = previousNode.getNext();
        ListNode newHeadNode = currentHeadNode.getNext();

        previousNode.setNext(newHeadNode);

        currentHeadNode.setNext(null);
        currentHeadNode = null;
        return newHeadNode;
    }

    public ListNode deleteEndNode(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");
        ListNode previousNode = headNode;
        ListNode currentNode = headNode.getNext();

        while (currentNode.getNext() != headNode)
        {
            previousNode = previousNode.getNext();
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(currentNode.getNext());
        currentNode.setNext(null);
        currentNode = null;

        return headNode;
    }
}
