
public class Company {
	private Integer id;
	private String name;
	private String cnpj;
	private Double tax;
	private Double balance;

	public Company() {
		super();
	}

	public Company(Integer id, String name, String cnpj, Double tax, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.tax = tax;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
