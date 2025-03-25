public interface PriorityQueue {
    public int size();

    public void addEntry(String name, int priority);

    //look at highest priority entry
    //should be fast!!! BigO(1)
    public Entry peek();

    //remove the highest priority entry
    public Entry poll();
}
