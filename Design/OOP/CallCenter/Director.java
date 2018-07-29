public class Director extends Employee {
    public Director(String name, CallCenter cc) {
        super(name, cc);
        this.priority = 2;
    }
}