package com.shashank.learning.algorithms.linkedlist.problems;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNodeOperations;
import org.junit.Assert;
import org.junit.Test;

public class ListEndCycleOrNullTest
{
    private final SinglyListNodeOperations mySinglyListNodeOperations = new SinglyListNodeOperations();

    @Test
    public void getHeadNodeOfCircularLoopList_shouldReturnANode()
    {
        int nodes = 10;
        int circularNodeLoopPosition = 4;
        ListNode headNode = TestDataCreator.createCircularLoopedListNode(nodes, circularNodeLoopPosition);

        Long expectedResult = mySinglyListNodeOperations.getNodeByPosition(headNode, circularNodeLoopPosition).getData();

        Long actualResult = ListEndCycleOrNull.getHeadNodeOfCircularLoopList(headNode).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void isListEndCyclicOrNull_ShouldReturnTrue()
    {

        int nodes = 10;
        int circularNodeLoopPosition = 4;
        ListNode headNode = TestDataCreator.createCircularLoopedListNode(nodes, circularNodeLoopPosition);

        boolean actualResult = ListEndCycleOrNull.isListEndCyclicOrNull(headNode);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void isListEndCyclicOrNull_ShouldReturnFalse()
    {

        int nodes = 10;
        ListNode headNode = TestDataCreator.createSinglyListNode(nodes);

        boolean actualResult = ListEndCycleOrNull.isListEndCyclicOrNull(headNode);
        Assert.assertEquals(false, actualResult);
    }
}