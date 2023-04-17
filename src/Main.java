import java.util.*;

public class Main {
    public static void main(String[] args) {
        // SIMULANDO BANCO DE DADOS

        List<Product> cart = new ArrayList<Product>();
        List<Purchase> purchases = new ArrayList<Purchase>();

        Company company2 = new Company(1, "Level Varejo", "53239160000154", 0.05, 0.0);
        Company company = new Company(2, "SafeWay Padaria", "30021423000159", 0.15, 0.0);
        Company company3 = new Company(3, "SafeWay Restaurante", "41361511000116", 0.20, 0.0);

        Product product = new Product(1, "Pão Frances", 5, 3.50, company);
        Product product2 = new Product(2, "Coturno", 10, 400.0, company2);
        Product product3 = new Product(3, "Jaqueta Jeans", 15, 150.0, company2);
        Product product4 = new Product(4, "Calça Sarja", 15, 150.0, company2);
        Product product5 = new Product(5, "Prato feito - Frango", 10, 25.0, company3);
        Product product6 = new Product(6, "Prato feito - Carne", 10, 25.0, company3);
        Product product7 = new Product(7, "Suco Natural", 30, 10.0, company3);
        Product product8 = new Product(8, "Sonho", 5, 8.50, company);
        Product product9 = new Product(9, "Croissant", 7, 6.50, company);
        Product product10 = new Product(10, "Ché Gelado", 4, 5.50, company);

        Customer customer = new Customer(1, "07221134049", "Allan da Silva", "cliente", 20);
        Customer customer2 = new Customer(2, "72840700050", "Samuel da Silva", "cliente2", 24);

        User user1 = new User("admin", "1234", null, null);
        User user2 = new User("empresa", "1234", null, company);
        User user3 = new User("cliente", "1234", customer, null);
        User user4 = new User("cliente2", "1234", customer2, null);
        User user5 = new User("empresa2", "1234", null, company2);
        User user6 = new User("empresa3", "1234", null, company3);

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        List<Customer> customers = Arrays.asList(customer, customer2);
        List<Company> companies = Arrays.asList(company, company2, company3);
        List<Product> products = Arrays.asList(product, product2, product3, product4, product5, product6, product7,
                product8, product9, product10);

        Authentication authentication = new Authentication(users);

        execute(customers, companies, products, cart, purchases, authentication);
    }

