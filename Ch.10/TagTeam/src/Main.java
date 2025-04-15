import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore p1Sem = new Semaphore(?);
        Semaphore p2Sem = new Semaphore(?);
        new Thread(new P1(p1Sem, p2Sem)).start();
        new Thread(new P2(p1Sem, p2Sem)).start();
    }
}