package com.shashank.learning.algorithms.linkedlist.circular;

import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import org.junit.Assert;
import org.junit.Test;

public class CircularListNodeOperationsTest
{

    private final CircularListNodeOperations myCircularListNodeOperations = new CircularListNodeOperations();

    @Test
    public void shouldReturnListSize()
    {
        int expectedSize = 3;
        CircularListNode headNode = TestDataCreator.createCircularListNode(expectedSize);

        int actualSize = myCircularListNodeOperations.size(headNode);

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldGetCorrectNode()
    {
        int numberOfNodes = 5;
        CircularListNode headNode = TestDataCreator.createCircularListNode(numberOfNodes);

        // 3rd Node data is expected
        Long expectedResult = headNode.getNext().getNext().getData();

        int nodeIndex = 2;
        Long actualResult = myCircularListNodeOperations.getNode(headNode, nodeIndex).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailAsIndexOutOfRange()
    {
        int numberOfNodes = 5;
        CircularListNode headNode = TestDataCreator.createCircularListNode(numberOfNodes);

        int nodeIndex = 5;
        myCircularListNodeOperations.getNode(headNode, nodeIndex).getData();
    }
}