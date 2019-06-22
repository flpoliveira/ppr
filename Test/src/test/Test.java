/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import hotel.Controlers.Singleton.UserFactorySingleton;
import hotel.Repositorios.RepositorioDeEstruturas;
import hotel.model.Cliente;
import hotel.model.Estrutura;
import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.builders.ClienteBuilder;
import hotel.model.builders.FuncionarioBuilder;
import hotel.model.enums.TipoEstrutura;
import hotel.model.enums.TipoFuncionario;
import static hotel.model.enums.TipoFuncionario.GERENTE;
import hotel.model.factorys.AbstractGenericFactory;
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
        
        UserFactorySingleton factory = UserFactorySingleton.getInstance();
        Funcionario a = factory.newInstance(TipoFuncionario.GERENTE);//AQUI FELIPE!!! ]
        //a.test();// mesmo criando o Gerente usando singleton ele n ta conseguindo acessar esse metodo dentro de gerente
        //talvez precise fazer casting mas dai n faz sentido usar isso
        ClienteBuilder teste = new ClienteBuilder();

        RepositorioDeEstruturas repEst = new RepositorioDeEstruturas();
        Estrutura x = new Estrutura();
        x.setTipo(TipoEstrutura.CLASSEMEDIA);
        repEst.addEstrutura(x);
        repEst.addEstrutura(x);
        ArrayList<Estrutura> oi = repEst.getEstruturaPTipo(TipoEstrutura.CLASSEMEDIA);
        for(int i = 0; i<oi.size(); i++){
            System.out.println(oi.get(i).getTipo());
        }
    }
}
