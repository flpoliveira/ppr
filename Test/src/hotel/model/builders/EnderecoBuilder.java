package hotel.model.builders;

import hotel.model.Endereco;

public class EnderecoBuilder {
    protected Long id;
    protected String cep;
    protected String rua;
    protected int numero;
    protected String cidade;
    protected String pais;

    
    public EnderecoBuilder addId(Long id){
        this.id = id;
        return this;
    }
    public EnderecoBuilder addCep(String cep){
        this.cep = cep;
        return this;
    }
    
    public EnderecoBuilder addRua(String rua){
        this.rua = rua;
        return this;
    }
    
    public EnderecoBuilder addNumero(int numero){
        this.numero = numero;
        return this;
    }
    public EnderecoBuilder addCidade(String cidade){
        this.cidade = cidade;
        return this;
    }
    public EnderecoBuilder addPais(String pais){
        this.pais = pais;
        return this;
    }

    public Endereco build(){

        Endereco endereco = new Endereco();
        endereco.setId(this.id);
        endereco.setCep(this.cep);
        endereco.setRua(this.rua);
        endereco.setNumero(this.numero);
        endereco.setCidade(this.cidade);
        endereco.setPais(this.pais);

        
        this.id = null;
        this.cep = null;
        this.rua = null;
        this.numero = 0;
        this.cidade = null;
        this.pais = null;

        
        return endereco;
    }
    
    
}
