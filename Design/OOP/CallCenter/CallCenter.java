import java.util.*;
public class CallCenter {
    private Queue<Call> waitList;
    private List<Employee> employees;
    
    public CallCenter() {
        waitList = new LinkedList<Call>();
        employees = new ArrayList<>();
    }
    
    public Employee getHandler(Call call) {
        Employee handler = null;
        for (Employee e : employees) {
            if (e.isFree()) {
                handler = e;
                e.takeCall();
                break;
            }
        }
        if (handler == null) {
            waitList.add(call);
            System.out.println("This call is queued.");
            return null;
        }
        System.out.println("This call is handled by: " + handler.getName());
        return handler;
    }
    
    public void addEmployee(Employee e) {
        this.employees.add(e);
        Collections.sort(employees);
    }
    
    public static void main(String args[]) {
        CallCenter cc = new CallCenter();
        // populate cc
        cc.addEmployee(new Respondant("R1", cc));
        cc.addEmployee(new Respondant("R2", cc));
        cc.addEmployee(new Manager("M1", cc));
        cc.addEmployee(new Manager("M2", cc));
        cc.addEmployee(new Director("D1", cc));
        
        cc.getHandler(new Call());
        cc.getHandler(new Call());
        cc.getHandler(new Call());
        cc.getHandler(new Call());
        cc.getHandler(new Call());
        cc.getHandler(new Call());
        cc.getHandler(new Call());

    }
    
}