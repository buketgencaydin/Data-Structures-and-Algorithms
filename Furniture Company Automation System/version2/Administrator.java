package FurnitureCompany;

public class Administrator extends User
{
	
	/**
	 * @param name
	 * @param surname
	 * @param password
	 * @param email
	 * @param userNumber
	 */
	public Administrator(String name, String surname, String password, String email, int userNumber)
	{
		super(name, surname, password, email, userNumber);
	}
	/**
	 * @param password
	 * @param userNumber
	 */
	public Administrator(String password, int userNumber)
	{
		super(password, userNumber);
	}
	/**
	 * @param branch
	 * @param company
	 * @return
	 */
	public Boolean addBranch(Branch branch, Company company)
	{
		company.branches.addLast(branch);
		return true;	
	}
	/**
	 * @param branch
	 * @param company
	 */
	public void removeBranch(Branch branch, Company company)
	{
		int index = company.searchBranch(branch.getName());
		company.branches.remove(index);
	}
	/**
	 * @param employee
	 * @param branch
	 * @return
	 */
	public Boolean addBranchEmployee(BranchEmployee employee, Branch branch)
	{
		branch.employees.add(employee);
		System.out.printf("Employee %s added to system\n",employee);
		return true;
	}
	/**
	 * @param employeeIndex
	 * @param branch
	 */
	public void removeBranchEmployee(Integer employeeIndex, Branch branch)
	{
		branch.employees.remove(employeeIndex);
	}
	/**
	 * @param company
	 */
	public void showRequestedProducts(Company company)
	{
		System.out.println(company.getSupplyProducts());
	}
	/**
	 *
	 */
	@Override
    public boolean equals(Object obj)
	{
        if(obj == null)
            return false;

        if(!(obj instanceof User))
            return false;

        return (((User) obj).getUserNumber().equals(this.getUserNumber()) && ((User) obj).getPassword().equals(this.getPassword()));
    }

}
