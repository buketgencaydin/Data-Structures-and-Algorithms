package FurnitureCompany;

public class Company
{
	String name;
	KWLinkedList<Branch> branches;
	KWArrayList<Administrator> admins;
	KWArrayList<Customer> customers;
	KWArrayList<String> supplyProduct;
	
	public Company(String name)
	{
		this.name = new String(name);
		branches = new KWLinkedList<>();
		admins = new KWArrayList<>();
		customers = new KWArrayList<>();
		supplyProduct = new KWArrayList<>();
	}
	
	public void addAdministrator(Administrator admin)
	{
		admins.add(admin);
	}
	public KWLinkedList<Branch> getBranches()
	{ 
		return branches;
	}
	public KWArrayList<String> getSupplyProducts()
	{ 
		return supplyProduct;
	}
	public KWArrayList<Administrator> getAdmins()
	{ 
		return admins;
	}
	public KWArrayList<Customer> getCustomers()
	{ 
		return customers;
	}
	public Integer searchBranch(String name)
	{
        for(int i = 0 ; i < branches.size() ; i++)
        {
        	if(branches.get(i).getName().equals(name))
        	{
        		return i;
        	}
        } 
        return -1;
    }
	public Integer searchAdmin(String password, int adminNumber)
	{

        for(int i = 0 ; i < admins.size() ; i++)
        {
        	if(admins.get(i).getPassword().equals(password) && admins.get(i).getUserNumber() == adminNumber)
        	{
        		return i;
        	}    
        } 
        return -1;
    }
	
	public Integer searchCustomer(String password, int customerNumber)
	{

        for(int i = 0 ; i < customers.size() ; i++)
        {
        	if(customers.get(i).getPassword().equals(password) && customers.get(i).getUserNumber() == customerNumber)
        	{
        		return i;
        	}    
        } 
        return -1;
    }
	public Integer searchCustomer(String email)
	{

        for(int i = 0 ; i < customers.size() ; i++)
        {
        	if(customers.get(i).getEmail().equals(email))
        	{
        		return i;
        	}    
        } 
        return -1;
    }
	public Integer searchCustomer(int customerNumber)
	{
        for(int i = 0 ; i < customers.size() ; i++)
        {
        	if(customers.get(i).getUserNumber() == customerNumber)
        	{
        		return i;
        	}    
        } 
        return -1;
    }
	public Boolean addCustomer(Customer customer)
	{
		customers.add(customer);
		return true;
	}


    public void listAdmins() {
        System.out.println(admins.toString());
    }

    public void listBranches() {
        System.out.println(branches.toString());
    }

	
}
