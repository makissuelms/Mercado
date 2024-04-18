package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Estoque {
    private Map<Produto, Integer> estoque;

    public Estoque() {
        this.estoque = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        this.estoque.put(produto, quantidade);
    }

    public int verificarEstoque(Produto produto) {
        return this.estoque.getOrDefault(produto, 0);
    }

    public void removerProduto(Produto produto, int quantidade) {
        int quantidadeAtual = this.estoque.getOrDefault(produto, 0);
        int novaQuantidade = Math.max(quantidadeAtual - quantidade, 0);
        this.estoque.put(produto, novaQuantidade);
    }

    public void setQuantidadeProduto(Produto produto, int novaQuantidade) {
        this.estoque.put(produto, novaQuantidade);
    }

    // Método para listar os produtos no estoque
    public List<Produto> listarProdutos() {
        List<Produto> listaProdutos = new ArrayList<>();
        for (Produto produto : this.estoque.keySet()) {
            listaProdutos.add(produto);
        }
        return listaProdutos;
    }
}
