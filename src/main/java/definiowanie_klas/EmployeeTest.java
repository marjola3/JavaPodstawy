package definiowanie_klas;

import java.text.NumberFormat;

/**
 * Created by Mariola on 05.04.14.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Jarosław Rybiński", 7500, 1987, 12, 15);
        staff[1] = new Employee("Katarzyna Remiszewska", 5000, 1989, 10, 1);
        staff[2] = new Employee("Jarosław Rybiński", 4000, 1990, 3, 15);

        for(Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary()
            + ",hireDay=" + e.getHireDay());
        }

        NumberFormat formater = NumberFormat.getCurrencyInstance();
    }
}
