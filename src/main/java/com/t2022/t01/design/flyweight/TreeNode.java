package com.t2022.t01.design.flyweight;

import lombok.Data;

@Data
public class TreeNode {

    private int x ;
    private int y ;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }


}
