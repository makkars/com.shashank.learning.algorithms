package com.shashank.learning.algorithms.linkedlist.problems;


import com.shashank.learning.algorithms.linkedlist.api.ListNode;
import com.shashank.learning.algorithms.linkedlist.singly.SinglyListNodeOperations;

import java.util.HashMap;
import java.util.Map;

/**
 * This class find convergent node between two {@link com.shashank.learning.algorithms.linkedlist.api.ListNode}
 * Both list can be of same size or different.
 */
public class ConvergentNodeIdentification
{
    /**
     * @param firstList  A ListNode {@link ListNode}
     * @param secondList A ListNode {@link ListNode}
     * @return Convergent ListNode if found else return null.
     * @throws IllegalArgumentException in case any of headNode is null
     */
    public static ListNode getConvergentNodeByEffectiveSolution(ListNode firstList, ListNode secondList)
    {
        ListNode headNodeLongList = firstList;
        ListNode headNodeSmallList = secondList;

        int sizeFirstList = new SinglyListNodeOperations().size(headNodeLongList);
        int sizeSecondList = new SinglyListNodeOperations().size(headNodeSmallList);

        int diff = 0;
        ListNode temp;
        if (sizeFirstList > sizeSecondList)
        {
            diff = sizeFirstList - sizeSecondList;

        } else
        {
            diff = sizeSecondList - sizeFirstList;
            temp = headNodeLongList;
            headNodeLongList = headNodeSmallList;
            headNodeSmallList = temp;
        }

        for (int i = 0; i < diff; i++)
        {
            headNodeLongList = headNodeLongList.getNext();
        }

        while (headNodeLongList != null)
        {
            if (headNodeLongList.getData() == headNodeSmallList.getData())
            {
                return headNodeLongList;
            }

            headNodeLongList = headNodeLongList.getNext();
            headNodeSmallList = headNodeSmallList.getNext();
        }
        return null;
    }

    public static ListNode getConvergentNodeByHashMap(ListNode firstList, ListNode secondList)
    {
        Map<ListNode, Integer> listNodeIntegerHashMap = new HashMap<ListNode, Integer>();

        int positionCounter = 1;
        while (firstList != null)
        {
            listNodeIntegerHashMap.put(firstList, positionCounter);
            firstList = firstList.getNext();
            positionCounter++;
        }

        Integer covergentNodePosition;
        while (secondList != null)
        {
            covergentNodePosition = listNodeIntegerHashMap.get(secondList);
            if (covergentNodePosition != null)
            {
                break;
            }
            secondList = secondList.getNext();
        }

        return secondList;
    }
}