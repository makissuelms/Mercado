package principal;

import modelo.Produto;
import modelo.Estoque;
import modelo.CarrinhoDeCompras;
import utilitario.LimparConsole;
import utilitario.Utilitario;

import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class Mercado {
    private static Mercado instancia = null;
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Estoque estoque;
    private static CarrinhoDeCompras carrinho; // Substitui o mapa carrinho
    private static int proximoId = 1;

    // Construtor privado
    private Mercado() {
        produtos = new ArrayList<>();
        carrinho = new CarrinhoDeCompras();
        estoque = new Estoque();
    }

    // Método estático para obter a instância única
    public static Mercado getInstance() {
        if (instancia == null) {
            instancia = new Mercado();
        }
        return instancia;
    }


    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new CarrinhoDeCompras(); // Inicializa o carrinho de compras
        estoque = new Estoque();
        menu();
    }

    private static void menu() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║          Bem-vindo(a) a LC Tecnologia        ║");
        System.out.println("║              Loja de Informática             ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 1 - Cadastrar Produtos                       ║");
        System.out.println("║ 2 - Listar Produtos                          ║");
        System.out.println("║ 3 - Editar Produtos                          ║");
        System.out.println("║ 4 - Remover Produtos                         ║");
        System.out.println("║ 5 - Comprar                                  ║");
        System.out.println("║ 6 - Carrinho/Finalizar Compra                ║");
        System.out.println("║ 7 - Sair                                     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("Digite o número da opção desejada: ");
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                cadastrarProd();
                break;
            case 2:
                listarProd();
                break;
            case 3:
                editarProd();
                break;
            case 4:
                removerProd();
                break;
            case 5:
                comprarProd();
                break;
            case 6:
                verCarrinho();
                break;
            case 7:
                System.out.println("Obrigado pela preferência! Até a próxima!");
                System.exit(0);
            default:
                System.out.println("Opção Inválida! Digite uma das opções listadas.");
                menu();
                break;
        }
    }

    // Método para cadastrar produtos
    private static void cadastrarProd() {
        LimparConsole.limparTela(); // Limpa a tela do console
        System.out.print("Digite o nome do produto: ");
        String nome = input.next();
        System.out.print("Digite o valor do produto: ");
        double valor = input.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = input.nextInt(); // Nova linha para solicitar a quantidade

        Produto produto = new Produto(nome, valor, quantidade); // Modificação para passar a quantidade
        produtos.add(produto);
        estoque.adicionarProduto(produto, quantidade); // Atualiza o estoque com a quantidade cadastrada
        System.out.println(produto.getNomeProd() + " cadastrado com sucesso!");

        proximoId++;

        // Pergunta se deseja cadastrar outro produto
        System.out.println("Deseja cadastrar outro produto?");
        System.out.print("Pressione 1 para SIM ou 0 para NÃO: ");
        int opcao = input.nextInt();

        // Verifica a opção escolhida pelo usuário
        if (opcao == 1) {
            cadastrarProd(); // Chama recursivamente o método para cadastrar outro produto
        } else if (opcao == 0) {
            menu(); // Retorna ao menu principal se não desejar cadastrar outro produto
        } else {
            System.out.println("Opção inválida! Retornando ao menu principal.");
            menu(); // Retorna ao menu principal se a opção não for válida
        }
    }


    private static void listarProd() {
        LimparConsole.limparTela();
        if (produtos.size() > 0) {
            System.out.println("╔═════════════Lista de Produtos═════════════╗\n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }

    private static void removerProd() {
        LimparConsole.limparTela();
        if (produtos.size() > 0) {
            System.out.println("Lista de Produtos:");

            for (Produto p : produtos) {
                System.out.println("ID: " + p.getIdProd() + " - " + p.getNomeProd());
            }

            System.out.print("\nDigite o ID do produto que deseja remover: ");
            int id = input.nextInt();

            boolean removido = false;
            for (Produto p : produtos) {
                if (p.getIdProd() == id) {
                    produtos.remove(p);
                    System.out.println("Produto removido com sucesso!");
                    removido = true;
                    break;
                }
            }

            if (!removido) {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Não existem produtos cadastrados para remover.");
        }

        menu();
    }

    private static void editarProd() {
        LimparConsole.limparTela();
        if (produtos.size() > 0) {
            System.out.println("Lista de Produtos:");

            for (Produto p : produtos) {
                System.out.println("ID: " + p.getIdProd() + " - " + p.getNomeProd());
            }

            System.out.print("\nDigite o ID do produto que deseja editar: ");
            int id = input.nextInt();

            boolean encontrado = false;
            for (Produto p : produtos) {
                if (p.getIdProd() == id) {
                    encontrado = true;
                    System.out.println("Digite o novo nome do produto: ");
                    String novoNome = input.next();
                    System.out.println("Digite o novo valor do produto: ");
                    double novoValor = input.nextDouble();
                    System.out.println("Digite a nova quantidade do produto: ");
                    int novaQuantidade = input.nextInt();

                    p.setNomeProd(novoNome);
                    p.setValor(novoValor);
                    p.setQuantidade(novaQuantidade);

                    System.out.println("Produto editado com sucesso!");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Não existem produtos cadastrados para editar.");
        }

        menu();
    }

    private static void comprarProd() {
        LimparConsole.limparTela();
        if (produtos.size() > 0) {
            System.out.println("╔═════════════Produtos Disponíveis═════════════╗");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }
            System.out.print("Digite o código do item que deseja comprar: ");

            int id = Integer.parseInt(input.next());
            boolean existe = false;

            for (Produto p : produtos) {
                if (p.getIdProd() == id) {
                    carrinho.adicionarItem(p, 1); // Adiciona 1 unidade ao carrinho
                    System.out.println(p.getNomeProd() + " adicionado ao carrinho!");
                    existe = true;
                }
            }

            if (!existe) {
                System.out.println("Produto não encontrado!");
            }

            System.out.println("Deseja comprar outro produto?");
            System.out.print("Pressione 1 para SIM ou 0 para NÃO: ");
            int opcao = input.nextInt();

            if (opcao == 1) {
                comprarProd();
            } else {
                menu();
            }
        } else {
            System.out.println("Não existe produtos cadastrados!");
            menu();
        }
    }

    // Método para ver o carrinho de compras
    private static void verCarrinho() {
        LimparConsole.limparTela(); // Limpa a tela do console
        System.out.println("╔═════════════Produtos no Carrinho═════════════╗");
        if (carrinho.getItens().size() > 0) {
            for (Map.Entry<Produto, Integer> entry : carrinho.getItens().entrySet()) {
                Produto produto = entry.getKey();
                int quantidade = entry.getValue();
                double valorTotal = produto.getValor() * quantidade;
                System.out.println("Produto: " + produto.getNomeProd() + "\nQuantidade: " + quantidade + "\nValor Unitário: " + Utilitario.doubleToString(produto.getValor()) + "\nValor Total: " + Utilitario.doubleToString(valorTotal) + "\n");
            }

            // Pergunta se deseja encerrar a compra
            System.out.println("Deseja encerrar a compra?");
            System.out.print("Pressione 1 para SIM ou 0 para NÃO: ");
            int opcao = input.nextInt();

            if (opcao == 1) {
                encerrarCompra();
            } else {
                menu();
            }
        } else {
            System.out.println("Carrinho Vazio");
            menu();
        }
    }
    private static void encerrarCompra() {
        LimparConsole.limparTela();
        double valorCompra = carrinho.calcularTotal(); // Usa o método calcularTotal do carrinho
        System.out.println("╔═════════════Seus Itens═════════════╗");

        for (Map.Entry<Produto, Integer> entry : carrinho.getItens().entrySet()) {
            Produto produto = entry.getKey();
            int quantidadeVendida = entry.getValue();

            int estoqueDisponivel = estoque.verificarEstoque(produto);
            if (quantidadeVendida > estoqueDisponivel) {
                System.out.println("Quantidade insuficiente em estoque para o produto: " + produto.getNomeProd());
                continue;
            }

            estoque.removerProduto(produto, quantidadeVendida);
            System.out.println("Nome: " + produto.getNomeProd());
            System.out.println("Valor: " + Utilitario.doubleToString(produto.getValor()));
            System.out.println("Quantidade: " + quantidadeVendida);
            System.out.println("_________________________");

            int novaQuantidadeEstoque = estoqueDisponivel - quantidadeVendida;
            estoque.setQuantidadeProduto(produto, novaQuantidadeEstoque);
        }
        System.out.println("O valor da compra é: " + Utilitario.doubleToString(valorCompra));
        carrinho.limpar(); // Limpa o carrinho após a compra
        System.out.println("Obrigado pela preferência, volte sempre!");
        menu();
    }
}
