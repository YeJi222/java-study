package prob04;

public class Depart extends Employee {
	private String department;
	
	public Depart(String name, int salary, String department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public void getInformation() {
		System.out.println( "이름: " + getName() + " 연봉: " + getSalary() + " 부서: " + department);
	}
	
}
