public class Employee {
    private static int id;
    private final int counter;

    private String name;
    private String lastName;
    private String middleName;
    private int department;
    private float salary;


    public Employee(String name, String lastName, String middleName, int department, float salary) {

        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        this.counter = getId();
        id++;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public int getDepartment() {
        return this.department;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getCounter() {
        return counter;
    }

    private int getId() {
        return id;
    }
}
