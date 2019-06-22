
package hotel.view.vo;

import hotel.model.Endereco;

public class ClienteVO {

    private Long id;
    private boolean ehJuridico;
    private String CNPJ;
    private String CPF;
    private String Nome;
    private String telefone;
    private EnderecoVO endereco;
    
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
    
    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
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


    public EnderecoVO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoVO endereco) {
        this.endereco = endereco;
    }
    
}
