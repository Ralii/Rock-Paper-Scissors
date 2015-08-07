package dataStructures;

/**
 * Created by Ralii on 31.7.15.
 */

/*
PrefixTreen solmuluokka. Jokainen muistaa oman arvonsa ja omat haaransa (vasen, kesk, oikea).
 */
public class Node {
    public Type value;
    public Node left;
    public Node center;
    public Node right;
    public int ammount;

    /*
    Solmuluokan konstruktori. Ensialustus arvolle nollaan ja referensseille null.
     Arvot asetetaan myöhemmin koko puun luontivaiheessa.
     */
    public Node(Type value){
        this.value = value;

        this.left = null;
        this.center = null;
        this.right = null;
        this.ammount = 0;

    }
}
