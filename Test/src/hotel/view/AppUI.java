/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.view;

import hotel.controller.Controller;
import hotel.controller.OperationEnum;
import hotel.model.Cliente;
import hotel.model.enums.TipoEstrutura;
import hotel.view.vo.ClienteVO;
import hotel.view.vo.EnderecoVO;
import java.util.ArrayList;
import hotel.view.vo.EstruturaVO;
import hotel.view.vo.ReservaVO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    public boolean addReserva() throws ParseException{
        ReservaVO reserva = new ReservaVO();
        System.out.println("Digite o dia, mes e ano respectivamente do inicio da reserva.");
        String dia, mes, ano;
        
        dia = scanner.next();
        mes = scanner.next();
        ano = scanner.next();
        
        String str = dia+"/"+mes+"/"+ano;
        SimpleDateFormat formator = new SimpleDateFormat("dd/MM/yyyy");
        Date data_inicio = formator.parse(str);
        reserva.setDataInicio(data_inicio);
        System.out.println("Digite o dia, mes e ano respectivamente do fim da reserva.");
        String diafim, mesfim, anofim;
        
        diafim = scanner.next();
        mesfim = scanner.next();
        anofim = scanner.next();
        
        String strfim = diafim+"/"+mesfim+"/"+anofim;
        SimpleDateFormat formatorfim = new SimpleDateFormat("dd/MM/yyyy");
        Date data_fim = formatorfim.parse(strfim);
        //Date inicio fim, pago, check-in realizado ou não, checkout, ativo,
        
        System.out.println("A reserva já foi paga?\n 1 - Pago\n 2 - Não pago\n");
        switch(scanner.nextInt()){
            case 1:
                reserva.setAtivo(true);
            case 2:
                reserva.setAtivo(false);
        }
        System.out.println("O check-in foi realizado? 1 - Check-in realizado\n 2 - Check-in não realizado\n");
        switch(scanner.nextInt()){
            case 1:
                reserva.setCheckIn(true);
            case 2:
                reserva.setCheckOut(false);
        }
        
        reserva.setCheckOut(false); //n faz sentido fazer uma reserva q já foi feito check out
        reserva.setAtivo(true);
        
        ArrayList<ClienteVO> hospedes = new ArrayList();
        ArrayList<ClienteVO> clientes = (ArrayList<ClienteVO>) this.controller.execute(OperationEnum.GETALLCLIENTE, null);
        
        
        while(true){
            int cadas;
            System.out.println("Deseja cadastrar um hospede? 1 - 1 para sim\n 2 - para não\n");
            cadas = scanner.nextInt();
            if(cadas != 1){
                break;
            } else {
                System.out.println("Digite o CPF do hospede a ser adicionado a lista de hospedes.");
                String cpf_user = scanner.nextLine();
                for(ClienteVO x : clientes){
                    if(x.getCPF() == cpf_user){
                        hospedes.add(x);
                    }
                }
            }
        }
        
        System.out.println("Digite o cpf do pagante");
        String cpf_user = scanner.nextLine();
            for(ClienteVO x : clientes){
                if(x.getCPF() == cpf_user){
                    reserva.setPagante(x);
                    break;
                }
            }
            //falta os funcionários responsáveise a lista de estrutura
        
        
        
        
            
        
        
        

        return false;
    }
    
    public boolean addEstrutura(){
        EstruturaVO estrutura = new EstruturaVO();
        System.out.println("Digite o andar da estrutura:");
        estrutura.setAndar(this.scanner.nextInt());
        System.out.println("Digite o número:");
        estrutura.setNumero(this.scanner.nextInt());
        System.out.println("Digite a descrição da estrutura:");
        estrutura.setDescricao(this.scanner.next());
        System.out.println("A estrutura está ativa?\n 1- Sim\n 2 - Não\n");
        switch(this.scanner.nextInt())
        {
            case 1:
                estrutura.setAtivo(true);
            default:
                estrutura.setAtivo(false);     
        }
        System.out.println("Digite a quantidade de pessoas:");
        estrutura.setQtdPessoas(this.scanner.nextInt());
        System.out.println("Qual o tipo da estrutura?\n 1 - Standart\n 2 - Classe Média\n 3 - Luxo\n 4 - Super Luxo\n");
        
        switch(this.scanner.nextInt()){
            case 1:
                estrutura.setTipo(TipoEstrutura.STANDART);
            case 2:
                estrutura.setTipo(TipoEstrutura.CLASSEMEDIA);
            case 3:
                estrutura.setTipo(TipoEstrutura.LUXO);
            case 4: estrutura.setTipo(TipoEstrutura.SUPERLUXO);

        }
        return (Boolean) this.controller.execute(OperationEnum.ADDESTRUTURA, estrutura);
        
        
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
                cliente.setEhJuridico(true);
                break;
            default:
                System.out.println("Digite o CPF do cliente:");
                cliente.setCPF(this.scanner.next());
                cliente.setEhJuridico(false);
                break;
        }
        this.scanner.nextLine();
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
        
        System.out.println("Confirmando os dados do cliente:");
        System.out.println(cliente.toString());
        System.out.println("-------------------------------");
        System.out.println(" 1 - Sim");
        System.out.println(" 2 - Nao");
        if(scanner.nextInt() == 1)
            return (Boolean)this.controller.execute(OperationEnum.ADDCLIENT, cliente);
        else
            return false;
        
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
            System.out.println("3 - Adicionar estrutura   ");
            System.out.println("4 - Adicionar reserva     ");
            System.out.println("0 - Encerrar              ");
            System.out.println("--------------------------");
            switch(this.scanner.nextInt())
            {
                case 1:
                    if(this.addCliente())
                        System.out.println("Cliente cadastrado com sucesso.");
                    else
                        System.out.println("Um erro ocorreu no cadastro de cliente.");
                    break;
                case 2:
                    this.consultaClientes();
                    break;
      
                case 3:
                    if(this.addEstrutura()){
                        System.out.println("Estrutura cadastrada com sucesso.");
                    } else {
                        System.out.println("Um erro ocorreu no cadastro de estrutura.");
                    }
                
                case 4:
                    //if(this.addReserva()){
                    //    System.out.println("alvaslvvava");
                    //} else {
                    //   System.out.println("lascnkanja");
                    //}
                default:
                    return false;
            }
        }
    }
    
    
}
