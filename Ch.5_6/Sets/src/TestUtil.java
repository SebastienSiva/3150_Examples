public class TestUtil {

    public static String getRandomName() {
        String[] names = {"James", "Mike", "Rob", "John", "David", "Will", "Richard", "Joe",
            "Tom", "Mary", "Pat", "Jenn", "Linda", "Liz", "Barb", "Susan", "Jessica"};
        int r = (int)(Math.random() * names.length);
        return names[r];
    }
}
