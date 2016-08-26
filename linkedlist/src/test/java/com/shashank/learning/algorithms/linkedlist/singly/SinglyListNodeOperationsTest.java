package com.shashank.learning.algorithms.linkedlist.singly;

import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eshmakk on 8/26/2016.
 */
public class SinglyListNodeOperationsTest
{
    @Test
    public void listLength() throws Exception
    {
        SinglyListNode headNode = new SinglyListNode();
        SinglyListNode secondNode = new SinglyListNode();

        headNode.setData(1);
        headNode.setNext(secondNode);
        secondNode.setData(2);

        Integer expectedResult = 2;
        Integer actualResult = SinglyListNodeOperations.size(headNode);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnZeroOnListLength()
    {
        Integer expectedResult = 0;
        Integer actualResult = SinglyListNodeOperations.size(null);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertOnHead()
    {
        SinglyListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        SinglyListNode headNode = SinglyListNodeOperations.insert(tenNodes, nodeToInsert, 1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInEnd()
    {
        SinglyListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int size = SinglyListNodeOperations.size(tenNodes);
        int endPosition = size + 1;
        SinglyListNode headNode = SinglyListNodeOperations.insert(tenNodes, nodeToInsert, endPosition);

        int indexOfPosition = size;
        SinglyListNode endNode = SinglyListNodeOperations.getNode(headNode, indexOfPosition);

        Long actualResult = endNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertAtPositionValue()
    {
        SinglyListNode fiveNodes = TestDataCreator.createSinglyListNode(5);

        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int position = 3;
        SinglyListNode headNode = SinglyListNodeOperations.insert(fiveNodes, nodeToInsert, position);

        int indexOfNode = 2;
        SinglyListNode middleNode = SinglyListNodeOperations.getNode(headNode, indexOfNode);

        Long actualResult = middleNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithPositionErrorOnInsertionOperation()
    {
        SinglyListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);

        int position = 30;
        SinglyListNodeOperations.insert(fiveNodes, nodeToInsert, position);
    }

    @Test
    public void shouldDeleteOnHead()
    {
        SinglyListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        Long expectedDataResult = fiveNodes.getNext().getData();
        int expectedListLength = 4;

        SinglyListNode newHeadNode = SinglyListNodeOperations.delete(fiveNodes, 1);
        Long actualDataResult = newHeadNode.getData();
        int actualListLength = SinglyListNodeOperations.size(newHeadNode);

        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test
    public void shouldDeleteEndNode()
    {
        // Given Data
        SinglyListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        // Expected Result
        Long expectedDataResult = SinglyListNodeOperations.getNode(tenNodes, 8).getData();
        int expectedListLength = 9;

        // Actual Result
        SinglyListNode newHeadNode = SinglyListNodeOperations.delete(tenNodes, 10);
        Long actualDataResult = SinglyListNodeOperations.getNode(newHeadNode, 8).getData();
        int actualListLength = SinglyListNodeOperations.size(newHeadNode);

        // Validation
        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test
    public void shouldDeleteMiddleNode()
    {
        // Given Data
        SinglyListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        // Expected Result of node Six (index: 5) After deletion
        Long expectedDataResult = SinglyListNodeOperations.getNode(tenNodes, 5).getData();
        int expectedListLength = 9;

        // Actual Result
        SinglyListNode newHeadNode = SinglyListNodeOperations.delete(tenNodes, 5);
        Long actualDataResult = SinglyListNodeOperations.getNode(newHeadNode, 4).getData();
        int actualListLength = SinglyListNodeOperations.size(newHeadNode);

        // Validation
        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithPositionErrorOnDeletionOperation()
    {
        SinglyListNode fiveNodes = TestDataCreator.createSinglyListNode(5);

        int position = 30;
        SinglyListNodeOperations.delete(fiveNodes, position);
    }
}