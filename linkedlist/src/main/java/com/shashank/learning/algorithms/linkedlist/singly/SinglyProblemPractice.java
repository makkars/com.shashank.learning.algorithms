package com.shashank.learning.algorithms.linkedlist.singly;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNode;

public class SinglyProblemPractice

{
    public static ListNode middleElementOfList(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "headNode can't be null");

        ListNode previousNode = headNode;
        ListNode currentNode = previousNode.getNext();

        int switchIncremental = 1;
        while (currentNode.getNext() != null)
        {
            if (switchIncremental == 0)
            {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                switchIncremental = 1;
            } else
            {
                currentNode = currentNode.getNext();
                switchIncremental = 0;
            }
        }
        return previousNode;
    }
}