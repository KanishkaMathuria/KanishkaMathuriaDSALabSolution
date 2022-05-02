package com.greatlearning.treesum;

import java.util.HashSet;

public class FindSumPair {

    // this class is calculating the sum in the given tree
    static class Node{
        int nodeData;
        Node leftNode,rightNode;
    }

    static Node newNode(int nodeData){
        Node temp = new Node();
        temp.nodeData = nodeData;
        temp.rightNode = null;
        temp.leftNode = null;

        return temp;
    }

    public Node insert(Node root, int key){

        // method for inserting data to the tree
        if(root == null){
            return newNode(key);
        }
        if(key< root.nodeData){
            root.leftNode = insert(root.leftNode,key);
        }else{
            root.rightNode = insert(root.rightNode,key);
        }
        return root;
    }

    public static void main(String[] args){

        //main method
        Node root = null;
        FindSumPair findSumPair = new FindSumPair();

        //inserting values
        root = findSumPair.insert(root,40);
        root = findSumPair.insert(root,20);
        root = findSumPair.insert(root,60);
        root = findSumPair.insert(root,10);
        root = findSumPair.insert(root,30);
        root = findSumPair.insert(root,50);
        root = findSumPair.insert(root,70);

        int sum = 60;
        findSumPair.findPairWithGivenSum(root,sum);
    }

    public void findPairWithGivenSum(Node root, int sum) {

        // method for finding pair with given sum
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if(!findPairUtil(root,sum,hashSet)){
            System.out.println("Pairs do not exist" + "\n");
        }
    }

    public boolean findPairUtil(Node root, int sum, HashSet<Integer> set){

        // this method traverse in the tree to find the required pair
        if(root==null) {
            return false;
        }
        if(findPairUtil(root.leftNode,sum,set)){
            return true;
        }
        if(set.contains(sum- root.nodeData)){
            System.out.println("Pair is found ("+ (sum- root.nodeData)+", "+ root.nodeData+")");
            return true;
        }else{
            set.add(root.nodeData);
        }
        return findPairUtil(root.rightNode,sum,set);
    }


}
