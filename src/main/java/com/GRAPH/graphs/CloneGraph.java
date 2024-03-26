package com.GRAPH.graphs;

//https://leetcode.com/problems/clone-graph/ ACCEPTED

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        System.out.println(cloneGraph(new Node(1)));

    }

    public static Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Integer,Node> cloneMap = new HashMap<>();
        return cloneGraph(node,cloneMap);
    }

    static Node cloneGraph(Node node,  Map<Integer,Node> cloneMap){
        if(cloneMap.containsKey(node.val)) return cloneMap.get(node.val);
        Node copy = new Node(node.val);
        cloneMap.put(node.val, copy);
        for(Node neigh: node.neighbors){
            copy.neighbors.add(cloneGraph(neigh,cloneMap));
        }
        return copy;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", neighbors=" + neighbors +
                '}';
    }
}