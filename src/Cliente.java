
public class Cliente {
	private Integer id;
	private String cpf;
	private String nome;
	private String username;
	private Integer idade;

	public Cliente(Integer id, String cpf, String nome, String username, Integer idade) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.username = username;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
