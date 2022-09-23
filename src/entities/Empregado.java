package entities;

public class Empregado {
    private String Nome;
    private String email;
    private Double salario;

    public Empregado() {

    }

    public Empregado(String nome, String email, Double salario) {
        Nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empregado [Nome=" + Nome + ", email=" + email + ", salario=" + salario + "]";
    }
}
