package dataStructures;

/**
 * Created by Ralii on 18.8.15.
 */
public class RaliTrieNode {
    public boolean isLeaf;
    public RaliTrieNode[] nodes;
    private final Type value;
    private int ammount;

    public RaliTrieNode(Type value){
        this.isLeaf = true;
        this.value = value;
        this.ammount = 0;
    }

    public void addNodes(RaliTrieNode[] newNodes){
        isLeaf = false;
        this.nodes = newNodes;
    }

    public RaliTrieNode[] getNodes(){
        return nodes;
    }
    public int getAmmount(){
        return this.ammount;
    }
    public void setAmmount(int a) {
        this.ammount = a;
    }
    public Type getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return value.toString() + ": " +ammount;
    }
}
