package testStatic.employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeStreamSortAPITest {

    public static List<Employee> getSortedEmployee(String arg) {
        if (arg.equalsIgnoreCase("sort")) {
            List<Employee> emp = EmployeeDataBase.getEmployee().stream().
                    sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).collect(Collectors.toList());
            return emp;
        } else {
            List<Employee> emp = EmployeeDataBase.getEmployee().stream().sorted(Comparator.comparing(Employee::getDept)).collect(Collectors.toList());
            return emp;
        }
    }

    public static void main(String args[]){
        System.out.println(EmployeeStreamSortAPITest.getSortedEmployee("sortrtett"));

    }

}


class sortEmployee implements Comparator<Employee>{


    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getSalary()-o2.getSalary());
    }
}