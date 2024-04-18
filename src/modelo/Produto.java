package modelo;

import utilitario.Utilitario;

public class Produto {
    private static int contador = 1;

    private String nomeProd;
    private int idProd;
    private double valor;
    private int quantidade;

    public Produto(String nomeProd, double valor) {
        this.nomeProd = nomeProd;
        this.idProd = contador;
        this.valor = valor;
        this.quantidade = 0; // Inicializa a quantidade como zero por padrão
        contador++;
    }

    public Produto(String nomeProd, double valor, int quantidade) {
        this(nomeProd, valor); // Chama o outro construtor para inicializar nome, valor e ID
        this.quantidade = quantidade; // Define a quantidade do produto
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public int getIdProd() {
        return idProd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return "Id: " + this.getIdProd() +
                "\nNome: " + this.getNomeProd() +
                "\nValor: " + Utilitario.doubleToString(this.getValor()) +
                "\nQuantidade: " + this.getQuantidade();
    }
}
