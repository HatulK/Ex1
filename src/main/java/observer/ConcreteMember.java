package observer;


public class ConcreteMember implements Member {
    /**
     * defining a data member from type UndoableStringBuilder
     */
    UndoableStringBuilder undostring;

    /**
     * an empty constructor
     */
    public ConcreteMember() {}

    /**
     * @param usb an UndoableStringBuilder
     * updating an UndoableStringBuilder
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.undostring=usb;
    }

}
