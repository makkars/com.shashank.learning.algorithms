package com.shashank.learning.algorithms.problems;

import com.shashank.learning.algorithms.binarytree.api.Node;

import java.util.LinkedList;
import java.util.List;

public class ComputeLeaves
{

    public static int computeLeavesByMultipleSumOfEachLeaves(Node root)
    {
        int result = 1;

        LinkedList list = new LinkedList();
        list.add(root);

        while (true)
        {
            int nodeCount = list.size();

            int levelSum = 0;
            if (nodeCount == 0)
            {
                break;
            }

            boolean leafFound = false;
            while (nodeCount > 0)
            {
                Node aNode = (Node) list.poll();
                if (isLeaf(aNode))
                {
                    levelSum = levelSum + (Integer) aNode.getData();
                    leafFound = true;
                }
                addANode(list, aNode.getLeft());
                addANode(list, aNode.getRight());
                nodeCount--;
            }

            if (leafFound)
            {
                result *= levelSum;
            }
        }

        return result;
    }

    private static void addANode(List list, Node aNode)
    {
        if (aNode != null)
        {
            list.add(aNode);
        }
    }

    private static boolean isLeaf(Node aNode)
    {
        return ((aNode.getLeft() == null) && (aNode.getRight() == null));
    }

}
