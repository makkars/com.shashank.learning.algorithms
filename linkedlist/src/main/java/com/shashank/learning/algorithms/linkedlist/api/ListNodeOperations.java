package com.shashank.learning.algorithms.linkedlist.api;

import com.google.common.base.Preconditions;

public abstract class ListNodeOperations
{
    public void initialValidation(ListNode headNode, ListNode nodeToInsert, int position)
    {
        Preconditions.checkArgument(!(nodeToInsert == null || headNode == null), "Input headNode/nodeToInsert can't be null");
        int size = size(headNode);
        Preconditions.checkArgument(!(position < 1 || position > size + 1), "Position Argument should be in between 1 to " + (size + 1));
    }

    public int size(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");

        int size = 0;
        ListNode currentNode = headNode;
        while (currentNode != null)
        {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    /**
     * @param headNode First Node of Singly Linked List
     * @param position    API consider first element is at 1 position
     * @return @{@link ListNode}  Node at index value
     *
     * @throws IllegalArgumentException <br> 1.) If headNode is null
     *                                  <br> 2.) If index is valid
     */
    public ListNode getNodeByPosition(ListNode headNode, int position)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");

        ListNode currentNode = headNode;
        int count = 1;
        while (currentNode != null)
        {
            if (position == count)
            {
                break;
            }
            else
            {
                currentNode = currentNode.getNext();
            }
            count++;
        }

        Preconditions.checkArgument(currentNode != null, "Index should be <= " + count);
        return currentNode;
    }

    /**
     * @param headNode First Node of Singly Linked List
     * @param index    API consider first element is at 0 index
     * @return @{@link ListNode}  Node at index value
     *
     * @throws IllegalArgumentException <br> 1.) If headNode is null
     *                                  <br> 2.) If index is valid
     */
    public ListNode getNode(ListNode headNode, int index)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");

        ListNode currentNode = headNode;
        int count = 0;
        while (currentNode != null)
        {
            if (index == count)
            {
                break;
            }
            else
            {
                currentNode = currentNode.getNext();
            }
            count++;
        }

        Preconditions.checkArgument(currentNode != null, "Index should be <= " + count);
        return currentNode;
    }

    public abstract ListNode insertOnHead(ListNode headNode, ListNode nodeToInsert);

    public abstract ListNode insertInLast(ListNode headNode, ListNode nodeToInsert);

    public abstract ListNode deleteHeadNode(ListNode headNode);

    public abstract ListNode deleteEndNode(ListNode headNode);
}
