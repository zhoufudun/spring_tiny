package com.t2022.t01.design.flyweight;

public class Flyweight {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3,4, TreeFactory.getTree("xxx","xxxxxxxx"));
        TreeNode treeNode2 = new TreeNode(5,4, TreeFactory.getTree("xxx","xxxxxxxx"));
        TreeNode treeNode3 = new TreeNode(13,24, TreeFactory.getTree("yyy","xxxxxxxx"));
        TreeNode treeNode4 = new TreeNode(15,24, TreeFactory.getTree("yyy","xxxxxxxx"));

    }
}
