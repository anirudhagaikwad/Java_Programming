package PPT10;


/*
* write a java program to create interface salary which force to insert
* salary of developers who implements the salary interface
* */

// Interface
interface salary {
    void insertsalary(int salary);
}

// Class 1
// Implementing the salary in the class
class SDE1 implements salary {
    int salary;
    @Override public void insertsalary(int salary)
    {
        this.salary = salary;
    }
    void printSalary() { System.out.println(this.salary); }
}

// Class 2
// Implementing the salary inside the SDE2 class
class SDE2 implements salary {
    int salary;
    @Override public void insertsalary(int salary)
    {
        this.salary = salary;
    }
    void printSalary() { System.out.println(this.salary); }
}

public class JavaProgram15 {

    public static void main(String[] args)
    {
        SDE1 ob = new SDE1();
        // Insert different salaries
        ob.insertsalary(100000);
        ob.printSalary();
        SDE2 ob1 = new SDE2();

        ob1.insertsalary(200000);
        ob1.printSalary();
    }
}
