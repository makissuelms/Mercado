package principal;

// Importações de classes necessárias
import modelo.Produto; // Importa a classe Produto do pacote modelo
import utilitario.LimparConsole; // Importa a classe LimparConsole do pacote utilitario
import utilitario.Utilitario; // Importa a classe Utilitario do pacote utilitario

import java.util.ArrayList; // Importa a classe ArrayList do pacote java.util
import java.util.HashMap; // Importa a classe HashMap do pacote java.util
import java.util.Map; // Importa a classe Map do pacote java.util
import java.util.Scanner; // Importa a classe Scanner do pacote java.util

// Classe principal Mercado
public class Mercado {
    private static Scanner input = new Scanner(System.in); // Instância de Scanner para entrada de dados
    private static ArrayList<Produto> produtos; // Lista de produtos
    private static Map<Produto, Integer> carrinho; // Carrinho de compras
    private static int proximoId = 1; // Variável para controlar o próximo ID disponível

    // Método principal da aplicação
    public static void main(String[] args) {
        produtos = new ArrayList<>(); // Inicializa a lista de produtos
        carrinho = new HashMap<>(); // Inicializa o carrinho de compras
        menu(); // Chama o método menu para exibir o menu principal
    }

    // Método para exibir o menu principal e processar as opções escolhidas pelo usuário
    private static void menu() {
        // Exibe o cabeçalho do menu
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
        int opcao = input.nextInt(); // Lê a opção escolhida pelo usuário

        // Processa a opção escolhida
        switch (opcao) {
            case 1:
                cadastrarProd(); // Chama o método para cadastrar produtos
                break;
            case 2:
                listarProd(); // Chama o método para listar produtos
                break;
            case 3:
                editarProd(); // Chama o método para editar produtos
                break;
            case 4:
                removerProd(); // Chama o método para remover produtos
                break;
            case 5:
                comprarProd(); // Chama o método para comprar produtos
                break;
            case 6:
                verCarrinho(); // Chama o método para ver o carrinho de compras
                break;
            case 7:
                // Encerra o programa
                System.out.println("Obrigado pela preferência! Até a próxima!");
                System.exit(0);
            default:
                // Exibe uma mensagem de erro para opções inválidas e chama novamente o menu
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
        Double valor = input.nextDouble();
        Produto produto = new Produto(nome, valor);
        produto.setIdProd(proximoId);
        produtos.add(produto);
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

    // Método para listar produtos
    private static void listarProd() {
        LimparConsole.limparTela(); // Limpa a tela do console
        if (produtos.size() > 0) {
            // Exibe a lista de produtos
            System.out.println("╔═════════════Lista de Produtos═════════════╗\n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            // Exibe uma mensagem se não houver produtos cadastrados
            System.out.println("Nenhum produto cadastrado!");
        }

        menu(); // Retorna ao menu principal
    }

    // Método para remover produtos
    private static void removerProd() {
        LimparConsole.limparTela(); // Limpa a tela do console
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

        menu(); // Retorna ao menu principal
    }

    // Método para editar produtos
    private static void editarProd() {
        LimparConsole.limparTela(); // Limpa a tela do console
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

                    p.setNomeProd(novoNome);
                    p.setValor(novoValor);

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

        menu(); // Retorna ao menu principal
    }

    // Método para comprar produtos
    private static void comprarProd() {
        LimparConsole.limparTela(); // Limpa a tela do console
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
                    int qtProd;
                    try {
                        qtProd = carrinho.get(p);
                        carrinho.put(p, qtProd + 1);
                    } catch (NullPointerException e) {
                        carrinho.put(p, 1);
                    }

                    System.out.println(p.getNomeProd() + " adicionado ao carrinho!");
                    existe = true;
                }
            }

            // Se o produto não foi encontrado, exibe a mensagem e retorna ao menu principal
            if (!existe) {
                System.out.println("Produto não encontrado!");
            }

            // Pergunta se deseja comprar outro produto
            System.out.println("Deseja comprar outro produto?");
            System.out.print("Pressione 1 para SIM ou 0 para NÃO: ");
            int opcao = input.nextInt();

            if (opcao == 1) {
                comprarProd(); // Chama o método novamente para comprar outro produto
            } else {
                menu(); // Retorna ao menu principal se não desejar comprar outro produto
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
        if (carrinho.size() > 0) {
            for (Produto p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
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

    // Método para encerrar a compra
    private static void encerrarCompra() {
        LimparConsole.limparTela(); // Limpa a tela do console
        Double valorCompra = 0.0;
        System.out.println("╔═════════════Seus Itens═════════════╗");

        for (Produto p : carrinho.keySet()) {
            int qtProd = carrinho.get(p);
            valorCompra += p.getValor() * qtProd;
            System.out.println(p);
            System.out.println("Quantidade: " + qtProd);
            System.out.println("_________________________");
        }
        System.out.println("O valor da compra é: " + Utilitario.doubleToString(valorCompra));
        carrinho.clear();
        System.out.println("Obrigado pela preferência, volte sempre!");
        menu();
    }
}