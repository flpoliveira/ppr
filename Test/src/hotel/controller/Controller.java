/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controller;

import hotel.model.Cliente;
import hotel.model.Endereco;
import hotel.model.builders.ClienteBuilder;
import hotel.model.builders.EnderecoBuilder;
import hotel.model.repositories.*;
import hotel.view.vo.ClienteVO;
import hotel.view.vo.EnderecoVO;
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
    
    public Controller()
    {
        this.clienterepo = new ClienteRepository();
        this.estruturarepo = new EstruturaRepository();
        this.funcionariorepo = new FuncionarioRepository();
        this.reservarepo = new ReservaRepository();
    }
    private Cliente map(ClienteVO clienteVO)
    {
        
        ClienteBuilder clienteBuilder = new ClienteBuilder();
        EnderecoBuilder enderecoBuilder = new EnderecoBuilder();
        Endereco endereco = enderecoBuilder.addCep(clienteVO.getEndereco().getCep())
                .addId(clienteVO.getEndereco().getId())
                .addCidade(clienteVO.getEndereco().getCidade())
                .addNumero(clienteVO.getEndereco().getNumero())
                .addPais(clienteVO.getEndereco().getPais())
                .addRua(clienteVO.getEndereco().getRua())
                .build();
        Cliente cliente = clienteBuilder.addNome(clienteVO.getNome())
                .addId(clienteVO.getId())
                .addCNPJ(clienteVO.getCNPJ())
                .addCPF(clienteVO.getCPF())
                .addEndereco(endereco)
                .addtelefone(clienteVO.getTelefone())
                .build(clienteVO.isEhJuridico());
        return cliente;
                
  
    }
    private ClienteVO inversedMap(Cliente cliente)
    {
        EnderecoVO endereco = new EnderecoVO();
        endereco.setId(cliente.getEndereco().getId());
        endereco.setCep(cliente.getEndereco().getCep());
        endereco.setRua(cliente.getEndereco().getRua());
        endereco.setNumero(cliente.getEndereco().getNumero());
        endereco.setPais(cliente.getEndereco().getPais());
        endereco.setCidade(cliente.getEndereco().getCidade());
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setId(cliente.getId());
        clienteVO.setEhJuridico(cliente.isEhJuridico());
        clienteVO.setEndereco(endereco);
        clienteVO.setNome(cliente.getNome());
        clienteVO.setCNPJ(cliente.getCNPJ());
        clienteVO.setCPF(cliente.getCPF());
        clienteVO.setTelefone(cliente.getTelefone());
        return clienteVO;
        
    }
    public ArrayList<ClienteVO> mapClientes(ArrayList<Cliente> clientes)
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
                
        }
        return null;
    }
    
}
