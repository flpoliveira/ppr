/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Controlers.Singleton;

import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.enums.TipoFuncionario;
import static hotel.model.enums.TipoFuncionario.GERENTE;

/**
 *
 * @author mathe
 */
public class UserFactorySingleton {
    private static UserFactorySingleton instance;
    private UserFactorySingleton(){}
    public static UserFactorySingleton getInstance(){
        synchronized(UserFactorySingleton.class){
            if(instance == null){
                instance = new UserFactorySingleton();
            }
        }
         return instance;
    }
    public Funcionario newInstance(TipoFuncionario userType){
        switch(userType){
            case GERENTE: return new Gerente();
        default: return null;
        }
    }
}
