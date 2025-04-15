import java.util.concurrent.Semaphore;

public class P2 implements Runnable{
    private Semaphore p1Sem;
    private Semaphore p2Sem;

    public P2(Semaphore p1s, Semaphore p2s) {
        this.p1Sem = p1s;
        this.p2Sem = p2s;
    }

    public void run() {

    }
}
