package com.shashank.learning.algorithms.linkedlist.api;

import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by eshmakk on 8/26/2016.
 */
public class TestDataCreator
{
    private static final AtomicLong LAST_TIME_MS = new AtomicLong();

    public static SinglyListNode createSinglyListNode(int numberOfNodes)
    {
        long currentUnixEpochTime = getUnixEpochTime();
        SinglyListNode headNode = new SinglyListNode();
        headNode.setData(currentUnixEpochTime);

        SinglyListNode currentNode = headNode;
        for (int i = 1; i < numberOfNodes; i++)
        {
            SinglyListNode newNode = new SinglyListNode();
            newNode.setData(getUnixEpochTime());
            currentNode.setNext(newNode);
            currentNode = currentNode.getNext();
        }
        return headNode;
    }

    public static long getUnixEpochTime()
    {
        long now = System.currentTimeMillis();
        long lastTime = LAST_TIME_MS.get();

        if(lastTime>= now)
        {
            now = lastTime+1;
        }
        LAST_TIME_MS.set(now);
        return now;
    }
}
