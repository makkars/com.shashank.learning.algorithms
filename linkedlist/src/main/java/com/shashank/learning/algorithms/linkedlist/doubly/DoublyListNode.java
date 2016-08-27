package com.shashank.learning.algorithms.linkedlist.doubly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;

public class DoublyListNode implements ListNode
{
    private long data;
    private DoublyListNode previous;
    private DoublyListNode next;

    public long getData()
    {
        return data;
    }

    public void setData(Long data)
    {
        this.data = data;
    }

    public DoublyListNode getPrevious()
    {
        return previous;
    }

    public void setPrevious(ListNode previous)
    {
        this.previous = (DoublyListNode) previous;
    }

    public DoublyListNode getNext()
    {
        return next;
    }

    public void setNext(ListNode next)
    {
        this.next = (DoublyListNode) next;
    }
}
