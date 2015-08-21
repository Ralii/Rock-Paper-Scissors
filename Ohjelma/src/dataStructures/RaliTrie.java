package dataStructures;

import exeption.ListFullExeption;

/**
 * Created by Ralii on 18.8.15.
 */
public class RaliTrie {
    RaliTrieNode first;

    public RaliTrie(int height) {

        this.first = new RaliTrieNode(Type.PAPER);
        init(height, this.first);
    }

    private void init(int height, RaliTrieNode node) {
        if (height == 0) {
            return;
        }

        RaliTrieNode[] nodes = new RaliTrieNode[3];
        nodes[0] = new RaliTrieNode(Type.PAPER);
        nodes[1] = new RaliTrieNode(Type.ROCK);
        nodes[2] = new RaliTrieNode(Type.SCISSORS);

        node.addNodes(nodes);
        height--;

        for (int i = 0; i < nodes.length; i++) {
            init(height, nodes[i]);
        }
    }

    public void add(Type[] arr) {
        Boolean firstPass = true;
        switch (arr[0]) {
            case PAPER:
                addRec(arr, 0, first.getNodes()[0], firstPass);
            case ROCK:
                addRec(arr, 0, first.getNodes()[1], firstPass);
            case SCISSORS:
                addRec(arr, 0, first.getNodes()[2], firstPass);
        }
    }

    private void addRec(Type[] arr, int index, RaliTrieNode node, Boolean firstPass) {
        if (arr[index].equals(node.getValue())) {
            if (!firstPass) {
                index++;
            }
            if (index == arr.length - 1 || arr[index] == null) {
                node.setAmmount(node.getAmmount() + 1);
            } else {

                firstPass = false;
                if (arr[index].equals(node.getNodes()[0].getValue())) {
                    addRec(arr, index, node.getNodes()[0], firstPass);
                }
                if (arr[index].equals(node.getNodes()[1].getValue())) {
                    addRec(arr, index, node.getNodes()[1], firstPass);
                }
                if (arr[index].equals(node.getNodes()[2].getValue())) {
                    addRec(arr, index, node.getNodes()[2], firstPass);
                }
            }
        }
    }

    public Type getEstimate(Type[] arr) throws ListFullExeption {
        Boolean firstPass = true;
        switch (arr[0]) {
            case PAPER:
                FixedNodeList a = getRec(arr, 0, first.getNodes()[0], new FixedNodeList(3), firstPass);
                return findBiggest(a);
            case ROCK:
                FixedNodeList b = getRec(arr, 0, first.getNodes()[1], new FixedNodeList(3), firstPass);
                return findBiggest(b);
            case SCISSORS:
                FixedNodeList c = getRec(arr, 0, first.getNodes()[2], new FixedNodeList(3), firstPass);
                return findBiggest(c);
        }
        return null;
    }

    private FixedNodeList getRec(Type[] arr, int index, RaliTrieNode node, FixedNodeList list, Boolean firstPass) throws ListFullExeption {
        if (index == arr.length - 2 && arr[index].equals(node.getValue())) {
            list.add(node.getNodes()[0]);
            list.add(node.getNodes()[1]);
            list.add(node.getNodes()[2]);
            return list;
        }
        if (!firstPass) {
            index++;
        }
        firstPass = false;
        for (int i = 0; i < node.getNodes().length; i++) {
            if (node.getNodes()[i]
                    .getValue()
                    .equals(arr[index])
                    ) {
                getRec(arr, index, node.getNodes()[i], list, firstPass);
            }
        }
        return list;
    }

    private Type findBiggest(FixedNodeList l) {
        if (l.get(0).getAmmount() > l.get(1).getAmmount() && l.get(0).getAmmount() > l.get(2).getAmmount()) {
            return l.get(0).getValue();
        }
        if (l.get(1).getAmmount() > l.get(0).getAmmount() && l.get(1).getAmmount() > l.get(2).getAmmount()) {
            return l.get(1).getValue();
        }
        if (l.get(2).getAmmount() > l.get(1).getAmmount() && l.get(2).getAmmount() > l.get(0).getAmmount()) {
            return l.get(2).getValue();
        }
        return l.get(0).getValue();
    }
}


