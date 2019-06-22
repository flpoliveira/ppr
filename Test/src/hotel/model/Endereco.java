/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

/**
 *
 * @author udesc
 */
public class Endereco {
    private Long id;
    private String cep;
    private String rua;
    private int numero;
    private String cidade;
    private String pais;
    private String unidadeFederativa;
    
    public Endereco(Long id, String cep, String rua, String cidade, String pais, String unidadeFederativa)
    {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.pais = pais;
        this.unidadeFederativa = unidadeFederativa;
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the unidadeFederativa
     */
    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    /**
     * @param unidadeFederativa the unidadeFederativa to set
     */
    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
   
    
}