    public static void execute(List<Customer> customers, List<Company> companies,
                               List<Product> products, List<Product> carrinho, List<Purchase> purchases, Authentication authentication) {
        Scanner sc = new Scanner(System.in);
        int initialMenu;

        do {
            System.out.println("Bem vindo, escolha uma opção: ");
            System.out.println("1. Login");
            System.out.println("2. Logoff");
            System.out.print("Opção escolhida: ");

            initialMenu = sc.nextInt();

            switch (initialMenu) {
                case 1 -> {
                    System.out.println("Login:");
                    System.out.println("Entre com seu usuário e senha:");
                    System.out.print("Usuário: ");
                    String username = sc.next();
                    System.out.print("Senha: ");
                    String password = sc.next();
                    Optional<User> user = authentication.authenticate(username, password);
                    if (user.isPresent()) {
                        User loggedUser = user.get();
                        System.out.println("Login bem sucedido");
                        int choice;

                        if (loggedUser.isCompany()) {
                            System.out.println("Olá, " + loggedUser.getCompany().getName());
                            System.out.println();

                            do {
                                System.out.println("Escolha uma opção para iniciar");
                                System.out.println("1 - Listar vendas");
                                System.out.println("2 - Ver produtos");
                                System.out.println("0 - Deslogar");
                                System.out.println();
                                System.out.print("Opção: ");
                                choice = sc.nextInt();

                                switch (choice) {
                                    case 1 -> {
                                        System.out.println();
                                        System.out.println("************************************************************");
                                        System.out.println("VENDAS EFETUADAS");
                                        purchases.forEach(purchase -> {
                                            if (purchase.getCompany().getId().equals(loggedUser.getCompany().getId())) {
                                                System.out.println("************************************************************");
                                                System.out.println("Venda de código: " + purchase.getCode() + " no CPF "
                                                        + purchase.getCustomer().getCpf() + ": ");
                                                purchase.getItens().forEach(x -> {
                                                    System.out.println(x.getId() + " - " + x.getName() + "    R$" + x.getPrice());
                                                });
                                                System.out.println("Total Venda: R$" + purchase.getCost());
                                                System.out.println("Total Taxa a ser paga: R$" + purchase.getSystemComission());
                                                System.out.println("Total Líquido  para empresa: R$"
                                                        + (purchase.getCost() - purchase.getSystemComission()));
                                                System.out.println("************************************************************");
                                            }

                                        });
                                        System.out.println("Saldo da Empresa R$: " + loggedUser.getCompany().getBalance());
                                        System.out.println("************************************************************\n");
                                    }
                                    case 2 -> {
                                        System.out.println();
                                        System.out.println("************************************************************");
                                        System.out.println("MEUS PRODUTOS");
                                        products.forEach(product -> {
                                            if (product.getCompany().getId().equals(loggedUser.getCompany().getId())) {
                                                System.out.println("************************************************************");
                                                System.out.println("Código: " + product.getId());
                                                System.out.println("Produto: " + product.getName());
                                                System.out.println("Quantidade em estoque: " + product.getQuantity());
                                                System.out.println("Valor: R$" + product.getPrice());
                                                System.out.println("************************************************************");
                                            }

                                        });
                                        System.out.println("Saldo Empresa: " + loggedUser.getCompany().getBalance());
                                        System.out.println("************************************************************\n");
                                    }
                                    case 0 -> System.out.println("\nUsuário deslogado");
                                }
                            } while (choice != 0);

                        } else if (loggedUser.isCustomer()) {
                            System.out.println("Olá, " + loggedUser.getCustomer().getName());
                            System.out.println();

                            do {
                                System.out.println("Escolha uma opção para iniciar");
                                System.out.println("1 - Relizar Compras");
                                System.out.println("2 - Ver Compras");
                                System.out.println("0 - Deslogar");
                                System.out.print("Opção: ");
                                choice = sc.nextInt();

                                switch (choice) {
                                    case 1 -> {
                                        System.out.println("\nPara realizar uma compra, escolha a empresa onde deseja comprar: ");
                                        companies.forEach(x -> {
                                            System.out.println(x.getId() + " - " + x.getName());
                                        });
                                        System.out.print("Número da empresa escolhida: ");
                                        Integer chosenCompany = sc.nextInt();
                                        int chosenProduct;
                                        do {
                                            System.out.println("\nEscolha os seus produtos ou finalize a compra: ");
                                            products.forEach(x -> {
                                                if (x.getCompany().getId().equals(chosenCompany)) {
                                                    System.out.println(x.getId() + " - " + x.getName());
                                                }
                                            });
                                            System.out.println("0 - Finalizar compra");
                                            System.out.print("Número da opção escolhida: ");
                                            chosenProduct = sc.nextInt();
                                            for (Product productSearch : products) {
                                                if (productSearch.getId().equals(chosenProduct))
                                                    carrinho.add(productSearch);
                                            }
                                        } while (chosenProduct != 0);
                                        System.out.println("\n************************************************************");
                                        System.out.println("Resumo da compra: ");
                                        carrinho.forEach(x -> {
                                            if (x.getCompany().getId().equals(chosenCompany)) {
                                                System.out.println(x.getId() + " - " + x.getName() + "    R$" + x.getPrice());
                                            }
                                        });
                                        Company companyEscolhida = companies.stream().filter(x -> x.getId().equals(chosenCompany))
                                                .toList().get(0);
                                        Customer customerLogado = customers.stream()
                                                .filter(x -> x.getUsername().equals(loggedUser.getUsername()))
                                                .toList().get(0);
                                        Purchase purchase = criarVenda(carrinho, companyEscolhida, customerLogado, purchases);
                                        System.out.println("Total: R$" + purchase.getCost());
                                        System.out.println("************************************************************\n");
                                        carrinho.clear();
                                    }
                                    case 2 -> {
                                        System.out.println();
                                        System.out.println("************************************************************");
                                        System.out.println("COMPRAS EFETUADAS");
                                        purchases.forEach(v -> {
                                            if (v.getCustomer().getUsername().equals(loggedUser.getUsername())) {
                                                System.out.println("************************************************************");
                                                System.out.println("Compra de código: " + v.getCode() + " na empresa "
                                                        + v.getCompany().getName() + ": ");
                                                v.getItens().forEach(x -> {
                                                    System.out.println(x.getId() + " - " + x.getName() + "    R$" + x.getPrice());
                                                });
                                                System.out.println("Total: R$" + v.getCost());
                                                System.out.println("************************************************************");
                                            }
                                        });
                                        System.out.println("************************************************************\n");
                                    }
                                    case 0 -> System.out.println("\nUsuário deslogado\n");
                                }
                            } while (choice != 0);
                        } else {
                            System.out.println("Olá, " + loggedUser.getUsername());
                        }

                    } else
                        System.out.println("Usuário ou senha incorretos");
                }
                case 2 -> {
                    System.out.println("Logoff:");
                    System.out.println("Você saiu da aplicação.");
                    return;
                }
                default -> System.out.println("Opção inválida, escolha de novo.");
            }
        } while (true);
    }

    public static Purchase criarVenda(List<Product> carrinho, Company company, Customer customer, List<Purchase> purchases) {
        Double total = carrinho.stream().mapToDouble(Product::getPrice).sum();
        carrinho.forEach(product -> product.setQuantity(product.getQuantity() - 1));

        Double comissaoSistema = total * company.getTax();
        Double totalLiquido = total - comissaoSistema;
        company.setBalance(company.getBalance() + totalLiquido);

        int idVenda = purchases.isEmpty() ? 1 : purchases.get(purchases.size() - 1).getCode() + 1;
        Purchase purchase = new Purchase(idVenda, carrinho.stream().toList(), total, comissaoSistema, company, customer);
        purchases.add(purchase);

        return purchase;
    }
}
