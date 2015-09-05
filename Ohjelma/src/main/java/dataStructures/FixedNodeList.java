package dataStructures;


import exeption.ListFullExeption;

/**
 * Fixed size list of trie nodes used with RaliTrie
 */
public class FixedNodeList {
    RaliTrieNode[] list;
    int index;
    public FixedNodeList(int size){
        this.list = new RaliTrieNode[size];
        this.index = 0;
    }

    /**
     * Add RaliTrieNode to FixedNodeList
     * @param t RaliTrieNode to add to FixedNodeList
     * @throws ListFullExeption throws and exception with the fixed size of the list is consumed
     */
    public void add(RaliTrieNode t) throws ListFullExeption {
        if(index < list.length) {
            this.list[index] = t;
            index++;
        } else {
            String message = "The list is full";
            ListFullExeption e = new ListFullExeption(message);
            throw e;
        }
    }

    /**
     * Length of the FixedNodeList
     * @return returns the used length of FixedNodeList not the static limit
     */
    public int length(){
        int x = 0;
        for(int i = 0 ; i < list.length ; i++) {
            if(list[i] != null) { x++; }
        }
        return x;
    }

    /**
     * Getter for RaliTrieNode in FixedNodeList
     * @param index input the wanted index
     * @return returns the RaliTrieNode in the index position
     */
    public RaliTrieNode get(int index) {
        return list[index];
    }
}
