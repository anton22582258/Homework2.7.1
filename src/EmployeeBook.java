import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, Employee> employees = new HashMap<>();

    public void add(String fullName, double salary, int department) {
        String key = fullName.toLowerCase();
        Employee employee = new Employee(fullName, salary, department);
        employees.put(key, employee);
    }

    public void delete(String fullName) {
        String key = fullName.toLowerCase();
        if (!employees.containsKey(key)) {
            throw new IllegalStateException("Сотрудник не найден");
        }
        employees.remove(key);
    }

    public void delete(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employees.values()) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove.getFullName().toLowerCase());
        } else {
            throw new IllegalStateException("Сотрудник не найден");
        }
    }

    public void update(String fullName, double salary, int department) {
        if (!employees.containsKey(getKey(fullName))) {
            throw new IllegalStateException("Сотрудник не найден");
        }
        Employee employee = employees.get(getKey(fullName));
        employee.setSalary(salary);
        employee.setDepartment(department);
    }

    public void printAll() {
        for (Employee employee : employees.values()) {
            System.out.println(employees);
        }
    }

    public void printAll(int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.println(employee);
            }
        }
    }

    public double getSum() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public double getSum(int department) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee getEmployeeWithMinSalary() {
        Employee minEmployee = null;
        for (Employee employee : employees.values()) {
            if (minEmployee == null || minEmployee.getSalary() > employee.getSalary()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    public Employee getEmployeeWithMinSalary(int department) {
        Employee minEmployee = null;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (minEmployee == null || minEmployee.getSalary() > employee.getSalary()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    public Employee getEmployeeWithMaxSalary() {
        Employee maxEmployee = null;
        for (Employee employee : employees.values()) {
            if (maxEmployee == null || maxEmployee.getSalary() < employee.getSalary()) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    public Employee getEmployeeWithMaxSalary(int department) {
        Employee maxEmployee = null;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (maxEmployee == null || maxEmployee.getSalary() < employee.getSalary()) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    public double getAverageSalary() {
        double sum = 0;
        int employeesNum = 0;
        for (Employee employee : employees.values()) {
            employeesNum++;
            sum += employee.getSalary();
        }
        return sum / employeesNum;
    }

    public double getAverageSalary(int department) {
        double sum = 0;
        int employeesNum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
                continue;
            }
            employeesNum++;
            sum += employee.getSalary();
        }
        return sum / employeesNum;
    }

    public void printAllNames() {
        for (Employee employee : employees.values()) {
            System.out.println(employee.getFullName());
        }
    }

    public void printAllNames(int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void increaseSalary(int percent) {
        for (Employee employee : employees.values()) {
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }

    public void increaseSalary(int percent, int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() != department) {
                continue;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }

    public void printAllWithSalaryLess(double bound) {
        for (Employee employee : employees.values()) {
            if (employee.getSalary() <= bound) {
                System.out.println(employee);
            }
        }
    }

    public void printAllWithSalaryMore(double bound) {
        for (Employee employee : employees.values()) {
            if (employee.getSalary() > bound) {
                System.out.println(employee);
            }
        }
    }

    private static String getKey(String fullName) {
        return fullName.toLowerCase();
    }
}


