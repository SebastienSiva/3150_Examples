public class Entry {
    public String key;
    public String value;

    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return key + ":" + value;
    }
}
