package ru.geekbrains.lessons;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephone;
    private long salary;
    private int age;

    public Employee(String fullName, String position, String email, String telephone, long salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public long getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void printEmployee() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Full name='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
