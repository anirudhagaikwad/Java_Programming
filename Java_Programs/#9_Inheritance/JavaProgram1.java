package PPT9;

 /*
Create a class named 'Member' having the following members:
Data members
1 - Name
2 - Age
3 - Phone number
4 - Address
5 - Salary
It also has a method named 'printSalary' which prints the salary of the members.
Two classes 'Employee' and 'Manager' inherits the 'Member' class. The 'Employee' and 'Manager' classes have data members 'specialization' and 'department' respectively. Now, assign name, age, phone number, address and salary to an employee and a manager by making an object of both of these classes and print the same.
*/

class Member{
    //data members of class
    String name;
    int age;
    String number;
    String address;
    int salary;

    //member function of class
    public void printSalary(){
        System.out.println(salary);
    }

}

class Employee extends Member{
    String specialization;
}

class Manager extends Member{
    String department;
}

class JavaProgram1{
    public static void main(String[] args){
        Employee e = new Employee();
        e.name = "xyz";
        e.age = 23;
        e.number = "986****";
        e.address = "xyzxyz";
        e.salary = 1231;
        e.specialization = "xyzxyz";

        e.printSalary(); //base class function called
        Manager m = new Manager();
        m.name = "QRP";
        m.age = 35;
        m.number = "996****";
        m.address = "abc def";
        m.salary = 65434;
        m.department = "RnD";

        m.printSalary(); //base class function called

    }
}


