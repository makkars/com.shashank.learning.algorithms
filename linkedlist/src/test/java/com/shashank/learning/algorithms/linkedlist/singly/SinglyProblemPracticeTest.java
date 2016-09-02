package com.shashank.learning.algorithms.linkedlist.singly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
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
}