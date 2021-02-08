package ru.geekbrains.lessons;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Maxim", "Junior Android Developer",
                        "maxim@gmail.com", "1234", 134L, 25),
                new Employee("Igor", "Middle Android Developer",
                        "igor@gmail.com", "1234", 131L, 24),
                new Employee("Katy", "Accountant",
                        "katy@gmail.com", "1234", 164L, 40),
                new Employee("Irina", "Department Head",
                        "irina@gmail.com", "1234", 204L, 34),
                new Employee("Alexandr", "CEO",
                        "sasha@gmail.com", "1234", 100000L, 99)
        };

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                employee.printEmployee();
            }
        }
    }
}
