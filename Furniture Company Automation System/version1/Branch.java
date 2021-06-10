/**
 * 
 */
package FurnitureCompany;
import FurnitureCompany.CompanyArray.GTUSet;

/**
 * @author buket
 *
 */
public class Branch
{
	String name;
	GTUSet<BranchEmployee> employees;
	GTUSet<Product> products;
	
	String[] productNames = {"OfficeChair", "OfficeDesk", "MeetingTable", "BookCase", "OfficeCabinet"};
	String[] models = {"Model1", "Model2"};
	String[] colors = {"Color1", "Color2", "Color3"};
	
	public Branch(String name)
	{
		this.name = new String(name);
		employees = new GTUSet<>();
		products = new GTUSet<>();
		
		for(int i=0 ; i<productNames.length ; i++)
		{
			for(int j=0 ; j<models.length ; j++)
			{
				for(int k=0 ; k<colors.length ; k++)
				{
					Product product = new Product(productNames[i], models[j], colors[k], 2);
					products.insert(product);
				}
			}
		}
		
	}
	public GTUSet<BranchEmployee> getEmployees()
	{
		return employees;
	}

	public String getName()
	{
		return name;
	}
	public GTUSet<Product> getProducts()
	{
		return products;
	}
    @Override
    public boolean equals(Object obj)
    {
        if( obj == null )
            return false;

        if( !(obj instanceof Branch) )
            return false;

        return ((Branch) obj).name.equals( this.name);
    }
    public Integer searchEmployee(String email)
	{

        for(int i = 0 ; i < employees.size() ; i++)
        {

        	if(employees.getArrayIndex(i).getEmail().equals(email))
        	{
        		return i;
        	}    
        } 
        return -1;
    }
    public Integer searchEmployee(String password, int userNumber)
	{
    	
        for(int i = 0 ; i < employees.size() ; i++)
        {
        	if(employees.getArrayIndex(i).getUserNumber() == userNumber && employees.getArrayIndex(i).getPassword().equals(password))
        	{
        		return i;
        	}    
        } 
        return -1;
    }
    public Integer searchProduct(String name, String model, String color)
	{

        for(int i = 0 ; i < products.size() ; i++)
        {

        	if(products.getArrayIndex(i).getName().equals(name) && products.getArrayIndex(i).getModel().equals(model) && products.getArrayIndex(i).getColor().equals(color) )
        	{
        		return i;
        	}    
        } 
        return -1;
    }
    public void listProducts() {
        System.out.println(products.toString());
    }

    
}
