import java.io.Serializable;

public class Anime implements Serializable {
    private String name;
    private int numEpisodes;
    private double avgLength;

    public Anime(String name, int numEpisodes, double avgLength) {
        this.name = name;
        this.numEpisodes = numEpisodes;
        this.avgLength = avgLength;
    }

    public String getName() {
        return name;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public double getAvgLength() {
        return avgLength;
    }

    public String toString() {
        return this.name + " Num Episodes: " + this.numEpisodes;
    }
}
