package hotel.model.builders;

import hotel.model.Cliente;
import hotel.model.Estrutura;
import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.Reserva;
import hotel.model.enums.TipoFuncionario;
import java.util.ArrayList;
import java.util.Date;


public class ReservaBuilder {
    protected Long id;
    protected Date dataInicio;
    protected Date dataFim;
    protected boolean pago;
    protected ArrayList<Cliente> hospedes;
    protected Cliente pagante;
    protected boolean checkIn;
    protected boolean checkOut;
    protected Funcionario responsavelReserva;
    protected Funcionario responsavelCheckIn;
    protected Funcionario responsavelCheckOut;
    protected ArrayList<Estrutura>  estruturas;
    protected boolean ativo;
    
            
    public ReservaBuilder addId (Long id){
        this.id = id;
        return this;
    }
    
    public ReservaBuilder addDataInicio(Date dataInicio){
        this.dataInicio = dataInicio;
        return this;
    }
    
    public ReservaBuilder addDataFim (Date dataFim){
        this.dataFim = dataFim;
        return this;
    }
    public ReservaBuilder addPago (boolean pago){
        this.pago = pago;
        return this;
    }
    
    public ReservaBuilder addHospedes (ArrayList<Cliente> hospedes){
        this.hospedes = hospedes;
        return this;
    }
    public ReservaBuilder addPagante (Cliente pagante){
        this.pagante = pagante;
        return this;
    }
    
    public ReservaBuilder addCheckIn (boolean checkIn){
        this.checkIn = checkIn;
        return this;
    }
    
    public ReservaBuilder addCheckOut (boolean checkOut){
        this.checkOut = checkOut;
        return this;
    }
    
    public ReservaBuilder addResponsavelReserva (Funcionario responsavelReserva){
        this.responsavelReserva = responsavelReserva;
        return this;
    }
    
    public ReservaBuilder addResponsavelCheckin (Funcionario responsavelCheckIn){
        this.responsavelCheckIn = responsavelCheckIn;
        return this;
    }
    
    public ReservaBuilder addResposavelCheckOut (Funcionario responsavelCheckOut){
        this.responsavelCheckOut = responsavelCheckOut;
        return this;
    }
    
     public ReservaBuilder addEstrutura (ArrayList<Estrutura> estrutura){
        this.estruturas = estrutura;
        return this;
    }
     
     public ReservaBuilder addAtivo (boolean ativo){
         this.ativo = ativo;
         return this;
     }
     
     public Reserva build()
    {
        Reserva reserva = new Reserva();

        reserva.setId(id); //ok
        reserva.setDataInicio(dataInicio); //ok
        reserva.setDataFim(dataFim); //ok
        reserva.setPago(pago); //ok
        reserva.setHospedes(hospedes); //ok
        reserva.setPagante(pagante); //ok
        reserva.setCheckIn(checkIn); //ok
        reserva.setCheckOut(checkOut); //ok
        reserva.setResponsavelReserva(responsavelReserva); //ok
        reserva.setResponsavelCheckIn(responsavelCheckIn);//ok
        reserva.setResponsavelCheckOut(responsavelCheckOut);//ok
        reserva.setEstrutura(estruturas);//ok
        reserva.setAtivo(ativo);//ok
        
        this.id = null;
        this.dataInicio = null;
        this.dataFim = null;
        this.pago = false;
        this.hospedes = null;
        this.pagante = null;
        this.checkIn = false;
        this.checkOut = false;
        this.responsavelReserva = null;
        this.responsavelCheckIn = null;
        this.responsavelCheckOut = null;
        this.estruturas = null;
        this.ativo = false;
        
        return reserva;
    }

     /*
     protected Date dataInicio;
    protected Date dataFim;
    protected boolean pago;
    protected ArrayList<Cliente> hospedes;
    protected Cliente pagante;
    protected boolean checkIn;
    protected boolean checkOut;
    protected Funcionario responsavelReserva;
    protected Funcionario responsavelCheckIn;
    protected Funcionario responsavelCheckOut;
    protected ArrayList<Estrutura>  estruturas;
    protected boolean ativo;
     */

   
}
