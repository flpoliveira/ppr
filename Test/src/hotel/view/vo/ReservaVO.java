package hotel.view.vo;


import java.util.ArrayList;
import java.util.Date;

public class ReservaVO {

    private Long id; //ok
    private Date dataInicio;
    private Date dataFim;
    private Boolean pago;
    private ArrayList<ClienteVO> hospedes;
    private ClienteVO pagante;
    private boolean checkIn;
    private boolean checkOut;
    private FuncionarioVO responsavelReserva;
    private FuncionarioVO responsavelCheckIn;
    private FuncionarioVO responsavelCheckOut;
    private ArrayList<EstruturaVO> estrutura;
    private boolean ativo;
    

    
    public ArrayList<ClienteVO> getHospedes() {
        return hospedes;
    }

    public void setHospedes(ArrayList<ClienteVO> hospedes) {
        this.hospedes = hospedes;
    }

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
    

    public ClienteVO getPaganteVO() {
        return pagante;
    }

    public void setPaganteVO(ClienteVO pagante) {
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

    public FuncionarioVO getResponsavelReserva() {
        return responsavelReserva;
    }

    public void setResponsavelReserva(FuncionarioVO responsavelReserva) {
        this.responsavelReserva = responsavelReserva;
    }

    public FuncionarioVO getResponsavelCheckIn() {
        return responsavelCheckIn;
    }

    public void setResponsavelCheckIn(FuncionarioVO responsavelCheckIn) {
        this.responsavelCheckIn = responsavelCheckIn;
    }
    
    public FuncionarioVO getResponsavelCheckOut() {
        return responsavelCheckOut;
    }

    public void setResponsavelCheckOut(FuncionarioVO responsavelCheckOut) {
        this.responsavelCheckOut = responsavelCheckOut;
    }

    public ArrayList<EstruturaVO> getEstruturaVO() {
        return estrutura;
    }

    public void setEstruturaVO(ArrayList<EstruturaVO> estrutura) {
        this.estrutura = estrutura;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public String toString()
    {
        String x = "Reserva ID#"+this.getId();
        x = x + "\nData De Inicio:"+this.getDataInicio().toString();
        x = x + "\nData De Fim:"+this.getDataFim().toString();
        if(pago)
        {
            x = x+"\nPago por:";
            x = x + pagante.toString();
                    
        }
        else
            x = x +"\nAinda não foi paga!";
        if(hospedes != null && hospedes.size() > 0 )
        {
            x = x +"\n\nPossui os seguintes hospedes:";
            x = x + "\n============================\n";
            int cont = 1;
            for(ClienteVO hospede : hospedes)
            {
                x = x + "\n"+String.valueOf(cont) + " - " + hospede.getNome();
                cont++;
            }
            x = x + "\n============================\n";
        }            int cont = 1;

        if(checkIn)
        {
            x = x + "\nCheck in marcado pelo funcionario:";
            x = x + responsavelCheckIn.getNome();
        }
        if(checkOut)
        {
            x = x + "\nCheck Out marcado pelo funcionario:";
            x = x + responsavelCheckOut.getNome();
        }
        x = x +"\nResponsavel que criou a reserva:"+responsavelReserva.getNome()+"\n";
        if(estrutura != null & estrutura.size() > 0)
        {
            x = x + "\nAs seguintes estruturas foram adicionadas para esta reserva:";
            for(EstruturaVO y : estrutura)
            {
                x = x + "\n============================\n";
                x = x + "\n" + y.toString();
                x = x + "\n============================\n";
                
            }
        }
        
  
        return x;
    }
}
