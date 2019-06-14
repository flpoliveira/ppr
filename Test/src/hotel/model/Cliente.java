
package hotel.model;

public class Cliente {

    private Long id;
    private boolean ehJuridico;
    private String CNPJ;
    private String Nome;
    private String telefone;
    private Endereco endereco;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEhJuridico() {
        return ehJuridico;
    }

    public void setEhJuridico(boolean ehJuridico) {
        this.ehJuridico = ehJuridico;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
