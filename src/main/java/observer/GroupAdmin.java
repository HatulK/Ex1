package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {

    /**
     * a list data members from type Member.
     */
    private List<Member> list;
    /**
     * define a data member from type UndoableStringBuilder
     */
    private UndoableStringBuilder undostring;


    /**
     * A constructor
     */
    public GroupAdmin() {
        this.list = new ArrayList<>();
        this.undostring = new UndoableStringBuilder();
    }

    /**
     * @return this list
     */
    public List<Member> getList() {
        return list;
    }

    /**
     * @return UndoableStringBuilder data
     */
    public UndoableStringBuilder getUndostring() {
        return undostring;
    }


    /**
     * @param obj  a Member from the observed list
     * adding an object to the observed list
     */
    @Override
    public void register(Member obj) {
        if (obj == null) return;
        list.add(obj);
    }

    /**
     * @param obj a Member from the observed list
     * removing an object to the observed list
     */
    @Override
    public void unregister(Member obj) {
        if (obj == null) return;
        list.remove(obj);
    }

    /**
     * @param offset an offset to locate the obj in the UndoableStringBuilder
     * @param obj a string to insert to the UndoableStringBuilder
     * return UndoableStringBuilder
     */
    @Override
    public void insert(int offset, String obj) {
        undostring.insert(offset, obj);
        updateAll();
    }

    /**
     * @param obj a string to be appended
     * adding to the end of the UndoableStringBuilder the obj
     */
    @Override
    public void append(String obj) {
        undostring.append(obj);
        updateAll();
    }

    /**
     * @param start an index in the UndoableStringBuilder
     * @param end an index in the UndoableStringBuilder
     *  deleting characters from the UndoableStringBuilder from start to end index
     */
    @Override
    public void delete(int start, int end) {
        undostring.delete(start, end);
        updateAll();
    }

    /**
     * undoing the last change done
     */
    @Override
    public void undo() {
        undostring.undo();
        updateAll();
    }

    /**
     * updating all the observed list
     */
    public void updateAll() {
        for (Member obj : list) {
            obj.update(undostring);
        }
    }

    /**
     * @return UndoableStringBuilder
     */
    @Override
    public String toString() {
        return undostring.toString();
    }
}
