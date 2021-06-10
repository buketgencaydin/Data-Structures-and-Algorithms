package FurnitureCompany;
import java.util.Scanner;


public class UserInterface
{
	static int userNumber=1111;
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
    	Company company = createCompany();
    	menu(company);
    }

    public static void menu(Company company)
    {
    	int choice;
    	
    	do
    	{
    		System.out.println("1-Online Shopping");
    		System.out.println("2-Login as Administrator");
    		System.out.println("3-Login as Branch Employee");
    		System.out.println("Press -1 for EXIT");
    		choice = scanner.nextInt();
    		
    		
    		switch(choice)
    		{
	    		case 1:
	    			customerMenu(company);
	    			break;
	    		case 2:
	    			adminMenu(company);
	    			break;
	    		case 3:
	    			branchEmployeeMenu(company);
	    			break;
	    		case -1:
	    			System.out.println("Have a good day!");
	    			break;
	    		default:
	    			System.out.println("INVALID CHOICE");
	    			break;
    		}
    	
    	}while(choice != -1);
    }

    public static Company createCompany()
    {
    	Company company = new Company("Furniture Company");
    	
    	/*
    	 *  There are two administrators of the company system.
    	 *  Buket Gencaydin and Basak Karakas
    	 */	
    	Administrator admin1 = new Administrator("Buket", "Gencaydin", "admin1", "b.gencaydin2019@gtu.edu.tr", ++userNumber);
    	Administrator admin2 = new Administrator("Basak", "Karakas", "admin2", "bkarakas2018@gtu.edu.tr", ++userNumber);
    	company.addAdministrator(admin1);
    	company.addAdministrator(admin2);
    	System.out.printf("Admin %s added to system\n",admin1);
    	System.out.printf("Admin %s added to system\n",admin2);
    	
    	/*******************************************/
    	System.out.printf("\nADMINISTRATOR METHODS\n");
    	Branch branch1 = new Branch("Istanbul");
    	admin1.addBranch(branch1, company);
    	System.out.printf("%s branch added to system\n",branch1.getName());
    	Branch branch2 = new Branch("Ankara");
    	admin1.addBranch(branch2, company);
    	System.out.printf("%s branch added to system\n",branch2.getName());
    	
    	System.out.printf("\naddBranch for Ankara, existing branch");
    	if(company.searchBranch("Ankara") != -1)
		{
		    System.out.printf("\nBranch already exists!\n\n");
		}
    	
    	admin1.removeBranch(branch2, company);
    	
    	BranchEmployee employee1 = new BranchEmployee("Ahmet", "Kara", "123", "ahmet@gtu.edu.tr", ++userNumber);
    	admin1.addBranchEmployee(employee1, branch1);
    	
    	BranchEmployee employee2 = new BranchEmployee("Ayse", "Yilmaz", "123", "ayse@gtu.edu.tr", ++userNumber);
    	admin1.addBranchEmployee(employee2, branch1);
    	
    	if(branch1.searchEmployee("ayse@gtu.edu.tr") != -1)
		{
		    System.out.printf("Branch employee already exists! %s\n", employee2);
		}
		else
		{
			admin1.addBranchEmployee(employee2,branch1) ;
			System.out.printf("%s added to system\n",employee2);
		}
    	int employeeIndex = branch1.searchEmployee("ayse@gtu.edu.tr");
		if(employeeIndex == -1)
		{
		    System.out.println("Branch employee does not exist!");
		}
		else
		{
			BranchEmployee employee = branch1.getEmployees().get(employeeIndex);
			admin1.removeBranchEmployee(employeeIndex,branch1) ;
			System.out.printf("%s removed from system\n",employee);
		}
    	/*****************************************************************/
		System.out.printf("\n\nBRANCH EMPLOYEE METHODS\n\n");
		
		System.out.println("LIST OF PRODUCTS before addProduct");
		branch1.listProducts();
		employee1.addProduct("OfficeChair","Model1", "Color1",1, branch1);
		System.out.println("\nLIST OF PRODUCTS after addProduct OfficeChair Model1 Color1");
		branch1.listProducts();
		employee1.removeProduct("OfficeChair","Model2", "Color2",1, branch1);
		System.out.println("\nLIST OF PRODUCTS after removeProduct OfficeChair Model2 Color2");
		branch1.listProducts();
		
		String name="BookCase"; String model="Model1"; String color="Color1";
		int productIndex = branch1.searchProduct(name, model, color);
		if(productIndex != -1)
		{
			String supply = branch1.getName() + " needs " + name + " "+ model +" " + color + " ";
			company.getSupplyProducts().add(supply);
			System.out.println(supply);
			System.out.println("Manager is informed.");
		}
		else
		{
			System.out.println("Product does not exist!");
		}
		
    	Customer customer1 = new Customer("Burak", "Koca", "123", "burak@gtu.edu.tr", ++userNumber);
    	employee1.addCustomer(customer1, company);
    	System.out.printf("Customer %s added to system\n",customer1);
    	Customer customer2 = new Customer("Yusuf", "Akgul", "123", "yusuf@gtu.edu.tr", ++userNumber);
    	employee1.addCustomer(customer2, company);
    	System.out.printf("Customer %s added to system\n",customer2);
    	
    	if(company.searchCustomer("yusuf@gtu.edu.tr") != -1)
    	{
    	    System.out.printf("Customer already exists! %s\n", customer2);
    	}
  
    	productIndex = branch1.searchProduct(name, model, color);
		if(productIndex != -1)
		{
			String address = "Kadikoy";
			String phoneNumber = "5555555";
			branch1.getProducts().remove(productIndex);		
			customer1.getOrders().add( name + ' ' + model + ' '+ color + ' '+ address + ' ' + phoneNumber);
			System.out.println("Order has been done!");
		}
		customer1.listOrders();
		
		/*****************************************************************/
		System.out.printf("\n\nCUSTOMER METHODS\n\n");
		
		name = "OfficeCabinet";
		color="Color2";
		int branchIndex = customer1.searchProduct(name, model, color, company);
		if(branchIndex != -1)
		{
			String address = "Kum Mah.";
			String phoneNumber = "54255555";
			
			Branch branch = company.getBranches().get(branchIndex);
			productIndex = branch.searchProduct(name, model, color);
			Product product = branch.getProducts().get(productIndex);
			product.setStockNumber(product.getStockNumber() -1 );
			customer1.getOrders().add( name + ' ' + model + ' '+ color + ' '+ address + ' ' + phoneNumber);
			System.out.println("Order has received! Thank you for your purchase.");
		}
		System.out.printf("\nsearchProduct for Shelf, not existed product\n");
		branchIndex = customer1.searchProduct("Shelf", "Model1", "Color1", company);
		
		customer1.listProducts(company);
		System.out.printf("\nPrevious orders\n");
		customer1.listOrders();
		System.out.println();

    	return company;
    	
    }
    public static void branchEmployeeMenu(Company company)
    {
    	System.out.print("Branch:");
    	String branchName = scanner.next();
    	
    	int branchIndex = company.searchBranch(branchName);
    	if(branchIndex == -1)
		{
		    System.out.println("Branch does not exist!");
		    return;
		}
    	Branch branch = company.getBranches().get(branchIndex);
    	
    	System.out.print("Branch Employee Number:");
		int employeeNumber = scanner.nextInt();
		System.out.print("Password:");
		String password = scanner.next();
		
		int employeeIndex = branch.searchEmployee(password, employeeNumber);
	
		if(employeeIndex == -1)
		{
			System.out.println("Wrong Information!");
			return;
		}
		BranchEmployee employee = branch.getEmployees().get(employeeIndex);
		System.out.printf("Login successful.\nBRANCH EMPLOYEE MENU\n");

		   
		int choice;
		
		do
		{
			System.out.println("1-Stock informations");
			System.out.println("2-Add product");
			System.out.println("3-Remove product");
			System.out.println("4-Add customer to system");
			System.out.println("5-Add new order");
			System.out.println("6-Previous order information of a customer");
			System.out.println("Press -1 for EXIT");
			choice = scanner.nextInt();
			
			switch(choice)
    		{
	    		case 1:
	    			branch.listProducts();
	    			System.out.println("1-Inform the manager to purchase product");
	    			System.out.println("2-Back to menu");
	    			choice = scanner.nextInt();
	    			
	    			if(choice == 1)
	    			{
	    				System.out.println("Product name:");
						String name = scanner.next();
						System.out.println("Product model:");
						String model = scanner.next();
						System.out.println("Product color:");
						String color = scanner.next();
						
						int productIndex = branch.searchProduct(name, model, color);
						if(productIndex != -1)
						{
							String supply = branch.getName() + " needs " + name + " "+ model +" " + color + " ";
							company.getSupplyProducts().add(supply);
							System.out.println("Manager is informed.");
							
						}
						else
						{
							System.out.println("Product does not exist!");
						}
	    			}
	    			break;
	    		case 2:
	    			System.out.println("Product name:");
					String name = scanner.next();
					System.out.println("Product model:");
					String model = scanner.next();
					System.out.println("Product color:");
					String color = scanner.next();
					System.out.println("Product number:");
					Integer number = scanner.nextInt();
					
					employee.addProduct(name,model, color,number, branch);
	    			break;
	    		case 3:
	    			System.out.println("Product name:");
					name = scanner.next();
					System.out.println("Product model:");
					model = scanner.next();
					System.out.println("Product color:");
					color = scanner.next();
					System.out.println("Product number:");
					number = scanner.nextInt();
					
					employee.removeProduct(name,model, color,number, branch);
	    			break;
	    		case 4:
					newCustomer(company);
	    			break;
	    		case 5:
	    			System.out.print("Customer number:");
	    			Integer customerNumber = scanner.nextInt();
	    			
	    			int customerIndex = company.searchCustomer(customerNumber);
	    			if(customerIndex == -1)
	    	    	{
	    	    	    System.out.println("Customer does not exist!");
	    	    	}
	    			else
	    			{
	    				Customer customer = company.getCustomers().get(customerIndex);
	    				
	    				System.out.println("Product name:");
						name = scanner.next();
						System.out.println("Product model:");
						model = scanner.next();
						System.out.println("Product color:");
						color = scanner.next();
						
						int productIndex = branch.searchProduct(name, model, color);
						if(productIndex != -1)
						{
							System.out.println("Adress:");
							String address = scanner.next();
							System.out.println("Phone number:");
							String phoneNumber = scanner.next();
							
							branch.getProducts().remove(productIndex);
												
							customer.getOrders().add( name + ' ' + model + ' '+ color + ' '+ address + ' ' + phoneNumber);
							System.out.println("Order has been done!");
						}
	    			}
	    			break;
	    		case 6:
	    			System.out.print("Customer number:");
	    			customerNumber = scanner.nextInt();
	    			
	    			customerIndex = company.searchCustomer(customerNumber);
	    			if(customerIndex == -1)
	    	    	{
	    	    	    System.out.println("Customer does not exist!");
	    	    	}
	    			else
	    			{
	    				Customer customer = company.getCustomers().get(customerIndex);
	    				customer.listOrders();
	    			}
					
	    			break;
	    		case -1:
	    			System.out.println("Have a good day!");
	    			break;
	    		default:
	    			System.out.println("INVALID CHOICE");
	    			break;
    		}
		}while(choice != -1);

    }
    public static void customerMenu(Company company)
    {
    	int choice;
    	
		System.out.println("1-Login");
		System.out.println("2-New subscription");
		System.out.println("Press -1 for EXIT");
		choice = scanner.nextInt();
		
		switch(choice)
		{
    		case 1:
    			System.out.print("Customer Number:");
    			int customerNumber = scanner.nextInt();
    			System.out.print("Password:");
    			String  password = scanner.next();
    			
    			int customerIndex = company.searchCustomer(password, customerNumber);
    			Customer customer;
    			
    			if(customerIndex == -1)
    			{
    			    System.out.println("Wrong information!");
    			    return;
    			}
    			else
    			{
    				customer = company.getCustomers().get(customerIndex);
    				
    		    	do
    		    	{
    		    		System.out.println("1-Search for product");
        				System.out.println("2-See list of products");
        				System.out.println("3-See previous orders");
        				System.out.println("Press -1 for EXIT");
        				choice = scanner.nextInt();
        				
        				switch(choice)
        				{
        					case 1:
        						System.out.println("Product name:");
        						String name = scanner.next();
        						System.out.println("Product model:");
        						String model = scanner.next();
        						System.out.println("Product color:");
        						String color = scanner.next();
        						
        						int branchIndex = customer.searchProduct(name, model, color, company);
        						if(branchIndex != -1)
        						{
        							System.out.println("1-Buy it");
        							System.out.println("Press -1 for EXIT");
        							Integer buy = scanner.nextInt();
        							if(buy==1)
        							{
        								System.out.println("Adress:");
        								String address = scanner.next();
            							System.out.println("Phone number:");
            							String phoneNumber = scanner.next();
            							
        								Branch branch = company.getBranches().get(branchIndex);
        								int productIndex = branch.searchProduct(name, model, color);
        								Product product = branch.getProducts().get(productIndex);
        								product.setStockNumber(product.getStockNumber() -1 );
        								
        								
        								customer.getOrders().add( name + ' ' + model + ' '+ color + ' '+ address + ' ' + phoneNumber);
        								System.out.println("Order has received! Thank you for your purchase.");
        							}
        						}
        						else
        						{
        							System.out.println("Product does not exist!");
        						}
        						break;
        					case 2:
        						System.out.println("PRODUCTS");
        						customer.listProducts(company);
        						break;
        					case 3:
        						System.out.println("PREVIOUS ORDERS");
        						customer.listOrders();
        						break;
        					case -1:
        						System.out.println("Have a good day!");
        						break;
        					default:
        						System.out.println("INVALID CHOICE!");
        				}
    		    	}while(choice!=-1);
    			}
    			
    			break;
    		case 2:
    			newCustomer(company);
    			break;
    		case -1:
    			System.out.println("Have a good day!");
    			return;
    		default:
    			System.out.println("INVALID CHOICE");
    			break;
		}
    	

    }
    public static void newCustomer(Company company)
    {
    	System.out.print("Name :");
    	String name = scanner.next();
    	
    	System.out.print("Surname :");
    	String surname = scanner.next();
    	
    	System.out.print("Email:");
    	String email = scanner.next();
    	
    	System.out.print("Password :");
    	String password = scanner.next();
    	
    	
    	Customer customer = new Customer(name, surname,password, email, ++userNumber);
    	
    	if(company.searchCustomer(email) != -1)
    	{
    	    System.out.println("Customer already exists!");
    	}
    	else
    	{
    		company.addCustomer(customer);
    		System.out.printf("%s(Customer Number) added to system\n",customer);
    	}
    }
	
    public static void adminMenu(Company company)
    {
		System.out.print("Administrator Number:");
		int adminNumber = scanner.nextInt();
		System.out.print("Password:");
		String  password = scanner.next();
		
		int adminIndex = company.searchAdmin(password, adminNumber);
		Administrator admin;
		
		if(adminIndex == -1)
		{
		    System.out.println("Wrong information!");
		    return;
		}
		else
		{
			admin = company.getAdmins().get(adminIndex);
			System.out.printf("Login successful.\nADMINISTRATOR MENU\n");
		}
		   
		int choice;
		do
		{
	    	System.out.println("1-Add Branch");
			System.out.println("2-Remove Branch");
			System.out.println("3-Add Branch Employee");
			System.out.println("4-Remove Branch Employee");
			System.out.println("5-Out of stock products");
			System.out.println("Press -1 for EXIT");
			choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Name of the new branch:");
				String name = scanner.next();
				
				if(company.searchBranch(name) != -1)
				{
				    System.out.println("Branch already exists!");
				}
				else
				{
					Branch branch = new Branch(name);
					admin.addBranch(branch, company);
					System.out.printf("%s branch added to system\n",name);
				}
				    
				break;
			case 2:
				System.out.print("Name of the branch will be removed:");
				name = scanner.next();
				
				if(company.searchBranch(name) != -1)
				{
					Branch branch = new Branch(name);
					admin.removeBranch(branch, company);
					System.out.printf("%s branch removed from system\n",name);
				}
				else
				{
					System.out.printf("\nBranch does not exist!\n\n");
				}
				    
				break;
			case 3:
				System.out.print("Name of the branch that new branch employee will be added:");
				String branchName = scanner.next();
				
				int branchIndex = company.searchBranch(branchName);
				if(branchIndex == -1)
				{
				    System.out.println("Branch does not exist!");
				}
				else
				{
					Branch branch = company.getBranches().get(branchIndex);
					System.out.print("Name of the new branch employee:");
					name = scanner.next();
					
					System.out.print("Surname of the new branch employee:");
					String surname = scanner.next();
					
					System.out.print("Email of the new branch employee:");
					String email = scanner.next();
					
					System.out.print("Password of the new branch employee:");
					password = scanner.next();
					
					
					BranchEmployee employee = new BranchEmployee(name, surname,password, email, ++userNumber);
					
					if(branch.searchEmployee(email) != -1)
					{
					    System.out.println("Branch employee already exists!");
					}
					else
					{
						admin.addBranchEmployee(employee,branch) ;
						System.out.printf("%s added to system\n",employee);
					}
				}
				break;
			case 4:
				System.out.print("Name of the branch that branch employee will be removed:");
				branchName = scanner.next();
				
				branchIndex = company.searchBranch(branchName);
				if(branchIndex == -1)
				{
				    System.out.println("Branch does not exist!");
				}
				else
				{
					Branch branch = company.getBranches().get(branchIndex);
					
					System.out.print("Email of the branch employee:");
					String email = scanner.next();

					int employeeIndex = branch.searchEmployee(email);
					if(employeeIndex == -1)
					{
					    System.out.println("Branch employee does not exist!");
					}
					else
					{
						BranchEmployee employee = branch.getEmployees().get(employeeIndex);
						admin.removeBranchEmployee(employeeIndex,branch) ;
						System.out.printf("%s removed from system\n",employee);
					}
				}
			
				break;
			case 5:
				admin.showRequestedProducts(company);
				break;
			case -1:
				System.out.println("Have a good day!");
				break;
			default:
				System.out.println("INVALID CHOICE!");
			}
		}while(choice != -1);

    }
}


