package com.shashank.learning.algorithms.linkedlist.doubly;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;

public class DoublyListNodeOperations extends ListNodeOperations
{

    @Override
    public ListNode insertInLast(ListNode headNode, ListNode nodeToInsert)
    {
        Preconditions.checkArgument((headNode != null && nodeToInsert != null), "Input arguments can't be null");

        DoublyListNode currentNode = (DoublyListNode) headNode;

        while (currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(nodeToInsert);

        ((DoublyListNode) nodeToInsert).setPrevious(currentNode);
        return headNode;
    }

    @Override
    public ListNode insertOnHead(ListNode headNode, ListNode nodeToInsert)
    {
        Preconditions.checkArgument((headNode != null && nodeToInsert != null), "Input arguments can't be null");

        ((DoublyListNode) nodeToInsert).setNext(headNode);
        ((DoublyListNode) headNode).setPrevious(nodeToInsert);
        return nodeToInsert;
    }

    /**
     * @param headNode     ListNode starting node
     * @param nodeToInsert new node to be inserted
     * @param position     Position at which node to be inserted
     * @return @{@link DoublyListNode} newHeadNode after insertion of node at given position
     */
    public ListNode insertAtPosition(ListNode headNode, ListNode nodeToInsert, int position)
    {
        initialValidation(headNode, nodeToInsert, position);

        if (headNode == null)
        {
            return nodeToInsert;
        }

        DoublyListNode currentNode = (DoublyListNode) headNode;
        DoublyListNode downCastedNodeToInsert = (DoublyListNode) nodeToInsert;

        // Insertion on Head
        if (position == 1)
        {
            downCastedNodeToInsert.setPrevious(null);
            downCastedNodeToInsert.setNext(currentNode);
            currentNode.setPrevious(nodeToInsert);

            headNode = nodeToInsert;
            return headNode;
        }
        else
        {
            // Insertion at position
            int count = 1;
            while (count < position)
            {
                currentNode = currentNode.getNext();
                count++;
            }

            // Insertion in the end
            if (currentNode.getNext() == null)
            {
                currentNode.setNext(nodeToInsert);
                downCastedNodeToInsert.setPrevious(currentNode);
            }
            else
            {
                // Insertion in the middle
                DoublyListNode previousNode = currentNode.getPrevious();
                previousNode.setNext(nodeToInsert);
                downCastedNodeToInsert.setPrevious(previousNode);
                downCastedNodeToInsert.setNext(currentNode);
            }
        }
        return headNode;
    }

    public ListNode deleteOnPosition(ListNode headNode, int position)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode should not be null for delete operation");

        if (position == 1)
        {
            DoublyListNode newHeadNode = (DoublyListNode) headNode.getNext();
            newHeadNode.setPrevious(null);
            headNode = null;
            return newHeadNode;
        }
        else
        {
            DoublyListNode currentNode = (DoublyListNode) headNode;
            int count = 1;

            while (count < position)
            {
                currentNode = currentNode.getNext();
                count++;
            }

            if (currentNode.getNext() == null)
            {
                currentNode.getPrevious().setNext(null);
                currentNode = null;
            }
            else
            {
                DoublyListNode previousNode = currentNode.getPrevious();
                DoublyListNode nextToCurrentNode = currentNode.getNext();

                previousNode.setNext(nextToCurrentNode);
                nextToCurrentNode.setPrevious(previousNode);

                currentNode.setPrevious(null);
                currentNode.setNext(null);
                currentNode = null;
            }
        }
        return headNode;
    }

    @Override
    public ListNode deleteHeadNode(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode should not be null for delete operation");

        DoublyListNode nextHeadNode = (DoublyListNode) headNode.getNext();
        nextHeadNode.setPrevious(null);

        headNode.setNext(null);
        headNode = null;
        return nextHeadNode;

    }

    @Override
    public ListNode deleteEndNode(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode should not be null for delete operation");

        DoublyListNode currentNode = (DoublyListNode) headNode;

        while (currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }

        currentNode.getPrevious().setNext(null);
        currentNode.setPrevious(null);
        currentNode = null;

        return headNode;
    }
}