package dataStructures;

/**
 * Created by Ralii on 9.8.15.
 */
public class RaliStack {
    public Type[] arr;
    int acc;
    int decc;
    Type last;

    public RaliStack(){
        this.arr = new Type[4];
        this.acc = 3;
        this.decc = 0;
        nullArr();
    }

    public RaliStack(RaliStack newStack){
        this();
        if(newStack != null && newStack.arr != null && newStack.arr.length > 1) {
            for(int x = 0 ; x < newStack.arr.length -1 ; x++){
                if(newStack.arr[x] != null) {arr[x] = newStack.arr[x]; }
            }
        }
    }

    // Arvon laittaminen taulukkoon
    // Laitetaan ensimmäiseen nulliin arvo. Loopataan alusta loppuun.
    public void insert(Type t){
        if(arr[3] != null) { nullArr(); }
        for(int x = 0 ; x < arr.length -1 ; x++) {
            if(arr[x] == null) { arr[x] = t; return; }
        }
    }

    // Viimeisimmän arvon katsominen taulukosta.
    // Haetaan ensimmäinen ei-null arvo. Loopataan lopusta alkuun.
    public Type peek(){
        for(int x = arr.length -1 ; x > -1 ; x--) {
            if(arr[x] != null) { return arr[x]; }
        }
        return null;
    }

    // "Poppaa" päällimmäisen, tässä tapauksessa perimmäisen arvon pois taulukosta.
    public Type pop(){
        for(int x = arr.length -1 ; x > -1 ; x--) {
            if(arr[x] != null) {
                Type t = arr[x];
                arr[x] = null;
                return t;
            }
        }
        return null;
    }
    public Type last(){
        return last;
    }

    // Stackin koon laskeminen.
    public int size(){
        int s = 0;
        for(int x = 0 ; x < arr.length -1 ; x++) {
            if(arr[x] != null ) { s++;}
        }
        return s;
    }

    private void nullArr(){
        for(int i = 0 ; i < arr.length -1 ; i++) {
            arr[i] = null;
        }
    }

}
