package ru.geekbrains.lessons;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("", "", "", "", 134L, 25),
                new Employee("", "", "", "", 131L, 24),
                new Employee("", "", "", "", 164L, 40),
                new Employee("", "", "", "", 204L, 34),
                new Employee("", "", "", "", 100000L, 99)
        };

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                employee.printEmployee();
            }
        }
    }
}
