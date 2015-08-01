package dataStructures;

/**
 * Created by Ralii on 31.7.15.
 */
public class Node {
    Type value;

    public Node left = null;
    public Node center = null;
    public Node right = null;

    public Node(Type value){
        this.value = value;
    }
}
