public class Entry {
    public String name;
    public int priority;

    public Entry(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String toString() {
        return name + "(P " + priority + ")";
    }
}
