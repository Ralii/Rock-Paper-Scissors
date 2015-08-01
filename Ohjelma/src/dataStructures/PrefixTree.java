package dataStructures;

import dataStructures.Node;

/**
 * Created by Ralii on 31.7.15.
 */
public class PrefixTree {

    private Node first = new Node(Type.PAPER);

    public PrefixTree(int height) {
        init(height, first);
    }

    public Node init(int n, Node node) {
        if (n == 0) {
            return node;
        }

        n-=1;
        node.left = init(n, new Node(Type.PAPER));
        node.center = init(n, new Node(Type.ROCK));
        node.right = init(n, new Node(Type.SCISSORS));

        return node;
    }
}

