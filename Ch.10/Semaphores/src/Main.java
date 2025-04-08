public class Main {
    public static void main(String[] args) throws Exception{
        int numThreads = 5;
        int numNamesPerThread = 100;
        StringList allNames = new StringList();
        Thread[] threads = new Thread[numThreads];
        for(int i = 0; i < numThreads; i++) {
            RandomNameGen nameGen = new RandomNameGen(allNames, numNamesPerThread);
            threads[i] = new Thread(nameGen);
            threads[i].start();
        }
        for(int i = 0; i < numThreads; i++) threads[i].join();

        System.out.println(allNames);
        for(int i = 0; i < 500; i++) {
            if(allNames.get(i) == null) {
                System.out.println("Around index " + i + ": " +
                        allNames.toString(i - 2, i + 2));
                break;
            }
        }
    }
}