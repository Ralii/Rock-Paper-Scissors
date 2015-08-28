package dataStructures;

import junit.framework.TestCase;

public class ShiftingTypeListTest extends TestCase {

    public void testAdd() throws Exception {
        ShiftingTypeList l = new ShiftingTypeList(5);
        l.add(Type.PAPER);
        l.add(Type.PAPER);
        l.add(Type.PAPER);
        l.add(Type.PAPER);
        l.add(Type.PAPER);
        l.add(Type.PAPER);

        assertEquals(5,l.length());
    }

    public void testToTypeList() throws Exception {
        ShiftingTypeList l = new ShiftingTypeList(5);
        l.add(Type.PAPER);
        l.add(Type.PAPER);
        l.add(Type.PAPER);

        assertEquals(Type[].class, l.toTypeList().getClass() );
    }

    public void testLength() throws Exception {
        ShiftingTypeList l = new ShiftingTypeList(5);
        l.add(Type.PAPER);
        l.add(Type.PAPER);
        l.add(Type.PAPER);

        assertEquals(3,l.length());
    }
}