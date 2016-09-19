package com.shashank.learning.algorithms.linkedlist.circular;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import org.junit.Assert;
import org.junit.Test;

public class CircularListNodeOperationsTest
{

    private final CircularListNodeOperations myCircularListNodeOperations = new CircularListNodeOperations();
    private final static int ONE = 1;
    private final static int FIVE = 5;

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

        CircularListNode headNode = TestDataCreator.createCircularListNode(FIVE);

        // 3rd Node data is expected
        Long expectedResult = headNode.getNext().getNext().getData();

        int nodeIndex = 2;
        Long actualResult = myCircularListNodeOperations.getNode(headNode, nodeIndex).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailAsIndexOutOfRange()
    {
        CircularListNode headNode = TestDataCreator.createCircularListNode(FIVE);

        int nodeIndex = 5;
        myCircularListNodeOperations.getNode(headNode, nodeIndex).getData();
    }

    @Test
    public void shouldInsertOnHead()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(FIVE);
        ListNode nodeToInsert = TestDataCreator.createCircularListNode(ONE);

        Long expectedResult = nodeToInsert.getData();

        ListNode newHeadNode = myCircularListNodeOperations.insertOnHead(headNode, nodeToInsert);

        Long actualResultFirstCheck = myCircularListNodeOperations.getNode(newHeadNode, FIVE).getNext().getData();
        Long actualResultSecondCheck = myCircularListNodeOperations.getNode(newHeadNode, 0).getData();

        Assert.assertEquals(expectedResult, actualResultFirstCheck);
        Assert.assertEquals(expectedResult, actualResultSecondCheck);
    }

    @Test
    public void shouldInsertInTheLast()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(FIVE);
        ListNode nodeToInsert = TestDataCreator.createCircularListNode(ONE);

        Long expectedResult = nodeToInsert.getData();

        ListNode newHeadNode;
        newHeadNode = myCircularListNodeOperations.insertInLast(headNode, nodeToInsert);

        ListNode actualHeadNode = myCircularListNodeOperations.getNode(newHeadNode, 0);
        Long actualResultSecondCheck = myCircularListNodeOperations.getNode(newHeadNode, FIVE).getData();

        Assert.assertEquals(expectedResult, actualResultSecondCheck);
        Assert.assertEquals(headNode.getData(), actualHeadNode.getData());
    }

    @Test
    public void shouldDeleteHead()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(FIVE);

        Long expectedResult = headNode.getNext().getData();
        ListNode newHeadNode = myCircularListNodeOperations.deleteHeadNode(headNode);
        Long actualResultFirstCheck = newHeadNode.getData();

        Assert.assertEquals(expectedResult, actualResultFirstCheck);

        Long actualResultSecondCheck = myCircularListNodeOperations.getNode(newHeadNode, 3).getNext().getData();
        Assert.assertEquals(expectedResult, actualResultSecondCheck);
    }

    @Test
    public void shouldDeleteEndNode()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(FIVE);

        Long expectedResult = headNode.getData();

        ListNode newHeadNode = myCircularListNodeOperations.deleteEndNode(headNode);
        Long actualResult = myCircularListNodeOperations.getNode(newHeadNode, 3).getNext().getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    /**
     * Not working As not handled single node list
     */ public void shouldDeleteEndNodeOfSingleNodeList()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(ONE);
        ListNode newHeadNode = myCircularListNodeOperations.deleteEndNode(headNode);

        // Once implement null check will be toggled
        Assert.assertTrue(newHeadNode != null);
    }

    @Test
    public void shouldInsertNodeInMiddlePosition()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(FIVE);
        ListNode nodeToInsert = TestDataCreator.createCircularListNode(ONE);

        Long expectedData = headNode.getNext().getData();
        ListNode newHeadNode = myCircularListNodeOperations.insertOnPosition(headNode, nodeToInsert, 2);

        Long actualData = myCircularListNodeOperations.getNode(newHeadNode, 2).getData();

        Assert.assertEquals(expectedData, actualData);
    }

    @Test
    public void shouldInsertNodeOnHeadPosition()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(FIVE);
        ListNode nodeToInsert = TestDataCreator.createCircularListNode(ONE);

        Long expectedData = headNode.getData();
        ListNode newHeadNode = myCircularListNodeOperations.insertOnPosition(headNode, nodeToInsert, 1);

        Long actualData = myCircularListNodeOperations.getNode(newHeadNode, 1).getData();

        Assert.assertEquals(expectedData, actualData);
    }

    @Test
    public void shouldInsertNodeOnEndPosition()
    {
        ListNode headNode = TestDataCreator.createCircularListNode(FIVE);
        ListNode nodeToInsert = TestDataCreator.createCircularListNode(ONE);

        Long expectedData = nodeToInsert.getData();
        ListNode newHeadNode = myCircularListNodeOperations.insertOnPosition(headNode, nodeToInsert, 5);

        Long actualData = myCircularListNodeOperations.getNode(newHeadNode, 4).getNext().getData();

        Assert.assertEquals(expectedData, actualData);
    }
}