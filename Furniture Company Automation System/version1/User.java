package FurnitureCompany;
/**
 * 
 */

/**
 * @author buket
 *
 */
public class User
{
	private String name;
	private String surname;
	private String password;
	private String email;
	private Integer userNumber;
	
	public User(String name, String surname, String password, String email, int userNumber)
	{
		this.name = new String(name);
        this.surname = new String(surname);
        this.password = new String(password);
        this.email = new String(email);
        this.userNumber = Integer.valueOf(userNumber);
	}
	public User(String password,int userNumber)
	{
        this.password = new String(password);
        this.userNumber = Integer.valueOf(userNumber);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the userNumber
	 */
	public Integer getUserNumber() {
		return userNumber;
	}

	/**
	 * @param userNumber the userNumber to set
	 */
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public String toString() {
        return name + ' ' + surname + ' ' + userNumber;
    }

    /**
     * Overridden clone() method
     * @return Object that can be downcast to User.
     */
    @Override
    public Object clone() {
        return new User(getName(),getSurname(), getPassword(), getEmail(), getUserNumber());
    }

    /**
     * Overridden equals() method
     * Check the equivalence of the users.
     * @return true if both name, surname and userNumber equal otherwise return false.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(!(obj instanceof User))
            return false;

        return (((User) obj).userNumber.equals(this.userNumber) && ((User) obj).password.equals(this.password));
    }
}
