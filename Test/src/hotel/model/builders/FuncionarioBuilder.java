/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.builders;

import hotel.model.Endereco;
import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.enums.Expediente;
import hotel.model.enums.TipoFuncionario;

/**
 *
 * @author udesc
 */
public  class FuncionarioBuilder {
    protected Long id;
    protected String cpf;
    protected String nome;
    protected String telefone;
    protected String senha;
    protected String rg;
    protected Endereco endereco;
    protected Double salario;
    protected Expediente expediente;
    
    
    
    
    public FuncionarioBuilder addId(Long id){
        this.id = id;
        return this;
    }
    public FuncionarioBuilder addCpf(String cpf){
        this.cpf = cpf;
        return this;
    }
    public FuncionarioBuilder addNome(String nome){
        this.nome = nome;
        return this;
    }
    public FuncionarioBuilder addTelefone (String telefone)
    {
        this.telefone = telefone;
        return this;
    }
    public FuncionarioBuilder addSenha(String senha)
    {
        this.senha = senha;
        return this;
    }
    public FuncionarioBuilder addRg(String rg)
    {
        this.rg = rg;
        return this;
    }
    public FuncionarioBuilder addEndereco(Endereco endereco)
    {
        this.endereco = endereco;
        return this;
    }
    public FuncionarioBuilder addSalario(Double salario)
    {
        this.salario = salario;
        return this;
    }
    public FuncionarioBuilder addExpediente(Expediente expediente)
    {
        this.expediente = expediente;
        return this;
    }
    public <T> T build(TipoFuncionario x)
    {
        Funcionario aux;
        switch(x)
        {
            case GERENTE:
                aux = new Gerente();
                break;
            default:
                aux = new Funcionario();
                break;
        }
        aux.setId(id);
        aux.setCpf(cpf);
        aux.setNome(nome);
        aux.setTelefone(telefone);
        aux.setSenha(senha);
        aux.setRg(rg);
        aux.setEndereco(endereco);
        aux.setSalario(salario);
        aux.setExpediente(expediente);
        this.id = null;
        this.cpf = null;
        this.nome = null;
        this.telefone = null;
        this.senha = null;
        this.rg = null;
        this.endereco = null;
        this.salario = null;
        this.expediente = null;
        
        return (T) aux;
    }
    
}
