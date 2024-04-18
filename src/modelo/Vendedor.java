package modelo;

public class Vendedor extends Pessoa {
    private String matricula;

    public Vendedor(String nome, String cpf, String endereco, String telefone, String matricula) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
    }

    // Getter e setter específico de Vendedor
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
