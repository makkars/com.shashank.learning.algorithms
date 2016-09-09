package com.shashank.learning.algorithms.linkedlist.problems;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNodeOperations;
import org.junit.Assert;
import org.junit.Test;

public class SinglyProblemPracticeTest
{
    private final SinglyListNodeOperations mySinglyListNodeOperations = new SinglyListNodeOperations();

    @Test
    public void shouldReturnMiddleNodeForOddNumberList()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);

        Long expectedResult = mySinglyListNodeOperations.getNode(fiveNodes, 2).getData();

        Long actualResult = SinglyProblemPractice.middleElementOfList(fiveNodes).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnMiddleNodeForEvenNumberList()
    {
        ListNode tenNodes = TestDataCreator.createSinglyListNode(5);

        Long expectedResult = mySinglyListNodeOperations.getNode(tenNodes, 2).getData();

        Long actualResult = SinglyProblemPractice.middleElementOfList(tenNodes).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnEvenMiddlePosition()
    {
        ListNode sevenNodes = TestDataCreator.createSinglyListNode(7);

        int expectedResult = 4;
        int actualResult = SinglyProblemPractice.getMiddleNodePosition(sevenNodes);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnOddMiddlePosition()
    {
        ListNode eightNodes = TestDataCreator.createSinglyListNode(8);

        int expectedResult = 4;
        int actualResult = SinglyProblemPractice.getMiddleNodePosition(eightNodes);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnNodeFromEndInOddSizedList()
    {
        ListNode headNode = TestDataCreator.createSinglyListNode(7);

        Long expectedResult = mySinglyListNodeOperations.getNode(headNode, 4).getData();
        Long actualResult = SinglyProblemPractice.getElementFromEndUsingSizeList(headNode, 3).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnNodeFromEndInEvenSizedList()
    {
        ListNode headNode = TestDataCreator.createSinglyListNode(4);

        Long expectedResult = mySinglyListNodeOperations.getNode(headNode, 3).getData();
        Long actualResult = SinglyProblemPractice.getElementFromEndUsingSizeList(headNode, 1).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnNodeFromEndInOddSizedList2()
    {
        ListNode headNode = TestDataCreator.createSinglyListNode(7);

        Long expectedResult = mySinglyListNodeOperations.getNode(headNode, 2).getData();
        Long actualResult = SinglyProblemPractice.getElementFromEndUsingSizeList(headNode, 5).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnNodeFromEndInEvenSizedList2()
    {
        ListNode headNode = TestDataCreator.createSinglyListNode(8);

        Long expectedResult = mySinglyListNodeOperations.getNode(headNode, 3).getData();
        Long actualResult = SinglyProblemPractice.getElementFromEndUsingSizeList(headNode, 5).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }
}