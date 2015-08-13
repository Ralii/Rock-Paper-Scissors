package dataStructures;

/**
 * Created by Ralii on 9.8.15.
 */
public class RaliStack {
    protected Type[] arr;
    int acc;
    int decc;

    public RaliStack(){
        this.arr = new Type[4];
        this.acc = 3;
        this.decc = 0;
    }

    public RaliStack(RaliStack newStack){
        if(newStack != null) {
            for(int x = 0 ; x < newStack.arr.length -1 ; x++){
                if(newStack.arr[x] != null) {arr[x] = newStack.arr[x]; }
            }
        }
    }

    // Arvon laittaminen taulukkoon
    public void insert(Type t){
        if(arr[0] != null) { nullArr(); }
        for(int x = 0 ; x < arr.length -1 ; x++) {
            if(arr[x] == null) { arr[x] = t; }
        }
    }

    // Viimeisimmän arvon katsominen taulukosta.
    public Type peek(){
        for(int x = arr.length -1 ; x > 0 ; x--) {
            if(arr[x] != null) { return arr[x]; }
        }
        return null;
    }

    // "Poppaa" päällimmäisen, tässä tapauksessa perimmäisen arvon pois taulukosta.
    public Type pop(){
        for(int x = arr.length -1 ; x > 0 ; x--) {
            if(arr[x] != null) {
                Type t = arr[x];
                arr[x] = null;
                return t;
            }
        }
        return null;
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
