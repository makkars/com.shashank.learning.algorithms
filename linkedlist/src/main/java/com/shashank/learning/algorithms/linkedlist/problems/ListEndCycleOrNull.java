package com.shashank.learning.algorithms.linkedlist.problems;

import com.google.common.base.Preconditions;
import com.shashank.learning.algorithms.linkedlist.api.ListNode;

public class ListEndCycleOrNull
{

    /**
     * This works on principle race of Tortoise and hare.
     * Tortoise move one step at a time while hare move two steps.
     * So Tortoise will be running over whole list while hare jumping in a loop or reach the end (Null node)
     *
     * @param headNode
     * @return True if given headNode has a cyclic loop inside
     * False if headNode end with a NULL node
     * @throws IllegalArgumentException in case headNode is null
     */
    public static boolean isListEndCyclicOrNull(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "Input parameter: Node, should not be null");

        ListNode slowPointer = headNode;
        ListNode fastPointer = headNode;

        boolean result = false;
        while (slowPointer.getNext() != null)
        {
            // This check avoid NPE when hare node is gain a lot of difference from tortoise
            if (fastPointer == null || fastPointer.getNext() == null || fastPointer.getNext().getNext() == null)
            {
                break;
            }
            fastPointer = fastPointer.getNext();

            if (slowPointer == fastPointer)
            {
                result = true;
                break;
            }
            slowPointer = slowPointer.getNext();

            fastPointer = fastPointer.getNext();
        }
        return result;
    }

    /**
     * Need to clarification why we need to increment hare pointer
     * when reset tortoise to head to find the circular head.
     *
     * @param headNode
     * @return {@link ListNode)
     * @throws IllegalArgumentException in case headNode is null
     *                                  OR No circular loop inside the list
     */
    public static ListNode getHeadNodeOfCircularLoopList(ListNode headNode)
    {
        Preconditions.checkArgument(headNode != null, "Input parameter: Node, should not be null");

        ListNode slowPointer = headNode;
        ListNode fastPointer = headNode;

        boolean result = false;
        while (fastPointer.getNext() != null && fastPointer.getNext().getNext() != null)
        {
            fastPointer = fastPointer.getNext();

            if (slowPointer == fastPointer)
            {
                result = true;
                break;
            }
            slowPointer = slowPointer.getNext();

            fastPointer = fastPointer.getNext();
        }

        if (!result)
        {
            throw new IllegalArgumentException("Input Node is not cyclic");
        }

        slowPointer = headNode;
        fastPointer = fastPointer.getNext();

        while (slowPointer != fastPointer)
        {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext();
        }
        return slowPointer;
    }
}
