package com.shashank.learning.algorithms.problems;

import com.shashank.learning.algorithms.binarytree.api.Node;
import org.junit.Assert;
import org.junit.Test;

public class ComputeLeafs
{

    @Test
    public void computeSum()
    {
        Node<Integer> root = getNodeWithData(1);
        root.setLeft(getNodeWithData(2));
        root.setRight(getNodeWithData(3));

        root.getLeft().setLeft(getNodeWithData(4));

        int expectedValue = 12;

        Assert.assertEquals(expectedValue, ComputeLeaves.computeLeavesByMultipleSumOfEachLeaves(root));
    }

    private Node<Integer> getNodeWithData(int data)
    {
        Node<Integer> aNode = new Node<>();
        aNode.setData(data);
        return aNode;
    }
}
