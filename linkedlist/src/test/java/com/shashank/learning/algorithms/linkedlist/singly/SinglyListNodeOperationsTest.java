package com.shashank.learning.algorithms.linkedlist.singly;

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
        SinglyListNode headNode = new SinglyListNode(1);
        SinglyListNode secondNode = new SinglyListNode(2);
        headNode.setNext(secondNode);

        Integer expectedResult = 2;
        Integer actualResult = SinglyListNodeOperations.listLength(headNode);

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void shouldReturnZeroOnListLength()
    {
        Integer expectedResult = 0;
        Integer actualResult = SinglyListNodeOperations.listLength(null);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void shouldInsertOnHead()
    {
        SinglyListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        SinglyListNode headNode = SinglyListNodeOperations.insertionOperation(tenNodes,nodeToInsert,1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public  void shouldInsertInEnd()
    {
        SinglyListNode tenNodes = TestDataCreator.createSinglyListNode(10);

        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int size = SinglyListNodeOperations.listLength(tenNodes);
        int endPosition = size+1;
        SinglyListNode headNode = SinglyListNodeOperations.insertionOperation(tenNodes,nodeToInsert,endPosition);

        int indexOfPosition=size;
        SinglyListNode endNode = SinglyListNodeOperations.getNode(headNode,indexOfPosition);

        Long actualResult = endNode.getData();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void shouldInsertAtPositionValue()
    {
        SinglyListNode fiveNodes = TestDataCreator.createSinglyListNode(5);

        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        int position = 3;
        SinglyListNode headNode = SinglyListNodeOperations.insertionOperation(fiveNodes,nodeToInsert,position);

        int indexOfNode = 2;
        SinglyListNode middleNode = SinglyListNodeOperations.getNode(headNode,indexOfNode);

        Long actualResult = middleNode.getData();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWithPositionError()
    {
        SinglyListNode fiveNodes = TestDataCreator.createSinglyListNode(5);
        SinglyListNode nodeToInsert = TestDataCreator.createSinglyListNode(1);

        int position = 30;
        SinglyListNodeOperations.insertionOperation(fiveNodes,nodeToInsert,position);
    }
}