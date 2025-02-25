public interface StringSet {
    public boolean containsString(String s);

    //adds string if not already present
    //guarantees no duplicates
    public void addString(String s);

    //number of strings in set
    public int size();
}
