package com.shashank.learning.algorithms.linkedlist.singly;

import com.shashank.learning.algorithms.linkedlist.api.ListNode;

public class SinglyListNode implements ListNode
{
    private long data;
    private ListNode next;

    public void setData(Long data)
    {
        this.data = data;
    }

    public void setNext(ListNode next)
    {
        this.next = next;
    }

    public long getData()
    {
        return data;
    }

    public ListNode getNext()
    {
        return next;
    }
}
