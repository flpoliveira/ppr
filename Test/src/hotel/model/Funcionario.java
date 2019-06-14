/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

import hotel.model.enums.Expediente;

/**
 *
 * @author udesc
 */
public class Funcionario {
    private Long id;
    private String cpf;
    private String nome;
    private String senha;
    private String rg;
    private Endereco endereco;
    private Double salario;
    private Expediente expediente;

    public Funcionario(Long id, String cpf, String nome, String senha, String rg, Endereco endereco, Double salario, Expediente expediente)
    {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.endereco = endereco;
        this.salario = salario;
        this.expediente = expediente;
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
     * @param RG the RG to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
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
    
    
}
