package hotel.model.builders;

import hotel.model.Cliente;
import hotel.model.Endereco;


public class ClienteBuilder {
    protected Long id;
    //protected boolean ehJuridico;
    protected String CNPJ;
    protected String CPF;
    protected String Nome;
    protected String telefone;
    protected Endereco endereco;
    
    public ClienteBuilder addId(Long id){
        this.id = id;
        return this;
    }
    
    public ClienteBuilder addCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
        return this;
    }
    
    public ClienteBuilder addCPF(String CPF){
        this.CPF = CPF;
        return this;
    }
    
    public ClienteBuilder addNome(String Nome){
        this.Nome = Nome;
        return this;
    }
    
    public ClienteBuilder addTelefone(String telefone){
        this.telefone = telefone;
        return this;
    }
    
    public ClienteBuilder addEndereco(Endereco endereco){
        this.endereco = endereco;
        return this;
    }
    
    /**
     *
     * @return
     */
    public Cliente build(boolean ehJuridico){

        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        //cliente.setEhJuridico(this.ehJuridico);
        if(ehJuridico)
        {
            cliente.setCNPJ(this.CNPJ);
            cliente.setEhJuridico(true);
        }
        else
        {
            cliente.setCPF(this.CPF);
            cliente.setEhJuridico(false);
        }
        cliente.setNome(this.Nome);
        cliente.setEndereco(this.endereco);
        
        this.id = null;
        this.CNPJ = null;
        this.CPF = null;
        this.Nome = null;
        this.endereco = null;
        return cliente;
    }
        
        
}   
