import java.util.Stack;
import java.util.concurrent.Semaphore;

//TODO: Modify this class

public class NASDAQConnectionMgr {
    private int numConnections;

    private Stack<NASDAQConnection> connections;
    private Semaphore dataLock;
    private Semaphore resourceLock;

    public NASDAQConnectionMgr(int numConnections) {
        this.numConnections = numConnections;
        dataLock = new Semaphore(1);
        resourceLock = new Semaphore(numConnections, true);
        this.connections = new Stack<>();
        for(int i = 0; i < numConnections; i++)
            connections.push(new NASDAQConnection());
    }

    public NASDAQConnection getAvailableConnection() {
    	try {
			//both protect the critical section
			//and use the other semaphore to keep up with how many resources are available
			resourceLock.acquire();
			dataLock.acquire();
			NASDAQConnection c = connections.pop();
			dataLock.release();
			return c;
        }
        catch(Exception e) {
        	throw new RuntimeException(e);
        }
    }

    public void returnConnection(NASDAQConnection con) {
    	try {
			//semaphore logic
			dataLock.acquire();
			connections.push(con);
			dataLock.release();
			resourceLock.release();
		}
        catch(Exception e) {
        	throw new RuntimeException(e);
        }
    }
}