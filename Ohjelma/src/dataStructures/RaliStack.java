package dataStructures;

/**
 * Created by Ralii on 9.8.15.
 */
public class RaliStack {
    Type[] arr;
    int acc;
    int decc;

    public RaliStack(){
        this.arr = new Type[3];
        this.acc = 0;
        this.decc = 3;
    }
    // Arvon laittaminen taulukkoon
    public void insert(Type t){

        if(acc == 3) {
            acc = 0;
            for(Type type : arr) { type = null; }
            arr[0] = t;
            return;
        }
        if( arr[acc] == null ) { arr[acc] = t; acc = 0; return;  }

        acc++;
        insert(t);
    }

    // Viimeisimmän arvon katsominen taulukosta.
    public Type peek(){
        if(decc == 0) { decc = 3; return null; }
        if(arr[decc] != null) {int d = decc; decc = 3 ; return arr[d]; }
        else { decc--; peek(); }
        return null;
    }

    // "Poppaa" päällimmäisen, tässä tapauksessa perimmäisen arvon pois taulukosta.
    public Type pop(){
        if(decc == 0) { decc = 3; return null; }
        if(arr[decc] != null) {
            int d = decc;
            decc = 3 ;
            Type poppable = arr[d];
            arr[d] = null;
            return poppable;
        }
        else { decc--; peek(); }
        return null;
    }
}
