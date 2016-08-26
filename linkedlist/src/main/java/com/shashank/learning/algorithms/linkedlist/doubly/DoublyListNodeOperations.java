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
    public static ListNode insert(DoublyListNode headNode, DoublyListNode nodeToInsert, int position)
    {
        ListNodeUtils.initialValidation(headNode,nodeToInsert,position);
        return null;
    }
}
