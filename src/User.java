
public class User {
	private String username;
	private String password;
	private Customer customer;
	private Company company;

	public User() {
		super();
	}

	public User(String username, String password, Customer customer, Company company) {
		super();
		this.username = username;
		this.password = password;
		this.customer = customer;
		this.company = company;
	}

	public boolean isAdmin() {
		return this.company == null && this.customer == null;
	}

	public boolean isCompany() {
		return this.company != null;
	}

	public boolean isCustomer() {
		return this.customer != null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
