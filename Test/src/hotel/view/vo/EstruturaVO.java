package hotel.view.vo;

import hotel.model.enums.TipoEstrutura;

public class EstruturaVO {

    private Long id;
    private int andar;
    private int numero;
    private String descricao;
    private boolean ativo;
    private int qtdPessoas;
    private TipoEstrutura tipo;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getAndar() {
        return andar;
    }
    public void setAndar(int andar) {
        this.andar = andar;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public int getQtdPessoas() {
        return qtdPessoas;
    }
    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
    public TipoEstrutura getTipo() {
        return tipo;
    }
    public void setTipo(TipoEstrutura tipo) {
        this.tipo = tipo;
    }
    
    public String toString()
    {
        String x = "ID #"+this.getId();
        x = x + "\nDescricao: " + this.getDescricao();
        x = x + "\nAndar: "+this.getAndar();
        x = x + "\nNumero: "+this.getNumero();
        x = x + "\nCapacidade maxima de pessoas: "+this.qtdPessoas;
        switch(this.getTipo())
        {
            case CLASSEMEDIA:
                x = x+ "\nTipo: Classe Média";
                break;
            case LUXO:
                x = x+ "\nTipo: Luxo";
                break;
            case SUPERLUXO:
                x = x+ "\nTipo: Super Luxo";
                break;
            default:
                x = x+ "\nTipo: Standard";
                break;
        }
        if(this.isAtivo())
            x = x + "\nAtivo: Sim";
        else
            x = x + "\nAtivo: Não";
        
        return x;
    }
    
}
