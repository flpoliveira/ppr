/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.view;

import hotel.controller.Controller;
import hotel.controller.OperationEnum;
import hotel.view.vo.ClienteVO;
import hotel.view.vo.EnderecoVO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Filipe
 */
public class AppUI 
{
    private Controller controller;
    private Scanner scanner;
    private Long clienteId_Generator = 1L;
    private Long enderecoId_Generator = 1L;
    public AppUI()
    {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }
    
    public boolean addCliente()
    {
        ClienteVO cliente = new ClienteVO();
        cliente.setId(this.clienteId_Generator);
        clienteId_Generator++;
        System.out.println("Digite o nome do cliente:");
        cliente.setNome(this.scanner.next());
        System.out.println("Trata-se de um cliente juridico?\n 1 - Sim\n 2 - Não");
        switch(this.scanner.nextInt())
        {
            case 1:
                System.out.println("Digite o CNPJ do cliente:");
                cliente.setCNPJ(this.scanner.next());
                break;
            default:
                System.out.println("Digite o CPF do cliente:");
                cliente.setCPF(this.scanner.next());
                break;
        }
        System.out.println("Digite o numero de telefone:");
        cliente.setTelefone(this.scanner.next());
        EnderecoVO endereco = new EnderecoVO();
        endereco.setId(this.enderecoId_Generator);
        this.enderecoId_Generator++;
        System.out.println("Digite o cep:");
        endereco.setCep(this.scanner.next());
        System.out.println("Digite o nome da rua:");
        endereco.setRua(this.scanner.next());
        System.out.println("Digite o numero da residencia:");
        endereco.setNumero(this.scanner.nextInt());
        System.out.println("Digite o nome da cidade:");
        endereco.setCidade(this.scanner.next());
        System.out.println("Digite o nome do pais:");
        endereco.setPais(this.scanner.next());
        cliente.setEndereco(endereco);
        
        return (Boolean)this.controller.execute(OperationEnum.ADDCLIENT, cliente);
        
    }
    public boolean consultaClientes()
    {
        ArrayList<ClienteVO> clientes = (ArrayList<ClienteVO>) this.controller.execute(OperationEnum.GETALLCLIENTE, null);
        if(clientes.size() == 0)
            return false;
        System.out.println("---------Lista de Clientes-------- ");
        for(ClienteVO x : clientes)
        {
            //System.out.println(x.getId());
            System.out.print(x.getId());
            System.out.print("- ");
            System.out.println(x.getNome());
        }
        System.out.println("---------------------------------");
        while(true)
        {
            System.out.println("Para ver mais sobre algum cliente, digite o seu Id, ou 0 para voltar:");
            int entrada = this.scanner.nextInt();
            if(entrada == 0)
                break;
            ClienteVO cliente = (ClienteVO) this.controller.execute(OperationEnum.GETCLIENTEPERID, entrada);
            if(cliente == null)
                System.out.println("Usuario não encontrado.");
            else
            {
                System.out.println(cliente.toString());
            }
            
           
        }
       
        
        return false;
    }
    
    public boolean menu()
    {
        while(true)
        {
            System.out.println("---------HOTELARIA--------");
            System.out.println("1 - Adicionar cliente     ");
            System.out.println("2 - Consultar cliente     ");
            System.out.println("0 - Encerrar              ");
            System.out.println("--------------------------");
            switch(this.scanner.nextInt())
            {
                case 1:
                    if(this.addCliente())
                        System.out.println("Cliente cadastrado com sucesso");
                    else
                        System.out.println("Um erro ocorreu no cadastro de cliente.");
                    break;
                case 2:
                    this.consultaClientes();
                    break;
                default:
                    return false;
            }
        }
    }
}
