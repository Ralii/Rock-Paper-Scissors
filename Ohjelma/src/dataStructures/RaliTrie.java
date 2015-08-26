package dataStructures;

import exeption.ListFullExeption;

import java.io.Serializable;
import java.util.Random;

/**
 * Custom Trie that follows the basic structure of a Trie but has distinct methods of it's own.
 */
public class RaliTrie implements Serializable {
    RaliTrieNode first;

    public RaliTrie(int height) {

        this.first = new RaliTrieNode(Type.PAPER);
        init(height, this.first);
    }

    /**
     * Initializing the RaliTrie and it's values.
     * @param height Defines the height of the RaliTrie and is -1 height because of the unused rootnode.
     * @param node Rootnode of the RaliTrie.
     */
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

    /**
     * Add values to the RaliTrie
     * @param arr Requires an array of Types.
     */
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

    /**
     * Helper method for add. Handles the recursive insert part.
     * @param arr Array of Types.
     * @param index Index of array. Required for recursion to know the right value.
     * @param node Current node for the recursive method.
     * @param firstPass Indication whether the index should be raised at the first pass.
     */
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

    /**
     * Get estimation of the most used Type in continuation of the combination.
     * @param arr Array of Types.
     * @return The Types in the last node.
     * @throws ListFullExeption throws exeption if the fixed size list is full.
     */
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

    /**
     * Helper method for getEstimate. Handles the recursive insert part.
     * @param arr Array of Types.
     * @param index Index of array. Required for recursion to know the right value.
     * @param node Current node for the recursive method.
     * @param firstPass Indication whether the index should be raised at the first pass.
     * @throws ListFullExeption throws exeption if the fixed size list is full.
     */
    private FixedNodeList getRec(Type[] arr, int index, RaliTrieNode node, FixedNodeList list, Boolean firstPass) throws ListFullExeption {
        if (index == arr.length - 3 && arr[index].equals(node.getValue())) {
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

    /**
     * Helper method for getEstimate. Used for comparing the return values.
     * @param l FixedNodeList that holds the node values from the recursive method.
     * @return returns the node which has the biggest value in FixedNodeList.
     */
    private Type findBiggest(FixedNodeList l) {
        if (l.get(0).getAmmount() > l.get(1).getAmmount() && l.get(0).getAmmount() > l.get(2).getAmmount()) {
            return l.get(0).getValue().losesTo;
        }
        if (l.get(1).getAmmount() > l.get(0).getAmmount() && l.get(1).getAmmount() > l.get(2).getAmmount()) {
            return l.get(1).getValue().losesTo;
        }
        if (l.get(2).getAmmount() > l.get(1).getAmmount() && l.get(2).getAmmount() > l.get(0).getAmmount()) {
            return l.get(2).getValue().losesTo;
        }
        return randomize();
    }

    private Type randomize(){
        Random r = new Random();
        int a = r.nextInt(3);
        if(a == 0) { return Type.PAPER; }
        if(a == 1) { return Type.ROCK; }
        if(a == 2) { return Type.SCISSORS; }
        return null;
    }
}


