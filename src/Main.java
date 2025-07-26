import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> produtos = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        int opcao;

        do {
            // Menu principal
            System.out.println("\n==== Sistema de Controle de Estoque ====");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Registrar Entrada no Estoque");
            System.out.println("3. Registrar Saída do Estoque");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Adicionar produto
                    System.out.print("Digite o nome do produto: ");
                    scanner.nextLine(); // Limpar buffer
                    String produto = scanner.nextLine();
                    System.out.print("Digite a quantidade inicial: ");
                    int quantidade = scanner.nextInt();
                    produtos.add(produto);
                    quantidades.add(quantidade);
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2: // Registrar entrada no estoque
                    System.out.println("Escolha um produto para registrar a entrada:");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println(i + 1 + ". " + produtos.get(i));
                    }
                    System.out.print("Escolha o número do produto: ");
                    int indiceEntrada = scanner.nextInt() - 1;
                    if (indiceEntrada >= 0 && indiceEntrada < produtos.size()) {
                        System.out.print("Digite a quantidade a ser adicionada: ");
                        int entrada = scanner.nextInt();
                        quantidades.set(indiceEntrada, quantidades.get(indiceEntrada) + entrada);
                        System.out.println("Entrada registrada com sucesso!");
                    } else {
                        System.out.println("Produto inválido.");
                    }
                    break;

                case 3: // Registrar saída do estoque
                    System.out.println("Escolha um produto para registrar a saída:");
                    int i = 0;
                    while (i < produtos.size()) {
                        System.out.println(i + 1 + ". " + produtos.get(i));
                        i++;
                    }
                    System.out.print("Escolha o número do produto: ");
                    int indiceSaida = scanner.nextInt() - 1;
                    if (indiceSaida >= 0 && indiceSaida < produtos.size()) {
                        System.out.print("Digite a quantidade a ser retirada: ");
                        int saida = scanner.nextInt();
                        if (quantidades.get(indiceSaida) >= saida) {
                            quantidades.set(indiceSaida, quantidades.get(indiceSaida) - saida);
                            System.out.println("Saída registrada com sucesso!");
                        } else {
                            System.out.println("Quantidade insuficiente em estoque.");
                        }
                    } else {
                        System.out.println("Produto inválido.");
                    }
                    break;

                case 4: // Listar produtos
                    System.out.println("\n==== Lista de Produtos ====");
                    for (int j = 0; j < produtos.size(); j++) {
                        System.out.println("Produto: " + produtos.get(j) + " | Quantidade: " + quantidades.get(j));
                    }
                    break;

                case 5: // Sair
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();

    }
}