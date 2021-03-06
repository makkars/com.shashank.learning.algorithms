package com.shashank.learning.algorithms.linkedlist.doubly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import org.junit.Assert;
import org.junit.Test;

public class DoublyListNodeOperationsTest
{
    private final DoublyListNodeOperations myDoublyNodeOperationsService = new DoublyListNodeOperations();

    @Test
    public void shouldInsertOnHead()
    {
        ListNode tenNodes = TestDataCreator.createDoublyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = myDoublyNodeOperationsService.insertAtPosition(tenNodes, nodeToInsert, 1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertOnHeadSimple()
    {
        ListNode tenNodes = TestDataCreator.createDoublyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = myDoublyNodeOperationsService.insertOnHead(tenNodes, nodeToInsert);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInTheEnd()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = myDoublyNodeOperationsService.insertAtPosition(fiveNodes, nodeToInsert, 5);
        Long actualResult = myDoublyNodeOperationsService.getNode(headNode, 5).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInTheEndSimple()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = myDoublyNodeOperationsService.insertInLast(fiveNodes, nodeToInsert);
        Long actualResult = myDoublyNodeOperationsService.getNode(headNode, 5).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInTheMiddle()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = myDoublyNodeOperationsService.insertAtPosition(fiveNodes, nodeToInsert, 3);
        Long actualResult = myDoublyNodeOperationsService.getNode(headNode, 2).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteOnHead()
    {
        ListNode tenNodes = TestDataCreator.createDoublyListNode(10);

        Long expectedResult = tenNodes.getNext().getData();

        ListNode headNode = myDoublyNodeOperationsService.deleteOnPosition(tenNodes, 1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteHead()
    {
        ListNode tenNodes = TestDataCreator.createDoublyListNode(10);

        Long expectedResult = tenNodes.getNext().getData();

        ListNode headNode = myDoublyNodeOperationsService.deleteHeadNode(tenNodes);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteEndNode()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        Long expectedResult = myDoublyNodeOperationsService.getNode(fiveNodes, 3).getData();

        ListNode headNode = myDoublyNodeOperationsService.deleteOnPosition(fiveNodes, 5);
        Long actualResult = myDoublyNodeOperationsService.getNode(headNode, 3).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteEndNodeSimple()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        Long expectedResult = myDoublyNodeOperationsService.getNode(fiveNodes, 3).getData();

        ListNode headNode = myDoublyNodeOperationsService.deleteEndNode(fiveNodes);
        Long actualResult = myDoublyNodeOperationsService.getNode(headNode, 3).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteInTheMiddle()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        Long expectedResult = myDoublyNodeOperationsService.getNode(fiveNodes, 3).getData();

        ListNode headNode = myDoublyNodeOperationsService.deleteOnPosition(fiveNodes, 3);
        Long actualResult = myDoublyNodeOperationsService.getNode(headNode, 2).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }
}