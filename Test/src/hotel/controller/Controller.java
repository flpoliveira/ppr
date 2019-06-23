/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controller;

import hotel.model.Cliente;
import hotel.model.Endereco;
import hotel.model.Estrutura;
import hotel.model.Funcionario;
import hotel.model.Gerente;
import hotel.model.Reserva;
import hotel.model.builders.ClienteBuilder;
import hotel.model.builders.EnderecoBuilder;
import hotel.model.builders.EstruturaBuilder;
import hotel.model.builders.FuncionarioBuilder;
import hotel.model.builders.ReservaBuilder;
import hotel.model.enums.TipoFuncionario;
import hotel.model.repositories.*;
import hotel.view.vo.ClienteVO;
import hotel.view.vo.EnderecoVO;
import hotel.view.vo.EstruturaVO;
import hotel.view.vo.FuncionarioVO;
import hotel.view.vo.ReservaVO;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class Controller 
{
    private ClienteRepository clienterepo;
    private EstruturaRepository estruturarepo;
    private FuncionarioRepository funcionariorepo;
    private ReservaRepository reservarepo;
    private GerenteRepository gerenterepo;
    
    public Controller()
    {
        this.clienterepo = new ClienteRepository();
        this.estruturarepo = new EstruturaRepository();
        this.funcionariorepo = new FuncionarioRepository();
        this.reservarepo = new ReservaRepository();
        this.gerenterepo = new GerenteRepository();
    }
    private Endereco mapEndereco(EnderecoVO enderecoVO)
    {
        EnderecoBuilder enderecoBuilder = new EnderecoBuilder();
        Endereco endereco = enderecoBuilder
                .addCep(enderecoVO.getCep())
                .addId(enderecoVO.getId())
                .addCidade(enderecoVO.getCidade())
                .addNumero(enderecoVO.getNumero())
                .addPais(enderecoVO.getPais())
                .addRua(enderecoVO.getRua())
                .build();
        return endereco;
    }
    
    private Cliente map(ClienteVO clienteVO)
    {
        
        ClienteBuilder clienteBuilder = new ClienteBuilder();
        Cliente cliente = clienteBuilder.addNome(clienteVO.getNome())
                .addId(clienteVO.getId())
                .addCNPJ(clienteVO.getCNPJ())
                .addCPF(clienteVO.getCPF())
                .addEndereco(this.mapEndereco(clienteVO.getEndereco()))
                .addTelefone(clienteVO.getTelefone())
                .build(clienteVO.isEhJuridico());
        return cliente;
                
  
    }
    private EnderecoVO inversedMapEndereco(Endereco endereco)
    {
        EnderecoVO enderecoVO = new EnderecoVO();
        enderecoVO.setId(endereco.getId());
        enderecoVO.setCep(endereco.getCep());
        enderecoVO.setRua(endereco.getRua());
        enderecoVO.setNumero(endereco.getNumero());
        enderecoVO.setPais(endereco.getPais());
        enderecoVO.setCidade(endereco.getCidade());
        return enderecoVO;
    }
    private FuncionarioVO inversedMapFuncionario(Funcionario funcionario)
    {
        FuncionarioVO funcionarioVO = new FuncionarioVO();
        funcionarioVO.setCpf(funcionario.getCpf());
        funcionarioVO.setEnderecoVO(this.inversedMapEndereco(funcionario.getEndereco()));
        funcionarioVO.setExpediente(funcionario.getExpediente());
        funcionarioVO.setId(funcionario.getId());
        funcionarioVO.setNome(funcionario.getNome());
        funcionarioVO.setRg(funcionario.getRg());
        funcionarioVO.setSalario(funcionario.getSalario());
        funcionarioVO.setSenha(funcionario.getSenha());
        funcionarioVO.setTelefone(funcionario.getTelefone());
        return funcionarioVO;
    }
    private ClienteVO inversedMap(Cliente cliente)
    {
       
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setId(cliente.getId());
        clienteVO.setEhJuridico(cliente.isEhJuridico());
        clienteVO.setEndereco(this.inversedMapEndereco(cliente.getEndereco()));
        clienteVO.setNome(cliente.getNome());
        clienteVO.setCNPJ(cliente.getCNPJ());
        clienteVO.setCPF(cliente.getCPF());
        clienteVO.setTelefone(cliente.getTelefone());
        return clienteVO;
        
    }
    private Estrutura mapEstrutura(EstruturaVO estruturaVO)
    {
        EstruturaBuilder estruturaBuilder = new EstruturaBuilder();
        Estrutura estrutura = estruturaBuilder
                .addAndar(estruturaVO.getAndar())
                .addAtivo(estruturaVO.isAtivo())
                .addDescricao(estruturaVO.getDescricao())
                .addId(estruturaVO.getId())
                .addNumero(estruturaVO.getNumero())
                .addQtdPessoas(estruturaVO.getQtdPessoas())
                .addTipoEstrutura(estruturaVO.getTipo())
                .build();
       return estrutura;
        
    }
    private Funcionario mapFuncionario(FuncionarioVO funcionarioVO)
    {
        FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
        System.out.println("AIDS");
        Funcionario funcionario = funcionarioBuilder
                .addCpf(funcionarioVO.getCpf())
                .addEndereco(this.mapEndereco(funcionarioVO.getEnderecoVO()))
                .addExpediente(funcionarioVO.getExpediente())
                .addNome(funcionarioVO.getNome())
                .addRg(funcionarioVO.getRg())
                .addSalario(funcionarioVO.getSalario())
                .addSenha(funcionarioVO.getSenha())
                .build(gerenterepo.ehGerente(funcionarioVO.getId())? TipoFuncionario.GERENTE : TipoFuncionario.FUNCIONARIO);
        return funcionario;
                
    }
    private Reserva mapReserva(ReservaVO reservaVO)
    {
        ReservaBuilder reservaBuilder = new ReservaBuilder();
        ArrayList<Estrutura> estruturas = new ArrayList<>();
        for(EstruturaVO x : reservaVO.getEstruturaVO())
        {
           estruturas.add(this.mapEstrutura(x));
        }
        ArrayList<Cliente> hospedes = new ArrayList<>();
        for(ClienteVO x : reservaVO.getHospedes())
        {
            hospedes.add(this.map(x));
        }
        Reserva reserva = reservaBuilder
                .addId(reservaVO.getId())
                .addAtivo(reservaVO.isAtivo())
                .addCheckIn(reservaVO.isCheckIn())
                .addCheckOut(reservaVO.isCheckOut())
                .addDataFim(reservaVO.getDataFim())
                .addDataInicio(reservaVO.getDataInicio())
                .addEstrutura(estruturas)
                .addHospedes(hospedes)
                .addPagante(this.map(reservaVO.getPaganteVO()))
                .addPago(reservaVO.getPago())
                .addResponsavelCheckin(this.mapFuncionario(reservaVO.getResponsavelCheckIn()))
                .addResponsavelReserva(this.mapFuncionario(reservaVO.getResponsavelReserva()))
                .addResposavelCheckOut(this.mapFuncionario(reservaVO.getResponsavelCheckOut()))
                .build();
        return reserva;
        
    }
   
    private ArrayList<ClienteVO> mapClientes(ArrayList<Cliente> clientes)
    {
        ArrayList<ClienteVO> lista = new ArrayList<>();
        for(Cliente x : clientes)
        {
            lista.add(this.inversedMap(x));
        }
        return lista;
    }
    public Object execute(OperationEnum en, Object data)
    {
        switch(en)
        {
            case ADDCLIENT:
                Cliente cliente = this.map((ClienteVO) data);
                clienterepo.addCliente(cliente);
                return true;
            case GETALLCLIENTE:
                return this.mapClientes(clienterepo.getClientes());
            case GETCLIENTEPERID:
                    return this.inversedMap(clienterepo.getClientePorId(Long.valueOf((int)data)));
            case UPDATERESERVA:
                    Reserva reserva = this.mapReserva((ReservaVO) data);
                    reservarepo.updateReserva(reserva);
                    return true;
            case GETCLIENTEPERCPFORCNPJ:
                    return this.inversedMap(clienterepo.getClientePorCPForCNPJ((String) data));
            case ADDRESERVA:
                reservarepo.addReserva(this.mapReserva((ReservaVO) data));
                return true;
            case LOGINFUNCIONARIO:
                Funcionario func = this.funcionariorepo.login(((FuncionarioVO) data).getCpf(),((FuncionarioVO) data).getSenha());
                if(func == null)
                {
                    func = (Funcionario) this.gerenterepo.login(((FuncionarioVO) data).getCpf(),((FuncionarioVO) data).getSenha());
                   
                }
                if(func != null)
                    return this.inversedMapFuncionario(func);
                else
                    return null;
            case EHGERENTE:
                return this.gerenterepo.ehGerente((Long) data);
                
                
        }
        return null;
    }
    
}
