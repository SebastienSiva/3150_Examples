public class Student extends Person{
    private int credits;
    public Student(String n, int a,int c) {
        super(n, a);
        this.credits = c;
    }

    public String level() {
        if(credits < 30) {
            return "freshman";
        }
        else if(credits < 60) {
            return "sophomore";
        }
        else if(credits < 90) {
            return "junior";
        }
        else {
            return "senior";
        }
    }

    public String toString() {
        return super.toString() + " and a " + level();
    }
}
