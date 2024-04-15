package modelo;

import utilitario.Utilitario;

public class Produto {
    private static int contador = 1;

    private String nomeProd;
    private int idProd;
    private double valor;

    public Produto(String nomeProd, double valor) {
        this.nomeProd = nomeProd;
        this.idProd = contador;
        this.valor = valor;
        contador++;
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

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return "Id: " + this.getIdProd() +
                "\nNome: " + this.getNomeProd() +
                "\nValor: " + Utilitario.doubleToString(this.getValor());
    }
}
