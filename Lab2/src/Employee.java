public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        if (department != null) {
            department.addEmployee(this);
        }
    }

    @Override
    public String toString() {
        if (department == null) {
            return name;
        }
        
        if (department.getBoss() == this) {
            return name + " начальник отдела " + department.getName();
        } else {
            String bossName = department.getBoss() != null ? department.getBoss().getName() : "неизвестен";
            return name + " работает в отделе " + department.getName() + ", начальник которого " + bossName;
        }
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }
}
