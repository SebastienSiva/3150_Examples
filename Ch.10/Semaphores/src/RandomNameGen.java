public class RandomNameGen implements Runnable{
    private StringList allNames;
    private int numNamesToAdd;

    public RandomNameGen(StringList allNames, int numNamesToAdd) {
        this.allNames = allNames;
        this.numNamesToAdd = numNamesToAdd;
    }

    private static String getRandomName() {
        int n = (int) 'a';
        String name = "";
        for(int i = 0; i < 5; i++) {
            int r = (int)(26 * Math.random());
            name += (char)(n + r);
        }
        return name;
    }

    public void run() {
        //add random names to the list
        for(int i = 0; i < numNamesToAdd; i++) {
            String n = getRandomName();
            allNames.add(n);
        }
    }
}
