/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.repositories;

import hotel.model.Cliente;
import hotel.model.Endereco;
import hotel.model.builders.ClienteBuilder;
import hotel.model.builders.EnderecoBuilder;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class ClienteRepository {
        private ArrayList<Cliente> Clientes;

        public ClienteRepository() {
        this.Clientes = new ArrayList<>();
        Endereco endereco = new EnderecoBuilder()
                .addCep("89230-423")
                .addCidade("Joinville")
                .addNumero(124)
                .addPais("Brasil")
                .addRua("Rua Pedro de campos")
                .build();
        Cliente seila = new ClienteBuilder().addNome("Xampson").addEndereco(endereco).addCPF("1234").build(false);
        this.addCliente(seila);
    }

	public ArrayList<Cliente> getClientes() {
		return this.Clientes;
	}
	public void addCliente(Cliente x) {
		this.Clientes.add(x);
	}
	public Cliente getClientePorCNPJ(String cnpj){
		for(int i = 0; i < this.Clientes.size(); i++) {
			Cliente cli = this.Clientes.get(i);
			String AUX = cli.getCNPJ();
			if(cnpj.equals(AUX)) {
                            return cli;
                        } else {
                        }
		}
		return null;
	}
	public Cliente getClientePorCpf(String cpf){
		for(int i = 0; i < this.Clientes.size(); i++) {
			Cliente cli = this.Clientes.get(i);
			String AUX = cli.getCPF();
			if(cpf.equals(AUX)) {
                            return cli;
                        } else {
                        }
		}
		return null;
	}
        public Cliente getClientePorId(Long id){
            for(Cliente x : this.Clientes)
            {
                if(x.getId() == id)
                {
                    return x;
                }
                    
            }
            return null;
        }
        
        public Cliente getClientePorCPForCNPJ(String entrada)
        {
            for(Cliente x : this.Clientes)
            {
                if(x.isEhJuridico())
                {
                     if(x.getCNPJ().equals(entrada))
                         return x;
                }
                else
                    if(x.getCPF().equals(entrada))
                        return x;
                   
            }
            return null;
        }
        
        public Long IdGenerator()
        {
            return (long)(this.Clientes.size()+1);
        }
}
