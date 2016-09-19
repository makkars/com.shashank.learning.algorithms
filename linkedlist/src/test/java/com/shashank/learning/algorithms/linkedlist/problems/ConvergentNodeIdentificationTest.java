package com.shashank.learning.algorithms.linkedlist.problems;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNodeOperations;
import org.junit.Assert;
import org.junit.Test;

public class ConvergentNodeIdentificationTest
{

    final SinglyListNodeOperations mySinglyListNodeOperations = new SinglyListNodeOperations();

    @Test
    public void getConvergentNode_shouldReturnCorrectNode() throws Exception
    {
        int firstListSize = 5, secondListSize = 10;
        ListNode firstList = TestDataCreator.createSinglyListNode(firstListSize);
        ListNode secondList = TestDataCreator.createSinglyListNode(secondListSize);

        ListNode convergentNodePoint = TestDataCreator.createSinglyListNode(5);

        mySinglyListNodeOperations.insertInLast(firstList, convergentNodePoint);
        mySinglyListNodeOperations.insertInLast(secondList, convergentNodePoint);

        Long expectedResult = convergentNodePoint.getData();

        Long actualResult = ConvergentNodeIdentification.getConvergentNodeByHashMap(firstList, secondList).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getConvergentNodeByEffectiveSolution_shouldReturnCorrectNode() throws Exception
    {
        int firstListSize = 5, secondListSize = 10;
        ListNode firstList = TestDataCreator.createSinglyListNode(firstListSize);
        ListNode secondList = TestDataCreator.createSinglyListNode(secondListSize);

        ListNode convergentNodePoint = TestDataCreator.createSinglyListNode(10);

        mySinglyListNodeOperations.insertInLast(firstList, convergentNodePoint);
        mySinglyListNodeOperations.insertInLast(secondList, convergentNodePoint);

        Long expectedResult = convergentNodePoint.getData();

        Long actualResult = ConvergentNodeIdentification.getConvergentNodeByEffectiveSolution(firstList, secondList).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getConvergentNodeByEffectiveSolution_shouldReturnNull() throws Exception
    {
        int firstListSize = 5, secondListSize = 10;
        ListNode firstList = TestDataCreator.createSinglyListNode(firstListSize);
        ListNode secondList = TestDataCreator.createSinglyListNode(secondListSize);

        ListNode convergentNodePoint = TestDataCreator.createSinglyListNode(10);

        ListNode actualResult = ConvergentNodeIdentification.getConvergentNodeByEffectiveSolution(firstList, secondList);

        Assert.assertNull(actualResult);
    }
}