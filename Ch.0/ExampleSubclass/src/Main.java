public class Main {
    public static void main(String[] args) {
        Student a = new Student("Bob", 20, 75);
        System.out.println(a.level());
        Person b = new Student("Lisa", 22, 99);
        System.out.println("Lisa is older: " + b.olderThan(a));
        Person c = new Person("Sam", 100);
        // System.out.println(b.level()); //error

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}