package modelo;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {
    private Map<Produto, Integer> itens;

    public CarrinhoDeCompras() {
        this.itens = new HashMap<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        int quantidadeAtual = this.itens.getOrDefault(produto, 0);
        this.itens.put(produto, quantidadeAtual + quantidade);
    }

    public void removerItem(Produto produto) {
        this.itens.remove(produto);
    }

    public Map<Produto, Integer> getItens() {
        return this.itens;
    }

    public void limpar() {
        this.itens.clear();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Produto, Integer> entry : this.itens.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            total += produto.getValor() * quantidade;
        }
        return total;
    }

    public void finalizarCompra() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio. Não há itens para finalizar a compra.");
        } else {
            System.out.println("======= Itens do Carrinho =======");
            for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
                Produto produto = entry.getKey();
                int quantidade = entry.getValue();
                double subtotal = produto.getValor() * quantidade;
                System.out.println("Produto: " + produto.getNomeProd() + "\nQuantidade: " + quantidade + "\nValor Unitário: R$" + produto.getValor() + "\nValor Total: R$" + subtotal);
                System.out.println(); // Adiciona uma quebra de linha após cada item
            }
            double total = calcularTotal();
            System.out.println("======= Total da Compra: R$" + total + " =======");
            limpar();
            System.out.println("Compra finalizada. O carrinho foi esvaziado.");
        }
    }
}
