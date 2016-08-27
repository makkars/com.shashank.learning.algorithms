package com.shashank.learning.algorithms.linkedlist.doubly;

import com.shashank.learning.algorithms.linkedlist.api.ListNodeOperations;
import com.shashank.learning.algorithms.linkedlist.api.TestDataCreator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyListNodeOperationsTest
{

    @Test
    public void shouldInsertOnHead()
    {
        DoublyListNode tenNodes = TestDataCreator.createDoublyListNode(10);

        DoublyListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        DoublyListNode headNode = (DoublyListNode) DoublyListNodeOperations.insert(tenNodes, nodeToInsert, 1);
        Long actualResult = headNode.getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInTheEnd()
    {
        DoublyListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        DoublyListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        DoublyListNode headNode = (DoublyListNode) DoublyListNodeOperations.insert(fiveNodes, nodeToInsert, 5);
        Long actualResult = ListNodeOperations.getNode(headNode, 5).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertInTheMiddle()
    {
        DoublyListNode fiveNodes = TestDataCreator.createDoublyListNode(5);

        DoublyListNode nodeToInsert = TestDataCreator.createDoublyListNode(1);
        Long expectedResult = nodeToInsert.getData();

        DoublyListNode headNode = (DoublyListNode) DoublyListNodeOperations.insert(fiveNodes, nodeToInsert, 3);
        Long actualResult = ListNodeOperations.getNode(headNode, 2).getData();

        Assert.assertEquals(expectedResult, actualResult);
    }
}