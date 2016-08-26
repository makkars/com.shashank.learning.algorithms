package com.shashank.learning.algorithms.linkedlist.doubly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;

/**
 * Created by eshmakk on 8/27/2016.
 */
public class DoublyListNode implements ListNode
{
    private long data;
    private DoublyListNode previous;
    private DoublyListNode next;

    public long getData()
    {
        return data;
    }

    public void setData(long data)
    {
        this.data = data;
    }

    public DoublyListNode getPrevious()
    {
        return previous;
    }

    public void setPrevious(DoublyListNode previous)
    {
        this.previous = previous;
    }

    public DoublyListNode getNext()
    {
        return next;
    }

    public void setNext(DoublyListNode next)
    {
        this.next = next;
    }
}
