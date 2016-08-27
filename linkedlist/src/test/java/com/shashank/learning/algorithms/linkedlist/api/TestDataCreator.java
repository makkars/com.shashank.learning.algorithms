package com.shashank.learning.algorithms.linkedlist.api;

import com.shashank.learning.algorithms.linkedlist.doubly.DoublyListNode;
import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNode;

import java.util.concurrent.atomic.AtomicLong;

public class TestDataCreator
{
    private static final AtomicLong LAST_TIME_MS = new AtomicLong();

    public static ListNode createSinglyListNode(int numberOfNodes)
    {
        long currentUnixEpochTime = getUnixEpochTime();
        ListNode headNode = new SinglyListNode();
        headNode.setData(currentUnixEpochTime);

        ListNode currentNode = headNode;
        for (int i = 1; i < numberOfNodes; i++)
        {
            SinglyListNode newNode = new SinglyListNode();
            newNode.setData(getUnixEpochTime());
            currentNode.setNext(newNode);
            currentNode = currentNode.getNext();
        }
        return headNode;
    }

    public static DoublyListNode createDoublyListNode(int numberOfNodes)
    {
        long currentUnixEpochTime = getUnixEpochTime();
        DoublyListNode headNode = new DoublyListNode();
        headNode.setData(currentUnixEpochTime);

        DoublyListNode currentNode = headNode;
        for (int i = 1; i < numberOfNodes; i++)
        {
            DoublyListNode newNode = new DoublyListNode();

            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
            newNode.setData(getUnixEpochTime());

            currentNode=currentNode.getNext();
        }
        return  headNode;
    }

    public static long getUnixEpochTime()
    {
        long now = System.currentTimeMillis();
        long lastTime = LAST_TIME_MS.get();

        if (lastTime >= now)
        {
            now = lastTime + 1;
        }
        LAST_TIME_MS.set(now);
        return now;
    }
}
