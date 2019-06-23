/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.repositories;

import hotel.model.Funcionario;
import hotel.model.Gerente;
import java.util.ArrayList;

/**
 *
 * @author Filipe
 */
public class GerenteRepository {
    private ArrayList<Gerente> gerentes;
    public GerenteRepository() 
    {
        this.gerentes = new ArrayList<>();
    }
    public boolean ehGerente(Long Id)
    {
        for(Gerente x : gerentes)
        {
            if(x.getId() == Id)
                return true;
        }
        return false;
    }
}
