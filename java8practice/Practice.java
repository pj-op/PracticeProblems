package java8practice;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = Arrays.asList(new Employee("Jack", 9000), new Employee("Paul", 67000));

        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };

        Comparator<Employee> myComparator = (a, b) -> a.getName().compareTo(b.getName());
        Collections.sort(employeeList, myComparator);

        employeeList.stream().sorted((x, y) -> (int) (y.getSalary() - x.getSalary())).forEach(System.out::println);

        Thread t1 = new Thread(() -> System.out.println("New Thread"));
        t1.start();

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(num.stream().mapToInt(a->a).min().getAsInt());


//        System.out.println(employeeList);

    }
}
