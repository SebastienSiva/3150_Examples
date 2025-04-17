import java.util.Random;
public class NASDAQConnection {
    private Random rgen = new Random();
    private long minLagTime = 1000;

    public double getStockPrice(String s) {
        try {
            //simulate network ping time
            Thread.sleep(minLagTime + rgen.nextInt(50));
            return NASDAQ_DB.getPrice(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}