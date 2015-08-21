package dataStructures;


import exeption.ListFullExeption;

/**
 * Created by Ralii on 18.8.15.
 */
public class FixedNodeList {
    RaliTrieNode[] list;
    int index;
    public FixedNodeList(int size){
        this.list = new RaliTrieNode[size];
        this.index = 0;
    }

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

    public int length(){
        int x = 0;
        for(int i = 0 ; i < list.length ; i++) {
            if(list[i] != null) { x++; }
        }
        return x;
    }

    public RaliTrieNode get(int index) {
        return list[index];
    }
}
