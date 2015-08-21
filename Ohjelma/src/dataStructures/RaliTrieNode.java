package dataStructures;

/**
 * Trie node used with RaliTrie. Is a single element node of the RaliTrie
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

    /**
     * Add nodes to RaliTrieNode
     * @param newNodes array of RaliTrieNodes.
     */
    public void addNodes(RaliTrieNode[] newNodes){
        isLeaf = false;
        this.nodes = newNodes;
    }

    /**
     * Getter for RaliTrieNode
     * @return returns nodes of the RaliTrieNode
     */
    public RaliTrieNode[] getNodes(){
        return nodes;
    }

    /**
     * Getter for ammount in RaliTrieNode
     * @return Returns the ammount of the current node
     */
    public int getAmmount(){
        return this.ammount;
    }

    /**
     * Setter for the ammount
     * @param a int for setting the ammount
     */
    public void setAmmount(int a) {
        this.ammount = a;
    }

    /**
     * Getter for the value of the RaliTrieNode
     * @return Value of the RaliTrieNode
     */
    public Type getValue(){
        return this.value;
    }

    /**
     * toString method RaliTrieNode
     * @return Returns the Type of the node and ammount
     */
    @Override
    public String toString(){
        return value.toString() + ": " +ammount;
    }
}
