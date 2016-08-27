package com.shashank.learning.algorithms.linkedlist.singly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;
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
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = mySinglyNodeOperationsService.insert(tenNodes, nodeToInsert, 1);
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

        int size = SinglyListNodeOperations.size(tenNodes);
        int endPosition = size + 1;
        ListNode headNode = mySinglyNodeOperationsService.insert(tenNodes, nodeToInsert, endPosition);

        int indexOfPosition = size;
        ListNode endNode = ListNodeOperations.getNode(headNode, indexOfPosition);

        Long actualResult = endNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInEndSimple()
    {
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int size = SinglyListNodeOperations.size(tenNodes);
        ListNode headNode = mySinglyNodeOperationsService.insertInLast(tenNodes, nodeToInsert);

        int indexOfPosition = size;
        ListNode endNode = ListNodeOperations.getNode(headNode, indexOfPosition);

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
        ListNode headNode = mySinglyNodeOperationsService.insert(fiveNodes, nodeToInsert, position);

        int indexOfNode = 2;
        ListNode middleNode = ListNodeOperations.getNode(headNode, indexOfNode);

        Long actualResult = middleNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithPositionErrorOnInsertionOperation()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        ListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);

        int position = 30;
        mySinglyNodeOperationsService.insert(fiveNodes, nodeToInsert, position);
    }

    @Test
    public void shouldDeleteOnHead()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        Long expectedDataResult = fiveNodes.getNext().getData();
        int expectedListLength = 4;

        ListNode newHeadNode = mySinglyNodeOperationsService.delete(fiveNodes, 1);
        Long actualDataResult = newHeadNode.getData();
        int actualListLength = ListNodeOperations.size(newHeadNode);

        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test
    public void shouldDeleteEndNode()
    {
        // Given Data
        ListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        // Expected Result
        Long expectedDataResult = ListNodeOperations.getNode(tenNodes, 8).getData();
        int expectedListLength = 9;

        // Actual Result
        ListNode newHeadNode = mySinglyNodeOperationsService.delete(tenNodes, 10);
        Long actualDataResult = ListNodeOperations.getNode(newHeadNode, 8).getData();
        int actualListLength = ListNodeOperations.size(newHeadNode);

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
        Long expectedDataResult = ListNodeOperations.getNode(tenNodes, 5).getData();
        int expectedListLength = 9;

        // Actual Result
        ListNode newHeadNode = mySinglyNodeOperationsService.delete(tenNodes, 5);
        Long actualDataResult = ListNodeOperations.getNode(newHeadNode, 4).getData();
        int actualListLength = ListNodeOperations.size(newHeadNode);

        // Validation
        Assert.assertEquals(expectedDataResult, actualDataResult);
        Assert.assertEquals(expectedListLength, actualListLength);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithPositionErrorOnDeletionOperation()
    {
        ListNode fiveNodes = TestDataCreator.createSinglyListNode(5);

        int position = 30;
        mySinglyNodeOperationsService.delete(fiveNodes, position);
    }
}