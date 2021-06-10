
package FurnitureCompany;

public class Branch
{
	String name;
	KWArrayList<BranchEmployee> employees;
	HybridList<Product> products;
	
	String[] productNames = {"OfficeChair", "OfficeDesk", "MeetingTable", "BookCase", "OfficeCabinet"};
	String[] models = {"Model1", "Model2"};
	String[] colors = {"Color1", "Color2"};
	
	/**
	 * @param name
	 */
	public Branch(String name)
	{
		this.name = new String(name);
		employees = new KWArrayList<>();
		products = new HybridList<>();
		
		for(int i=0 ; i<productNames.length ; i++)
		{
			for(int j=0 ; j<models.length ; j++)
			{
				for(int k=0 ; k<colors.length ; k++)
				{
					Product product = new Product(productNames[i], models[j], colors[k], 2);
					products.add(product);
				}
			}
		}
		
	}
	/**
	 * @return
	 */
	public KWArrayList<BranchEmployee> getEmployees()
	{
		return employees;
	}

	/**
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @return
	 */
	public HybridList<Product> getProducts()
	{
		return products;
	}
    /**
     *
     */
    @Override
    public boolean equals(Object obj)
    {
        if( obj == null )
            return false;

        if( !(obj instanceof Branch) )
            return false;

        return ((Branch) obj).name.equals( this.name);
    }
    /**
     * @param email
     * @return
     */
    public Integer searchEmployee(String email)
	{

        for(int i = 0 ; i < employees.size() ; i++)
        {

        	if(employees.get(i).getEmail().equals(email))
        	{
        		return i;
        	}    
        } 
        return -1;
    }
    /**
     * @param password
     * @param userNumber
     * @return
     */
    public Integer searchEmployee(String password, int userNumber)
	{
    	
        for(int i = 0 ; i < employees.size() ; i++)
        {
        	if(employees.get(i).getUserNumber() == userNumber && employees.get(i).getPassword().equals(password))
        	{
        		return i;
        	}    
        } 
        return -1;
    }
    /**
     * @param name
     * @param model
     * @param color
     * @return
     */
    public Integer searchProduct(String name, String model, String color)
	{

        for(int i = 0 ; i < products.size() ; i++)
        {

        	if(products.get(i).getName().equals(name) && products.get(i).getModel().equals(model) && products.get(i).getColor().equals(color))
        	{
        		return i;
        	}    
        } 
        return -1;
    }
    /**
     * 
     */
    public void listProducts() {
        System.out.println(products.toString());
    }
}
