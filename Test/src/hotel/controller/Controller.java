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
        Endereco endereco = enderecoBuilder.addCep(clienteVO.getEndereco()
                .getCep())
                .addCidade(clienteVO.getEndereco().getCidade())
                .addNumero(clienteVO.getEndereco().getNumero())
                .addPais(clienteVO.getEndereco().getPais())
                .addRua(clienteVO.getEndereco().getRua())
                .build();
        Cliente cliente = clienteBuilder.addNome(clienteVO.getNome())
                .addCNPJ(clienteVO.getCNPJ())
                .addCPF(clienteVO.getCPF())
                .addEndereco(endereco)
                .addtelefone(clienteVO.getTelefone())
                .build(clienteVO.isEhJuridico());
        return cliente;
                
  
    }
    public Object execute(OperationEnum en, Object data)
    {
        switch(en)
        {
            case ADDCLIENT:
                Cliente cliente = this.map((ClienteVO) data);
                clienterepo.addCliente(cliente);
                return true;
                
        }
        return null;
    }
    
}
