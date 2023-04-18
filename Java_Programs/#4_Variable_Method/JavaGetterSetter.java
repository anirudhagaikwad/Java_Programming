package javaintro;

/*
 * In java getter and setter are two conventional methods that are uses for retriving and updating the values of variables.
 * 
 */
public class JavaGetterSetter {

	public static void main(String[] args) {
		Employee obj=new Employee();
		
// setting employee details using setter methods
		obj.setId(101);
		obj.setEmpName("Anirudha");
		obj.setDesignation("Trainer");
		
// get employee details using getter method
		System.out.println(" Employee ID : "+obj.getId());
		System.out.println("Employee Name : "+obj.getEmpName());
		System.out.println("Employee Designation : "+obj.getDesignation());

	}//main()

}//JavaGetterSetter

class Employee{
	private int id;
	private String empName;
	private String designation;
	
// Getter method start with 'get' keyword followed by the variable name,this method return attribute value
	public int getId() {
		return id;
	}

	public String getEmpName() {
		return empName;
	}

	public String getDesignation() {
		return designation;
	}


	
// setter method start with 'set' keyword followed by the variable name,this method take argument and assign it to variable
	
	public void setId(int id) {
		this.id = id;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}//Employee
