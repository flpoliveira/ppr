/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.repositories;

import hotel.model.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class FuncionarioRepository {
    private ArrayList<Funcionario> Funcionarios; // Gerente tambem vai alocado aqui, lembrar disso

        public FuncionarioRepository() 
        {
            this.Funcionarios = new ArrayList<>();
        }

	public ArrayList<Funcionario> getFuncionarios() {
		return this.Funcionarios;
	}
	public void addFuncionario(Funcionario x) {
		this.Funcionarios.add(x);
	}
        
	public Funcionario getFuncionarioPorCpf(String cpf){
		for(int i = 0; i < this.Funcionarios.size(); i++) {
			Funcionario func = this.Funcionarios.get(i);
			String AUX = func.getCpf();
			if(cpf.equals(AUX)) {
                            return func;
                        } 
		}
		return null;
	}
        public Funcionario login(String cpf, String senha)
        {
            for(Funcionario x : Funcionarios)
            {
                if(x.getCpf().equals(cpf))
                {
                    if(x.getSenha().equals(senha))
                        return x;
                }
            }
            return null;
        }
        public Funcionario getFuncionarioPorId(Long id)
        {
            for(Funcionario x : Funcionarios)
            {
                if(x.getId() == id)
                    return x;
            }
            return null;
        }
}
