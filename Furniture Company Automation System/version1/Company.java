/**
 * 
 */
package FurnitureCompany;

import FurnitureCompany.CompanyArray.GTUSet;

/**
 * @author buket
 *
 */
public class Company
{
	String name;
	GTUSet<Branch> branches;
	GTUSet<Administrator> admins;
	GTUSet<Product> products;
	GTUSet<Customer> customers;
	GTUSet<String> supplyProduct;
	
	public Company(String name)
	{
		this.name = new String(name);
		branches = new GTUSet<>();
		admins = new GTUSet<>();
		products = new GTUSet<>();
		customers = new GTUSet<>();
		supplyProduct = new GTUSet<>();
	}
	
	public void addAdministrator(Administrator admin)
	{
		admins.insert(admin);
	}
	public GTUSet<Branch> getBranches()
	{ 
		return branches;
	}
	public GTUSet<String> getSupplyProducts()
	{ 
		return supplyProduct;
	}
	public GTUSet<Administrator> getAdmins()
	{ 
		return admins;
	}
	public GTUSet<Product> getProducts()
	{ 
		return products;
	}
	public GTUSet<Customer> getCustomers()
	{ 
		return customers;
	}
	public Integer searchBranch(String name)
	{
        for(int i = 0 ; i < branches.size() ; i++)
        {
        	if(branches.getArrayIndex(i).getName().equals(name))
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
        	if(admins.getArrayIndex(i).getPassword().equals(password) && admins.getArrayIndex(i).getUserNumber() == adminNumber)
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
        	if(customers.getArrayIndex(i).getPassword().equals(password) && customers.getArrayIndex(i).getUserNumber() == customerNumber)
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
        	if(customers.getArrayIndex(i).getEmail().equals(email))
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
        	if(customers.getArrayIndex(i).getUserNumber() == customerNumber)
        	{
        		return i;
        	}    
        } 
        return -1;
    }
	public Boolean addCustomer(Customer customer)
	{
		if(!customers.contains(customer))
		{
			customers.insert(customer);
			return true;
		}
		return false;
		
	}


    public void listAdmins() {
        System.out.println(admins.toString());
    }

    public void listBranches() {
        System.out.println(branches.toString());
    }

	
}
