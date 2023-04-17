import java.util.List;

public class Purchase {
	private Integer code;
	private List<Product> itens;
	private Double cost;
	private Double systemComission;
	private Company company;
	private Customer customer;

	public Purchase(Integer code, List<Product> itens, Double cost, Double systemComission, Company company, Customer customer) {
		super();
		this.code = code;
		this.itens = itens;
		this.cost = cost;
		this.systemComission = systemComission;
		this.company = company;
		this.customer = customer;
	}

	public Purchase() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Product> getItens() {
		return itens;
	}

	public void setItens(List<Product> itens) {
		this.itens = itens;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getSystemComission() {
		return systemComission;
	}

	public void setSystemComission(Double systemComission) {
		this.systemComission = systemComission;
	}
}
