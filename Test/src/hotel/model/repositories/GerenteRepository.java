/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.repositories;

import hotel.model.Endereco;
import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.builders.EnderecoBuilder;
import hotel.model.builders.FuncionarioBuilder;
import hotel.model.enums.Expediente;
import static hotel.model.enums.TipoFuncionario.GERENTE;
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
                .addId(Long.MAX_VALUE)
                .addCpf("admin")
                .addEndereco(endereco)
                .addSalario(99999999d)
                .addSenha("admin")
                .addRg("1.123.123-12")
                .addTelefone("(47)3434-3434")
                .addExpediente(Expediente.MATUTINO)
                .addNome("admin")
                .build(GERENTE);
       this.gerentes.add(admin);
    }
    public void addGerente(Funcionario x)
    {
        getGerentes().add((Gerente) x);
    }
    public boolean ehGerente(Long Id)
    {
        for(Gerente x : getGerentes())
        {
            if(x.getId() == Id)
                return true;
        }
        return false;
    }
    
     public Funcionario login(String cpf, String senha)
     {
            for(Funcionario x : getGerentes())
            {
                if(x.getCpf().equals(cpf))
                {
                    if(x.getSenha().equals(senha))
                        return x;
                }
            }
            return null;
     }

    /**
     * @return the gerentes
     */
    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    /**
     * @param gerentes the gerentes to set
     */
    public void setGerentes(ArrayList<Gerente> gerentes) {
        this.gerentes = gerentes;
    }
    public Funcionario getGerentePorId(Long id)
    {
            for(Gerente x : gerentes)
            {
                if(x.getId() == id)
                    return x;
            }
            return null;
    }
}
