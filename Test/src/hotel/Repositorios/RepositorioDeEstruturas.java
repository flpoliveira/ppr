/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Repositorios;

import hotel.model.Estrutura;
import hotel.model.enums.TipoEstrutura;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class RepositorioDeEstruturas {
    private ArrayList<Estrutura> Estruturas;

    public RepositorioDeEstruturas() {
        this.Estruturas = new ArrayList<>();
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
        public Estrutura getEstruturaPId(int id){
		for(int i = 0; i < this.Estruturas.size(); i++) {
                    Estrutura aux = this.Estruturas.get(i);
                    if(aux.getId().equals(id)){
                        return aux;
                    }
		}
                return null;
	}
}
