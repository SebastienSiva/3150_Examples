public class Person {

    private String name;
    private int age;

    public Person(String n, int a) {
        this.name = n;
        this.age = a;
    }

    public boolean olderThan(Person p) {
        return this.age > p.age;
    }

    public String toString() {
        return this.name + " is " + this.age + " years old";
    }
}
