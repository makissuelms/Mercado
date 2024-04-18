package principal;

import modelo.Produto;
import modelo.Estoque;
import modelo.CarrinhoDeCompras;
import java.util.List;

public class MercadoFacade {
    private Estoque estoque;
    private CarrinhoDeCompras carrinho;

    public MercadoFacade() {
        this.estoque = new Estoque();
        this.carrinho = new CarrinhoDeCompras();
    }

    public void cadastrarProduto(String nome, double valor, int quantidade) {
        Produto produto = new Produto(nome, valor, quantidade);
        estoque.adicionarProduto(produto, quantidade);
    }

    public List<Produto> listarProdutos() {
        return estoque.listarProdutos();
    }

    public void adicionarItemAoCarrinho(Produto produto, int quantidade) {
        carrinho.adicionarItem(produto, quantidade);
    }

    public void finalizarCompra() {
        carrinho.finalizarCompra();
    }

}
