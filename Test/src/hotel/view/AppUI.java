/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.view;

import hotel.controller.Controller;
import hotel.controller.OperationEnum;
import hotel.model.enums.TipoEstrutura;
import hotel.view.vo.ClienteVO;
import hotel.view.vo.EnderecoVO;
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
            System.out.println("2 - Adicionar estrutura   ");
            System.out.println("3 - Adicionar reserva     ");
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
                    if(this.addEstrutura()){
                        System.out.println("Estrutura cadastrada com sucesso.");
                    } else {
                        System.out.println("Um erro ocorreu no cadastro de estrutura.");
                    }
                
                case 3:
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
