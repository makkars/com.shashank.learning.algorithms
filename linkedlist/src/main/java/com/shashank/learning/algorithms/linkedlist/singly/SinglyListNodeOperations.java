package com.shashank.learning.algorithms.linkedlist.singly;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;
import com.shashank.learning.algorithms.linkedlist.utils.ListNodeUtils;

public class SinglyListNodeOperations extends ListNodeOperations
{

    public static SinglyListNode insert(SinglyListNode headNode, SinglyListNode nodeToInsert, int position)
    {
        ListNodeUtils.initialValidation(headNode, nodeToInsert, position);
        if (headNode == null)
        {
            return nodeToInsert;
        }

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
            while (count < position - 1)
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

    /**
     * @param headNode First Node of Singly Linked List
     * @param position Node Position to be Deleted, First node starts with position:1
     * @return @{@link SinglyListNode}  newHeadNode after deletion of a node with size: headNode-1
     * @throws IllegalArgumentException <br> 1.) If headNode is null
     *                                  <br> 2.) If position is invalid
     */
    public static SinglyListNode delete(SinglyListNode headNode, int position)
    {
        Preconditions.checkArgument(headNode != null, "HeadNode can not be null");

        SinglyListNode currentNode = headNode;
        SinglyListNode nextToCurrentNode = headNode.getNext();

        int size = size(headNode);
        Preconditions.checkArgument(!(position < 1 || position > size + 1), "Position Argument should be in between 1 to " + (size + 1));

        // Deletion on Head
        if (position == 1)
        {
            headNode = nextToCurrentNode;
            currentNode.setNext(null);
            return headNode;
        } else
        {
            // Deletion on middle or in the end
            int count = 1;
            while (count < position - 1)
            {
                currentNode = nextToCurrentNode;
                nextToCurrentNode = nextToCurrentNode.getNext();
                count++;
            }

            SinglyListNode newNextNodePointerForCurrentNode = nextToCurrentNode.getNext();
            currentNode.setNext(newNextNodePointerForCurrentNode);
            nextToCurrentNode.setNext(null);
        }
        return headNode;
    }
}