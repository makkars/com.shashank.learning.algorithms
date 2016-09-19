package com.shashank.learning.algorithms.linkedlist.problems;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNodeOperations;
import org.junit.Assert;
import org.junit.Test;

public class ReverseAListTest
{
    private final SinglyListNodeOperations mySinglyListNodeOperations = new SinglyListNodeOperations();

    @Test
    public void reverseList_shouldReturnLastNodeAsNewHeadNode()
    {

        int numberOfNodes = 10;
        ListNode headNode = TestDataCreator.createSinglyListNode(numberOfNodes);

        Long expectedResult = mySinglyListNodeOperations.getNodeByPosition(headNode, numberOfNodes).getData();

        Long actualResult = ReverseAList.reverseList(headNode).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void reverseListByRecursion_shouldReturnLastNodeAsNewHeadNode()
    {

        int numberOfNodes = 10;
        ListNode headNode = TestDataCreator.createSinglyListNode(numberOfNodes);

        Long expectedResult;
        expectedResult = mySinglyListNodeOperations.getNodeByPosition(headNode, numberOfNodes).getData();

        Long actualResult = ReverseAList.reverseListByRecursion(headNode).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }
}