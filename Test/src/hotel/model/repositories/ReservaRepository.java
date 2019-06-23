/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.repositories;

import hotel.model.Reserva;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class ReservaRepository {
    private ArrayList<Reserva> Reservas;

    public ReservaRepository() {
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
        public void updateReserva(Reserva reserva)
        {
            for(Reserva x : Reservas)
            {
                if(x.getId() == reserva.getId())
                {
                    x.setCheckIn(reserva.isCheckIn());
                    x.setCheckOut(reserva.isCheckOut());
                    x.setEstrutura(reserva.getEstrutura());
                    x.setPagante(reserva.getPagante());
                    x.setHospedes(reserva.getHospedes());
                    x.setResponsavelCheckIn(reserva.getResponsavelCheckIn());
                    x.setResponsavelCheckOut(reserva.getResponsavelCheckOut());
                    x.setResponsavelReserva(reserva.getResponsavelReserva());
                    x.setAtivo(reserva.isAtivo());
                    x.setPago(reserva.getPago());
                    x.setDataInicio(reserva.getDataInicio());
                    x.setDataFim(reserva.getDataFim());
                    return;
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
