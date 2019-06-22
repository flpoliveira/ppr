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
import java.util.Scanner;

/**
 *
 * @author Filipe
 */
public class AppUI 
{
    private Controller controller;
    private Scanner scanner;
    public AppUI()
    {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }
    
    public boolean addCliente()
    {
        ClienteVO cliente = new ClienteVO();
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
    
    public boolean menu()
    {
        while(true)
        {
            System.out.println("---------HOTELARIA--------");
            System.out.println("1 - Adicionar cliente     ");
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
                default:
                    return false;
            }
        }
    }
}
