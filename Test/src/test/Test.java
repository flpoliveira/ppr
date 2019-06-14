/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import hotel.model.Funcionario;
import hotel.model.builders.FuncionarioBuilder;
import hotel.model.enums.TipoFuncionario;
import hotel.model.factorys.AbstractGenericFactory;

/**
 *
 * @author udesc
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        FuncionarioBuilder test = new FuncionarioBuilder();
        Funcionario test2 = test.addCpf("123456").addId(new Long("1234")).build(TipoFuncionario.GERENTE);
        System.out.println(test2.getId());
    }
}
