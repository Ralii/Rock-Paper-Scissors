package dataStructures2;

import dataStructures.Type;

/**
 * Created by Ralii on 20.8.15.
 */
public class ShiftingTypeList {
    Type[] list;
    public ShiftingTypeList(int size) {
        this.list = new Type[size];
    }

    public void add(Type t) {
        if(list[list.length -1] != null) { shiftAndInsert(t); }
        else { insert(t); }
    }

    private void shiftAndInsert(Type t) {
        for(int i = 1 ; i < list.length ; i++) {
            list[i-1] = list[i];
        }
        list[list.length -1] = t;
    }
    private void insert(Type t) {
        for(int i = 0 ; i < list.length ; i++) {
            if(list[i] == null) { list[i] = t; return; }
        }
    }

    public Type[] toTypeList(){
        return list;
    }

    public int length(){
        int a = 0;
        for(int i = 0 ; i < list.length ; i++) {
            if(list[i] != null) { a++; }
        }
        System.out.println(a);
        return a;
    }

}
