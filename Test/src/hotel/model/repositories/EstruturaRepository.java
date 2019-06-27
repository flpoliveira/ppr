/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.repositories;

import hotel.model.Estrutura;
import hotel.model.builders.EstruturaBuilder;
import hotel.model.enums.TipoEstrutura;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class EstruturaRepository {
    private ArrayList<Estrutura> Estruturas;

    public EstruturaRepository() {
        this.Estruturas = new ArrayList<>();
        EstruturaBuilder estrutura = new EstruturaBuilder();
        Estrutura a = estrutura.addAndar(1).addAtivo(false).addDescricao("Top").addNumero(1).addQtdPessoas(10).addId(Long.decode("2")).addTipoEstrutura(TipoEstrutura.LUXO).build();
        this.addEstrutura(a);
    }   

	public ArrayList<Estrutura> getEstruturas() {
		return this.Estruturas;
	}
	public void addEstrutura(Estrutura x) { // ver no diagrama
		this.Estruturas.add(x);
	}
	public ArrayList<Estrutura> getEstruturaPTipo(TipoEstrutura tipo){
                ArrayList<Estrutura> aux = new ArrayList<Estrutura>();
		for(int i = 0; i < this.Estruturas.size(); i++) {
			Estrutura est = this.Estruturas.get(i);
			if(tipo.equals(est.getTipo())){
                            aux.add(est);
                        }
		}
		return aux;
	}
        public Estrutura getEstruturaPId(Long id){
		for(Estrutura x : Estruturas)
                {
                    if(x.getId() == id)
                        return x;
                }
                return null;
	}
}
