/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

import hotel.model.repositories.ClienteRepository;
import hotel.model.repositories.EstruturaRepository;
import hotel.model.repositories.FuncionarioRepository;
import hotel.model.repositories.ReservaRepository;
import hotel.model.enums.Expediente;
import java.util.Date;

/**
 *
 * @author udesc
 */
public class Funcionario {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String senha;
    private String rg;
    private Endereco endereco;
    private Double salario;
    private Expediente expediente;
    
    public Funcionario()
    {
        
    }
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
     * @param rg
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
    
    public boolean login (String cpf, String senha, FuncionarioRepository repFunc){
        Funcionario aux = repFunc.getFuncionarioPorCpf(cpf);
        if(aux == null){
            return false;// caso nao tenha um funcionario com o cpf requisitado
        }
        else if(aux != null && cpf.equals(aux.getCpf()) && senha.equals(aux.getSenha())){
            return true; // se conseguil logar
        }
        else{
            return false;// usuario ou senha incorretos;
        }
    }
    public void cdsCliente(Long id,String nome,String telefone,boolean ehJur, String doc, Endereco endereco, ClienteRepository repCli){
        Cliente a = new Cliente();
        if(ehJur){
            a.setCNPJ(doc);
        }
        else a.setCPF(doc);
        a.setEhJuridico(ehJur);
        a.setId(id);
        a.setEndereco(endereco);
        a.setNome(nome);
        a.setTelefone(telefone);
        repCli.addCliente(a);
    }
    public void consultaCliente(int id, ClienteRepository repCli){
        Cliente a = repCli.getClientePorId(id);
        System.out.println("Nome: "+a.getNome()+"Telefone: "+a.getTelefone()+"Endereço"+a.getEndereco());
       // talvez precise mudar aqui ***colocar mais info
    }
     
    public void ConsultaEstrutura(int id, EstruturaRepository repEst){
        Estrutura x = repEst.getEstruturaPId(id);
        if(x != null){
            System.out.println("Ativo: "+x.isAtivo()+"Andar: "+x.getAndar()+"numero: "+x.getNumero()+"Suporta: "+x.getQtdPessoas()+" Pessoas"+" Tipo: "+x.getTipo());
        }else System.out.println("Id inexistente ou incorreta");
    }
    public void cdsReverva(Date dini, Date dfim, Cliente cli, ClienteRepository repCli, ReservaRepository repRes){
        // alguem implementa esse metodo aqui, nao entendi oque é pra fazer com a variavel Boolean Pago em reservas..
    }
    public void cancelaReserva(int id, ReservaRepository repRes){
        repRes.deletaReserva(id);// exclui a reserva do array de reservas
    }
    
    
}
