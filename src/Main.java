public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.add("oleg", 70000, 2);
        employeeBook.add("olga", 60000, 3);
        employeeBook.add("andrey", 75000, 1);
        employeeBook.add("ivan", 80000, 2);
        employeeBook.printAll();
        System.out.println();
        employeeBook.update("Oleg", 95000, 2);
        try {
            employeeBook.update("Igor", 70000, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        employeeBook.delete(1);
        employeeBook.delete("Ivan");
        employeeBook.printAll();
    }
}

