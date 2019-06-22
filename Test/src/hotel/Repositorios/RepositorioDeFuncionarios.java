/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Repositorios;

import hotel.model.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class RepositorioDeFuncionarios {
    private ArrayList<Funcionario> Funcionarios; // Gerente tambem vai alocado aqui, lembrar disso

        public RepositorioDeFuncionarios() {
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
        
}
