package com.shashank.learning.algorithms.linkedlist.singly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import org.junit.Assert;
import org.junit.Test;

public class SinglyListNodeOperationsTest
{
    private final SinglyListNodeOperations mySinglyNodeOperationsService = new SinglyListNodeOperations();

    @Test
    public void listLength() throws Exception
    {
        SinglyListNode headNode = new SinglyListNode();
        SinglyListNode secondNode = new SinglyListNode();

        headNode.setData(1L);
        headNode.setNext(secondNode);
        secondNode.setData(2L);

        Integer expectedResult = 2;
        Integer actualResult = mySinglyNodeOperationsService.size(headNode);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnZeroOnListLength()
    {
        Integer actualResult = mySinglyNodeOperationsService.size(null);
    }

    @Test
    public void shouldInsertOnHead()
    {
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = mySinglyNodeOperationsService.insertAtPosition(tenNodes, nodeToInsert, 1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertOnHeadSimple()
    {
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = mySinglyNodeOperationsService.insertOnHead(tenNodes, nodeToInsert);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInEnd()
    {
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int size = mySinglyNodeOperationsService.size(tenNodes);
        int endPosition = size + 1;
        ListNode headNode = mySinglyNodeOperationsService.insertAtPosition(tenNodes, nodeToInsert, endPosition);

        int indexOfPosition = size;
        ListNode endNode = mySinglyNodeOperationsService.getNode(headNode, indexOfPosition);

        Long actualResult = endNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInEndSimple()
    {
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int size = mySinglyNodeOperationsService.size(tenNodes);
        ListNode headNode = mySinglyNodeOperationsService.insertInLast(tenNodes, nodeToInsert);

        int indexOfPosition = size;
        ListNode endNode = mySinglyNodeOperationsService.getNode(headNode, indexOfPosition);

        Long actualResult = endNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertAtPositionValue()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);

        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int position = 3;
        ListNode headNode = mySinglyNodeOperationsService.insertAtPosition(fiveNodes, nodeToInsert, position);

        int indexOfNode = 2;
        ListNode middleNode = mySinglyNodeOperationsService.getNode(headNode, indexOfNode);

        Long actualResult = middleNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithPositionErrorOnInsertionOperation()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);

        int position = 30;
        mySinglyNodeOperationsService.insertAtPosition(fiveNodes, nodeToInsert, position);
    }

    @Test
    public void shouldDeleteOnHead()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        Long expectedDataResult = fiveNodes.getNext().getData();
        int expectedListLength = 4;

        ListNode newHeadNode = mySinglyNodeOperationsService.deleteOnPosition(fiveNodes, 1);
        Long actualDataResult = newHeadNode.getData();
        int actualListLength = mySinglyNodeOperationsService.size(newHeadNode);

        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test
    public void shouldDeleteHead()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        Long expectedDataResult = fiveNodes.getNext().getData();
        int expectedListLength = 4;

        ListNode newHeadNode = mySinglyNodeOperationsService.deleteHeadNode(fiveNodes);
        Long actualDataResult = newHeadNode.getData();
        int actualListLength = mySinglyNodeOperationsService.size(newHeadNode);

        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test
    public void shouldDeleteEndNode()
    {
        // Given Data
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        // Expected Result
        Long expectedDataResult = mySinglyNodeOperationsService.getNode(tenNodes, 8).getData();
        int expectedListLength = 9;

        // Actual Result
        ListNode newHeadNode = mySinglyNodeOperationsService.deleteOnPosition(tenNodes, 10);
        Long actualDataResult = mySinglyNodeOperationsService.getNode(newHeadNode, 8).getData();
        int actualListLength = mySinglyNodeOperationsService.size(newHeadNode);

        // Validation
        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test
    public void shouldDeleteEndNodeSimple()
    {
        // Given Data
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        // Expected Result
        Long expectedDataResult = mySinglyNodeOperationsService.getNode(tenNodes, 8).getData();
        int expectedListLength = 9;

        // Actual Result
        ListNode newHeadNode = mySinglyNodeOperationsService.deleteEndNode(tenNodes);
        Long actualDataResult = mySinglyNodeOperationsService.getNode(newHeadNode, 8).getData();
        int actualListLength = mySinglyNodeOperationsService.size(newHeadNode);

        // Validation
        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test
    public void shouldDeleteMiddleNode()
    {
        // Given Data
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        // Expected Result of node Six (index: 5) After deletion
        Long expectedDataResult = mySinglyNodeOperationsService.getNode(tenNodes, 5).getData();
        int expectedListLength = 9;

        // Actual Result
        ListNode newHeadNode = mySinglyNodeOperationsService.deleteOnPosition(tenNodes, 5);
        Long actualDataResult = mySinglyNodeOperationsService.getNode(newHeadNode, 4).getData();
        int actualListLength = mySinglyNodeOperationsService.size(newHeadNode);

        // Validation
        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithPositionErrorOnDeletionOperation()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);

        int position = 30;
        mySinglyNodeOperationsService.deleteOnPosition(fiveNodes, position);
    }
}