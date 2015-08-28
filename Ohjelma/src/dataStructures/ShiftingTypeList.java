package dataStructures;

import java.io.Serializable;

/**
 * List that shifts elements to the left when it gets full
 */
public class ShiftingTypeList implements Serializable {
    Type[] list;
    public ShiftingTypeList(int size) {
        this.list = new Type[size];
    }

    /**
     * Method for adding a type to the list. Will shift elements if its already full.
     * @param t Type inserted to the list.
     */
    public void add(Type t) {
        if(list[list.length -1] != null) { shiftAndInsert(t); }
        else { insert(t); }
    }

    /**
     * Helper method that handles the shifting of the list.
     * @param t Type for the list to insert.
     */
    private void shiftAndInsert(Type t) {
        for(int i = 1 ; i < list.length ; i++) {
            list[i-1] = list[i];
        }
        list[list.length -1] = t;
    }

    /**
     * Helper method that inserts the Type to the list without shift.
     * @param t Type to be inserted in the list.
     */
    private void insert(Type t) {
        for(int i = 0 ; i < list.length ; i++) {
            if(list[i] == null) { list[i] = t; return; }
        }
    }

    /**
     * Converts the ShiftingTypeList to plain TypeList.
     * @return Returns an array of Types.
     */
    public Type[] toTypeList(){
        return list;
    }

    /**
     * Length of the ShiftingTypeList. Does not indicate the fixed length.
     * @return returns how many elements of list are in use and not null.
     */
    public int length(){
        int a = 0;
        for(int i = 0 ; i < list.length ; i++) {
            if(list[i] != null) { a++; }
        }
        return a;
    }

}
