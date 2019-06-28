/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.repositories;

import hotel.model.Estrutura;
import hotel.model.Reserva;
import hotel.model.builders.ReservaBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class ReservaRepository {
    private ArrayList<Reserva> Reservas;

    public ReservaRepository() {
        this.Reservas = new ArrayList<>();
        
    }
    public ReservaRepository(Estrutura estrutura) throws ParseException
    {
        this.Reservas = new ArrayList<>();
        ReservaBuilder reservaBuilder = new ReservaBuilder();
        SimpleDateFormat formator = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicio = formator.parse("12/11/2019");
        Date dataFim = formator.parse("13/11/2019");
        ArrayList<Estrutura> estruturas = new ArrayList<Estrutura>();
        estruturas.add(estrutura);
        Reserva reserva = reservaBuilder.addId(5L)
                .addDataInicio(dataInicio)
                .addDataFim(dataFim)
                .addEstrutura(estruturas)
                .build();
        this.Reservas.add(reserva);
        
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
        
        public boolean disponibilidadeReserva(Reserva reserva, Estrutura k)
        {
            //System.out.println("Estou aqui");
               for(Reserva x : this.Reservas)
               {
                  //System.out.println("EstouAaqui2");
                   //System.out.println(reserva.getDataFim().compareTo(x.getDataInicio()));
                   //System.out.println(x.getDataFim().compareTo(reserva.getDataInicio()));
                   if(reserva.getDataFim().compareTo(x.getDataInicio()) > 0  && x.getDataFim().compareTo(reserva.getDataInicio()) > 0) 
                   {
                       //System.out.println("Conflito de datas encontrado:");
                       for(Estrutura y : x.getEstrutura())
                       {
                           if(k.getId() == y.getId())
                           {
                               System.out.println("**Estrutura " + y.getId() + " já está sendo usada para esta data");
                               return false;
                           }
                           //if ($dtNF > $dtBISiga && $dtNI < $dtBFSiga)
                               
                       }
                   }
               }
               return true;
        }
        public Reserva getReservaPId(Long id){
		for(Reserva x : Reservas)
                {
                    if(x.getId() == id && x.isAtivo())
                        return x;
                }
                return null;
	}
}
