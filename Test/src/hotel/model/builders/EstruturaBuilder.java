package hotel.model.builders;

import hotel.model.Cliente;
import hotel.model.Estrutura;
import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.enums.TipoEstrutura;
import hotel.model.enums.TipoFuncionario;

public class EstruturaBuilder {
    protected Long id;
    protected int andar;
    protected int numero;
    protected String descricao;
    protected boolean ativo;
    protected int qtdPessoas;
    protected TipoEstrutura tipo;
    
    public EstruturaBuilder addId(Long id){
        this.id = id;
        return this;
    }
    
    public EstruturaBuilder addAndar(int andar){
        this.andar = andar;
        return this;
    }
    
    public EstruturaBuilder addNumero(int numero){
        this.numero = numero;
        return this;
    }
    
    public EstruturaBuilder addDescricao (String descricao){
        this.descricao = descricao;
        return this;
    }
    
    public EstruturaBuilder addAtivo (boolean ativo){
        this.ativo = ativo;
        return this;
    }
    
    public EstruturaBuilder addQtdPessoas(int qtdPessoas){
        this.qtdPessoas = qtdPessoas;
        return this;
    }
    
    public EstruturaBuilder addTipoEstrutura (TipoEstrutura tipo){
        this.tipo = tipo;
        return this;
    }
    
    /*
    protected Long id;
    protected int andar;
    protected int numero;
    protected String descricao;
    protected boolean ativo;
    protected int qtdPessoas;
    protected TipoEstrutura tipo;
    */
    
        public Estrutura build(){

        Estrutura estrutura = new Estrutura();
        
        estrutura.setId(this.id);
        estrutura.setAndar(this.andar);
        estrutura.setNumero(this.numero);
        estrutura.setDescricao(this.descricao);
        estrutura.setAtivo(true);
        estrutura.setQtdPessoas(this.qtdPessoas);
        estrutura.setTipo(this.tipo);
        
        this.id = null;
        this.andar = 0;
        this.numero = 0;
        this.descricao = null;
        this.ativo = false;
        this.qtdPessoas = 0;
        this.tipo = null;
        
        return estrutura;
    }
}
