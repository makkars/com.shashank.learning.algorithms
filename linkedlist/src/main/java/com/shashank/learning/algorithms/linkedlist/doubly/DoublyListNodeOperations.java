package com.shashank.learning.algorithms.linkedlist.doubly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;
import com.shashank.learning.algorithms.linkedlist.utils.ListNodeUtils;

public class DoublyListNodeOperations extends ListNodeOperations
{

    /**
     * @param headNode     ListNode starting node
     * @param nodeToInsert new node to be inserted
     * @param position     Position at which node to be inserted
     * @return @{@link DoublyListNode} newHeadNode after insertion of node at given position
     */
    @Override
    public ListNode insert(ListNode headNode, ListNode nodeToInsert, int position)
    {
        ListNodeUtils.initialValidation(headNode, nodeToInsert, position);

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

    public ListNode delete(ListNode headNode, int position)
    {
        return null;
    }
}