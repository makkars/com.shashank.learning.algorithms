package com.shashank.learning.algorithms.linkedlist.doubly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import org.junit.Assert;
import org.junit.Test;

public class DoublyListNodeOperationsTest
{
    private final ListNodeOperations myDoublyNodeOperationsService = new DoublyListNodeOperations();

    @Test
    public void shouldInsertOnHead()
    {
        ListNode tenNodes = TestDataCreator.createDoublyListNode(10);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = (DoublyListNode) myDoublyNodeOperationsService.insert(tenNodes, nodeToInsert, 1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInTheEnd()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = (DoublyListNode) myDoublyNodeOperationsService.insert(fiveNodes, nodeToInsert, 5);
        Long actualResult = ListNodeOperations.getNode(headNode, 5).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInTheMiddle()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        ListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        ListNode headNode = myDoublyNodeOperationsService.insert(fiveNodes, nodeToInsert, 3);
        Long actualResult = ListNodeOperations.getNode(headNode, 2).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteOnHead()
    {
        ListNode tenNodes = TestDataCreator.createDoublyListNode(10);

        Long expectedResult = tenNodes.getNext().getData();

        ListNode headNode =  myDoublyNodeOperationsService.delete(tenNodes, 1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteEndNode()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        Long expectedResult = ListNodeOperations.getNode(fiveNodes, 3).getData();

        ListNode headNode =  myDoublyNodeOperationsService.delete(fiveNodes, 5);
        Long actualResult = ListNodeOperations.getNode(headNode, 3).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldDeleteInTheMiddle()
    {
        ListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        Long expectedResult = ListNodeOperations.getNode(fiveNodes, 3).getData();

        ListNode headNode = myDoublyNodeOperationsService.delete(fiveNodes, 3);
        Long actualResult = ListNodeOperations.getNode(headNode, 2).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }
}