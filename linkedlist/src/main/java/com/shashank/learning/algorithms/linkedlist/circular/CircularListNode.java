package com.shashank.learning.algorithms.linkedlist.circular;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;

public class CircularListNode implements ListNode
{
    private Long data;
    private ListNode next;

    public long getData()
    {
        return data;
    }

    public void setData(Long data)
    {
        this.data = data;
    }

    public ListNode getNext()
    {
        return next;
    }

    public void setNext(ListNode next)
    {
        this.next = next;
    }
}
