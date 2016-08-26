package com.shashank.learning.algorithms.linkedlist.api;

public abstract class ListNodeOperations
{
    public static int size(ListNode headNode)
    {
        int length = 0;
        if (headNode == null)
        {
            return length;
        }

        ListNode currentNode = headNode;
        while (currentNode != null)
        {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }
}
