public interface StringTree {

    public boolean contains(String s);

    // add the string (if not already there)
    // return true if added
    public boolean insert(String s);

    public int size();
}
