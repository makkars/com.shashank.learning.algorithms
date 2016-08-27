package com.shashank.learning.algorithms.linkedlist.api;

import com.google.common.base.Preconditions;

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

    /**
     * @param headNode First Node of Singly Linked List
     * @param index    API consider first element is at 0 index
     * @return @{@link ListNode}  Node at index value
     *
     * @throws IllegalArgumentException <br> 1.) If headNode is null
     *                                  <br> 2.) If index is valid
     */
    public static ListNode getNode(ListNode headNode, int index)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");

        ListNode currentNode = headNode;
        int size = 0;
        while (currentNode != null)
        {
            if (index == size)
            {
                break;
            }
            else
            {
                currentNode = currentNode.getNext();
            }
            size++;
        }

        Preconditions.checkArgument(currentNode != null, "Index should be less then " + size);
        return currentNode;
    }

    public abstract ListNode insert(ListNode headNode, ListNode nodeToInsert, int position);

    public abstract ListNode delete(ListNode headNode, int position);
}
