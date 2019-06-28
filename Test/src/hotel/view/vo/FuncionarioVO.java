/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.view.vo;

import hotel.model.Endereco;
import hotel.model.enums.Expediente;

/**
 *
 * @author Filipe
 */
public class FuncionarioVO {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String senha;
    private String rg;
    private EnderecoVO endereco;
    private Double salario;
    private Expediente expediente;
    
    public FuncionarioVO()
    {
        
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the RG
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the endereco
     */
    public EnderecoVO getEnderecoVO() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEnderecoVO(EnderecoVO endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the expediente
     */
    public Expediente getExpediente() {
        return expediente;
    }

    /**
     * @param expediente the expediente to set
     */
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
      @Override
    public String toString()
    {
        String x = "ID #"+this.getId()+"\nNome: "+this.getNome();
        x = x+"\nCPF: "+this.getCpf();
        x = x+"\nRG: "+this.getRg();
        switch(this.getExpediente())
        {
            case MATUTINO:
                x = x + "\nExpediente: Matutino";
                break;
            case NOTURNO:
                x = x + "\nExpediente: Noturno";
                break;
            default:
                x = x + "\nExpediente: Vespertino";
                break;
        }
        x = x+"\nTelefone: "+this.getTelefone();
        x = x+"\n"+endereco.toString();
        return x;
               
             
    }
   
//    public void consultaCliente(int id, ClienteRepository repCli){
//        Cliente a = repCli.getClientePorId(id);
//        System.out.println("Nome: "+a.getNome()+"Telefone: "+a.getTelefone()+"Endereço"+a.getEndereco());
//       // talvez precise mudar aqui ***colocar mais info
//    }
     
  
    
    
}

