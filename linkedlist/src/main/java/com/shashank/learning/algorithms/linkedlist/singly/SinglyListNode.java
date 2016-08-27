package com.shashank.learning.algorithms.linkedlist.singly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;

public class SinglyListNode implements ListNode
{
    private long data;
    private SinglyListNode next;

    public void setData(long data)
    {
        this.data = data;
    }

    public void setNext(SinglyListNode next)
    {
        this.next = next;
    }

    public long getData()
    {
        return data;
    }

    public SinglyListNode getNext()
    {
        return next;
    }
}
