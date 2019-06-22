package hotel.model;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {

    /**
     * @return the hospedes
     */
    public ArrayList<Cliente> getHospedes() {
        return hospedes;
    }

    /**
     * @param hospedes the hospedes to set
     */
    public void setHospedes(ArrayList<Cliente> hospedes) {
        this.hospedes = hospedes;
    }

 
    private Long id; //ok
    private Date dataInicio;
    private Date dataFim;
    private Boolean pago;
    private ArrayList<Cliente> hospedes;
    private Cliente pagante;
    private boolean checkIn;
    private boolean checkOut;
    private Funcionario responsavelReserva;
    private Funcionario responsavelCheckIn;
    private Funcionario responsavelCheckOut;
    private ArrayList<Estrutura> estrutura;
    private boolean ativo;
    

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }
    
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
    

    public Cliente getPagante() {
        return pagante;
    }

    public void setPagante(Cliente pagante) {
        this.pagante = pagante;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Funcionario getResponsavelReserva() {
        return responsavelReserva;
    }

    public void setResponsavelReserva(Funcionario responsavelReserva) {
        this.responsavelReserva = responsavelReserva;
    }

    public Funcionario getResponsavelCheckIn() {
        return responsavelCheckIn;
    }

    public void setResponsavelCheckIn(Funcionario responsavelCheckIn) {
        this.responsavelCheckIn = responsavelCheckIn;
    }
    
    public Funcionario getResponsavelCheckOut() {
        return responsavelCheckOut;
    }

    public void setResponsavelCheckOut(Funcionario responsavelCheckOut) {
        this.responsavelCheckOut = responsavelCheckOut;
    }

    public ArrayList<Estrutura> getEstrutura() {
        return estrutura;
    }

    public void setEstrutura(ArrayList<Estrutura> estrutura) {
        this.estrutura = estrutura;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
