public class Employee implements Comparable<Employee> {
    private String name;
    private boolean free;
    private CallCenter callCenter;
    protected int priority;
    
    public Employee(String name, CallCenter callCenter) {
        this.name = name;
        this.callCenter = callCenter;
        this.free = true;
    }
    
    public boolean isFree() {
        return free;
    }
    
    public void takeCall() {
        this.free = false;
    }
    
    public void doneCall() {
        this.free = true;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int compareTo(Employee other) {
        return this.priority - other.priority;
    }
}