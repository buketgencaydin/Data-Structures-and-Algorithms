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
	public Administrator(String password, int userNumber)
	{
		super(password, userNumber);
	}
	public Boolean addBranch(Branch branch, Company company)
	{
		if(!company.getBranches().contains(branch))
		{
			company.branches.insert(branch);
			return true;
		}
		return false;
			
	}
	public void removeBranch(Branch branch, Company company)
	{
		company.branches.erase(branch);
	}
	public Boolean addBranchEmployee(BranchEmployee employee, Branch branch)
	{
			branch.employees.insert(employee);
			return true;
	
	}
	public void removeBranchEmployee(BranchEmployee employee, Branch branch)
	{
		branch.employees.erase(employee);
	}
	public void showRequestedProducts(Company company)
	{
		System.out.println(company.getSupplyProducts());
	}
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
