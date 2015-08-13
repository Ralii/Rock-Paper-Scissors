package dataStructures;

import dataStructures.Node;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by Ralii on 31.7.15.
 */

/*
PrefixTree puurakenne. Käytetään tulosten arviointiin ja ennustamiseen pelin aikana. Puuhun tallennetaan veikattuja sarjoja
ja näitä voidaan haarukoida läpi ja näin tehdä arvauksia koskien pelaajan seuraavaa siirtoa.
 */
public class PrefixTree {
    private boolean isEmpty;
    private Node first = new Node(Type.PAPER);

    public PrefixTree(int height) {
        init(height, first);
        this.isEmpty = true;
    }

    /*
    Initialisointimetodi joka alustaa puun oikeisiin arvioihin arvolle 0. Vasemmalla paperi, keskellä kivi ja oikealla sakset.
    Metodi on rekursiivinen, joten se kutsuu itseään.
     */
    public Node init(int n, Node node) {
        if (n == 0) {
            return node;
        }

        n -= 1;
        node.left = init(n, new Node(Type.PAPER));
        node.center = init(n, new Node(Type.ROCK));
        node.right = init(n, new Node(Type.SCISSORS));

        return node;
    }
    /*
    Metodi joka kutsuu rekursiivista metodia jonka tarkoituksena on lisätä stakin arvojoukon viimeinen arvo puuhun. Tätä arvoa voidaan käyttää
    pelaajan seuraavan siirron arvioinnissa valitsemalla aina suurimman arvon omaava tyyppi samasta joukosta.
     */
    public void addPattern(RaliStack stack) {
        switch (stack.peek()) {
            case PAPER:
                seqAdd(stack, first.left);
                break;
            case ROCK:
                seqAdd(stack, first.center);
                break;
            case SCISSORS:
                seqAdd(stack, first.right);
                break;
        }
    }

    /*
     Metodi, joka kutsuu rekursiivista metodia, jonka tarkoituksena on hakea suurin arvo tietyn jonon päästä seuraavasta arvosta.
     Eli mennään esimerkiksi kivi - paperi - paperi ja katsotaan millä paperin haaroista on suurin arvo. Tällöin voidaan olettaa,
     että pelaaja valitsee jatkossakin saman historian kohdalla arvon, jota on valittu aikaisemmin eniten.
     */
    public Type getPattern(RaliStack stack) {
        switch ( stack.peek() ) {
            case PAPER:
                return seqHighest(stack, first.left);
            case ROCK:
                return seqHighest(stack, first.center);
            case SCISSORS:
                return seqHighest(stack, first.right);
        }
        return Type.PAPER;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
    /*
    Arvonlisäyksen rekursiivinen jatkometodi joka lisää arvon Prefixpuuhun.
     */
    private void seqAdd(RaliStack stack, Node node) {
        if (node.value == stack.peek()) {
            if (stack.size() != 1) {
                stack.pop();
                seqAdd(stack, node.left);
                seqAdd(stack, node.center);
                seqAdd(stack, node.right);

            } else {
                node.ammount += 1;
            }
        }
    }

    /*
    Arvon hakemisen rekursiivinen jatkometodi, joka hakee arvon Prefixpuusta.
     */
    private Type seqHighest(RaliStack stack, Node node) {
        if (node.value == stack.peek()) {
            if (stack.size() != 1) {
                stack.pop();
                seqAdd(stack, node.left);
                seqAdd(stack, node.center);
                seqAdd(stack, node.right);

            } else {
                int a = node.left.ammount;
                int b = node.center.ammount;
                int c = node.right.ammount;

                if(a > b && a > c) { return node.left.value; }
                if(b > a && b > c) { return node.center.value; }
                if(c > a && c > b) { return node.right.value; }
            }
        }
        return Type.PAPER;
    }

}

