/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

<<<<<<< HEAD
import hotel.Repositorios.RepositorioDeEstruturas;
import hotel.Repositorios.RepositorioDeFuncionarios;
=======
import hotel.model.repositories.EstruturaRepository;
import hotel.model.repositories.FuncionarioRepository;
>>>>>>> master

/**
 *
 * @author udesc
 */
public class Gerente extends Funcionario{
    public void test(){
        System.out.println("oi");
    }
<<<<<<< HEAD
    public void cdsFunc(Funcionario funcionario, RepositorioDeFuncionarios repFunc){
        repFunc.addFuncionario(funcionario);
    }
    public void cdsEstrutura(Long id,int qtd,int andar, int numero, String descricao, boolean ativo, RepositorioDeEstruturas repEst){
=======
    public void cdsFunc(Funcionario funcionario, FuncionarioRepository repFunc){
        repFunc.addFuncionario(funcionario);
    }
    public void cdsEstrutura(Long id,int qtd,int andar, int numero, String descricao, boolean ativo, EstruturaRepository repEst){
>>>>>>> master
        Estrutura x = new Estrutura();
        x.setAndar(andar);
        x.setAtivo(ativo);
        x.setNumero(numero);
        x.setDescricao(descricao);
        x.setId(id);
        x.setQtdPessoas(qtd);
        repEst.addEstrutura(x);
    }
<<<<<<< HEAD
    public void consultaFuncionario(String cpf, RepositorioDeFuncionarios repFunc){
=======
    public void consultaFuncionario(String cpf, FuncionarioRepository repFunc){
>>>>>>> master
        Funcionario a = repFunc.getFuncionarioPorCpf(cpf);
        System.out.println("Nome: "+a.getNome()+"Telefone: "+a.getTelefone()+"Expediente: "+a.getExpediente());
       // talvez precise mudar aqui ***colocar mais info
    }
<<<<<<< HEAD
    public void ativaEstrutura(int id, RepositorioDeEstruturas repEst){
        Estrutura a = repEst.getEstruturaPId(id);
        a.setAtivo(true);
    }
    public void inativaEstrutura(int id, RepositorioDeEstruturas repEst){
=======
    public void ativaEstrutura(int id, EstruturaRepository repEst){
        Estrutura a = repEst.getEstruturaPId(id);
        a.setAtivo(true);
    }
    public void inativaEstrutura(int id, EstruturaRepository repEst){
>>>>>>> master
        Estrutura a = repEst.getEstruturaPId(id);
        a.setAtivo(false);
    }
    
}
