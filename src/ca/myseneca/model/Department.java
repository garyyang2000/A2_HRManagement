/**
* The Department class is a JavaBean class which 
* provides department id and department name of 
* the Departments table in Oracle database.
* 
* @author  Ge Yang, Bohao Liu, Yan Liu
* @version 1.0
* @since   2016-04-10 
*/

package ca.myseneca.model;

public class Department {
	private int deptId;
	private String deptName;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

}
