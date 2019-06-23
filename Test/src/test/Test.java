/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import hotel.controler.singleton.UserFactorySingleton;
import hotel.model.repositories.EstruturaRepository;
import hotel.model.Cliente;
import hotel.model.Endereco;
import hotel.model.Estrutura;
import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.builders.ClienteBuilder;
import hotel.model.builders.EnderecoBuilder;
import hotel.model.builders.FuncionarioBuilder;
import hotel.model.enums.Expediente;
import hotel.model.enums.TipoEstrutura;
import hotel.model.enums.TipoFuncionario;
import static hotel.model.enums.TipoFuncionario.GERENTE;
import hotel.model.factorys.AbstractGenericFactory;
import hotel.view.AppUI;
import java.util.ArrayList;

/**
 *
 * @author udesc
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException 
    {
        // TODO code application logic here
       /* 
        FuncionarioBuilder test = new FuncionarioBuilder();
        Funcionario test2 = test.addCpf("123456").addId(new Long("1234")).build(TipoFuncionario.GERENTE);
        System.out.println(test2.getId());
        */
        
//        UserFactorySingleton factory = UserFactorySingleton.getInstance();
//        Funcionario a = factory.newInstance(TipoFuncionario.GERENTE);//AQUI FELIPE!!! ]
//        //a.test();// mesmo criando o Gerente usando singleton ele n ta conseguindo acessar esse metodo dentro de gerente
//        //talvez precise fazer casting mas dai n faz sentido usar isso
//        ClienteBuilder teste = new ClienteBuilder();
//
//        EstruturaRepository repEst = new EstruturaRepository();
//        Estrutura x = new Estrutura();
//        x.setTipo(TipoEstrutura.CLASSEMEDIA);
//        repEst.addEstrutura(x);
//        repEst.addEstrutura(x);
//        ArrayList<Estrutura> oi = repEst.getEstruturaPTipo(TipoEstrutura.CLASSEMEDIA);
//        for(int i = 0; i<oi.size(); i++){
//            System.out.println(oi.get(i).getTipo());
//        }
        FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
        EnderecoBuilder enderecoBuilder = new EnderecoBuilder();
        Endereco endereco = enderecoBuilder
                .addCep("89230-413")
                .addCidade("Joinville")
                .addNumero(123)
                .addPais("Brasil")
                .addRua("Rua Pedro de campos")
                .build();
        Gerente admin = (Gerente) funcionarioBuilder
                .addCpf("admin")
                .addEndereco(endereco)
                .addSalario(99999999d)
                .addSenha("admin")
                .addRg("1.123.123-12")
                .addTelefone("(47)3434-3434")
                .addExpediente(Expediente.MATUTINO)
                .addNome("admin")
                .build(GERENTE);
 
    }
}
