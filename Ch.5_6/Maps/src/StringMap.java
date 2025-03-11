public interface StringMap {
    // get the value for the corresponding key
    public String get(String k);

    // check if key already added
    public boolean contains(String k);

    //put a new entry in map
    public void put(String k, String v);

    public int size();


}
