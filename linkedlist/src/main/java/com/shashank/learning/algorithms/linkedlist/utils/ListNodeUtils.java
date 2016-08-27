package com.shashank.learning.algorithms.linkedlist.utils;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;

public class ListNodeUtils
{
    public static void initialValidation(ListNode headNode, ListNode nodeToInsert, int position)
    {
        Preconditions.checkArgument(nodeToInsert != null, "NodeToInsert can't be null");
        int size = 0;
        if (headNode != null)
        {
            size = ListNodeOperations.size(headNode);
        }
        Preconditions.checkArgument(!(position < 1 || position > size + 1), "Position Argument should be in between 1 to " + (size + 1));
    }
}
