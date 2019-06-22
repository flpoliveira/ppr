/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Repositorios;

import hotel.model.Reserva;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class RepositorioDeReservas {
    private ArrayList<Reserva> Reservas;

    public RepositorioDeReservas() {
        this.Reservas = new ArrayList<>();
    }

	public ArrayList<Reserva> getReservas() {
		return this.Reservas;
	}
        public void deletaReserva(int id){
            for(int i = 0; i < this.Reservas.size(); i++) {
                Reserva aux = this.Reservas.get(i);
                if(aux.getId().equals(id)){
                    this.Reservas.remove(aux);
                }
            }
        }
	public void addReserva(Reserva x) { // ver no diagrama
		this.Reservas.add(x);
        }
        public Reserva getReservaPId(int id){
		for(int i = 0; i < this.Reservas.size(); i++) {
                    Reserva aux = this.Reservas.get(i);
                    if(aux.getId().equals(id)){
                        return aux;
                    }
		}
                return null;
	}
}
