package FurnitureCompany;

public class BranchEmployee extends User
{

	public BranchEmployee(String name, String surname, String password, String email, int userNumber) {
		super(name, surname, password, email, userNumber);
	}
	
	public BranchEmployee(String password, int userNumber)
	{
		super(password, userNumber);
	}
	public Boolean addCustomer(Customer customer, Company company)
	{
			company.customers.add(customer);
			return true;
	}
	public void addProduct(String productName, String modelName, String colorName, Integer number, Branch branch)
	{
		int productIndex = branch.searchProduct(productName, modelName, colorName);
		if(productIndex != -1)
		{
			Product product = branch.products.get(productIndex);
			product.setStockNumber(product.getStockNumber() + number);
			System.out.println("Product added to system.");
		}	
		else
		{
			System.out.println("Product does not exist!");
		}
	}
	public void removeProduct(String productName, String modelName, String colorName, Integer number, Branch branch)
	{
		int productIndex = branch.searchProduct(productName, modelName, colorName);
		if(productIndex != -1)
		{
			Product product = branch.products.get(productIndex);
			if(product.getStockNumber()-number < 0)
			{
				System.out.println("Invalid operation! Product stock number can not be under 0!");
			}
			else
			{
				product.setStockNumber(product.getStockNumber() - number);
				System.out.println("Product removed from system.");
			}
			
		}
		else
		{
			System.out.println("Product does not exist!");
		}
	}
}
