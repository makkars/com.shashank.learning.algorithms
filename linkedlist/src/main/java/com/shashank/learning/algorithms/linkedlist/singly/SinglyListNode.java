package com.shashank.learning.algorithms.linkedlist.singly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;

/**
 * Created by eshmakk on 8/26/2016.
 */
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
