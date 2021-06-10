package FurnitureCompany;


public class Customer extends User
{
	KWArrayList<String> orders;
	
	public Customer(String name, String surname, String password, String email, int userNumber) {
		super(name, surname, password, email, userNumber);
		orders = new KWArrayList<>();
	}
	public KWArrayList<String> getOrders()
	{
		return orders;
	}
	public Integer searchProduct(String name, String model, String color, Company company)
	{
		
        for(int i = 0 ; i < company.getBranches().size() ; i++)
        {
        	Branch branch = company.getBranches().get(i);
        	for(int j=0 ; j<branch.getProducts().size() ; j++)
        	{
        		Product product = branch.getProducts().get(j);
        		if(product.getName().equals(name) && product.getModel().equals(model) && product.getColor().equals(color))
            	{
        			if(product.getStockNumber() > 0)
        			{
        				System.out.printf("In %s, %s product exists\n", branch.getName(), product);
                		return i;
        			}
            	}   
        	}
        	 
        } 
        System.out.printf("Product does not exist in company\n");
        return -1;
    }
	public void listProducts(Company company)
	{
		for(int i=0 ; i<company.getBranches().size() ; i++)
		{
			Branch branch =  company.getBranches().get(i);
			System.out.printf("%s\n",branch.getName());
			branch.listProducts();

		}
	}
	public void listOrders()
	{
        System.out.println(orders.toString());
    }

}
