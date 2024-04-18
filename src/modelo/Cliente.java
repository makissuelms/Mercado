package modelo;

public class Cliente extends Pessoa {
    private int codigoCliente;

    public Cliente(String nome, String cpf, String endereco, String telefone, int codigoCliente) {
        super(nome, cpf, endereco, telefone);
        this.codigoCliente = codigoCliente;
    }

    // Getter e setter específico de Cliente
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}
