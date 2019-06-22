/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

import hotel.model.repositories.EstruturaRepository;
import hotel.model.repositories.FuncionarioRepository;

/**
 *
 * @author udesc
 */
public class Gerente extends Funcionario{
    public void test(){
        System.out.println("oi");
    }
    public void cdsFunc(Funcionario funcionario, FuncionarioRepository repFunc){
        repFunc.addFuncionario(funcionario);
    }
    public void cdsEstrutura(Long id,int qtd,int andar, int numero, String descricao, boolean ativo, EstruturaRepository repEst){
        Estrutura x = new Estrutura();
        x.setAndar(andar);
        x.setAtivo(ativo);
        x.setNumero(numero);
        x.setDescricao(descricao);
        x.setId(id);
        x.setQtdPessoas(qtd);
        repEst.addEstrutura(x);
    }
    public void consultaFuncionario(String cpf, FuncionarioRepository repFunc){
        Funcionario a = repFunc.getFuncionarioPorCpf(cpf);
        System.out.println("Nome: "+a.getNome()+"Telefone: "+a.getTelefone()+"Expediente: "+a.getExpediente());
       // talvez precise mudar aqui ***colocar mais info
    }
    public void ativaEstrutura(int id, EstruturaRepository repEst){
        Estrutura a = repEst.getEstruturaPId(id);
        a.setAtivo(true);
    }
    public void inativaEstrutura(int id, EstruturaRepository repEst){
        Estrutura a = repEst.getEstruturaPId(id);
        a.setAtivo(false);
    }
    
}
