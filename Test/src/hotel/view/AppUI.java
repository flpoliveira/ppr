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
import hotel.view.vo.FuncionarioVO;
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
    private FuncionarioVO logado;
    private boolean logadoEhGerente;
    public AppUI()
    {
        this.logadoEhGerente = false;
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
        this.logadoEhGerente = false;
        this.logado = null;
        
    }
    public boolean efetuarPagamentoReserva(ReservaVO reserva)
    {
        if(reserva == null)
        {
            System.out.println("ERRO -> reserva não recebida para pagamento.");
            return false;
        }
        else
        {
            System.out.println("Efetuar o pagamento da reserva?");
            System.out.println(" 1 - Sim");
            System.out.println(" 2 - Não");
            switch(scanner.nextInt())
            {
            case 1:
                reserva.setPago(true);
                return true;
            default:
                reserva.setPago(false);
                return false;
            }
            
        }
        
    }
    public Object addHospedesReserva(ReservaVO reserva)
    {
        System.out.println("Diga o CPF do hospede desejado:");
        String cpf = this.scanner.next();
        ClienteVO cliente = (ClienteVO) this.controller.execute(OperationEnum.GETCLIENTEPERCPFORCNPJ, cpf);
        if(cliente == null)
        {
            System.out.println("Cliente não encontrado, deseja cadastra-lo?");
            System.out.println(" 1 - Sim");
            System.out.println(" 2 - Não");
            switch(this.scanner.nextInt())
            {
                case 1:
                    if(this.addCliente())
                        System.out.println("Cliente cadastrado no sistema e a reserva.");
                        while((ClienteVO) this.controller.execute(OperationEnum.GETCLIENTEPERCPFORCNPJ, cpf) == null)
                        {
                            System.out.println("Parece que você cadastrou um Cliente com o CPF diferente ao digitado, favor inserir o CPF novamente ou 0 para encerrar");
                            cpf = scanner.next();
                            if(cpf.equals("0"))
                                return false;
                        }
                        if(reserva != null)
                        {
                            reserva.getHospedes().add((ClienteVO) this.controller.execute(OperationEnum.GETCLIENTEPERCPFORCNPJ, cpf));
                            this.controller.execute(OperationEnum.UPDATERESERVA, reserva);
                        }
                        else
                            return (ClienteVO) this.controller.execute(OperationEnum.GETCLIENTEPERCPFORCNPJ, cpf);
                        
                       
                            
                        return true;
                default:
                    return false;
                    
            }
        }
           
        
        return false;
    }
    public boolean addReserva() throws ParseException{
        ReservaVO reserva = new ReservaVO();
        System.out.println("Digite a data de inicio da reserva, da seguinte forma dia/mes/ano:");
        String entrada = scanner.next();
        while(!entrada.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))
        {
            System.out.println("A data foi digitada da forma incorreta, tente novamente - ou 0 para sair:");
            entrada = scanner.next();
            if(entrada.equals("0"))
                return false;
        }
        System.out.println("Digite a data de fim da reserva, da seguinte forma dia/mes/ano:");
        SimpleDateFormat formator = new SimpleDateFormat("dd/MM/yyyy");
        Date data_inicio = formator.parse(entrada);
        reserva.setDataInicio(data_inicio);
        while(!entrada.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))
        {
            System.out.println("A data foi digitada da forma incorreta, tente novamente - ou 0 para sair:");
            entrada = scanner.next();
            if(entrada.equals("0"))
                return false;
        }
        SimpleDateFormat formatorfim = new SimpleDateFormat("dd/MM/yyyy");
        Date data_fim = formatorfim.parse(entrada);
        reserva.setDataFim(data_fim);
        
        this.efetuarPagamentoReserva(reserva);
        ArrayList<ClienteVO> clientes = new ArrayList<>();
        clientes.add((ClienteVO) this.addHospedesReserva(null));
        while(true)
        {
            System.out.println("Deseja cadastrar outro cliente?");
            System.out.println(" 1 - Sim");
            System.out.println(" 2 - Não");
            entrada = scanner.next();
            if(entrada.equals("1"))
                clientes.add((ClienteVO) this.addHospedesReserva(reserva));
            else
                break;
        }
        reserva.setHospedes(clientes);
         
        reserva.setResponsavelReserva(logado);
        System.out.println("Digite o CPF ou CNPJ do cliente pagante:");
        entrada = this.scanner.next();
        
        ClienteVO clientePagante = (ClienteVO) this.controller.execute(OperationEnum.GETCLIENTEPERCPFORCNPJ, entrada);
        while(clientePagante == null)
        {
            System.out.println("Cliente não encontrado, ou ainda não cadastrado, deseja cadastra-lo?");
            System.out.println(" 1 - Sim");
            System.out.println(" 2 - Não");
            entrada = scanner.next();
            if(entrada.equals("0"))
                break;
            this.addCliente();
            clientePagante = (ClienteVO) this.controller.execute(OperationEnum.GETCLIENTEPERCPFORCNPJ, entrada);
            reserva.setPaganteVO(clientePagante);
        }
        reserva.setCheckOut(false); //n faz sentido fazer uma reserva q já foi feito check out
        reserva.setAtivo(true);
        this.controller.execute(OperationEnum.ADDRESERVA, reserva);
       
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
    public boolean login()
    {
        System.out.println("Digite o CPF do Funcionario:");
        String cpf = this.scanner.next();
        System.out.println("Digite sua senha:");
        String senha = this.scanner.next();
        FuncionarioVO funcionario = new FuncionarioVO();
        funcionario.setCpf(cpf);
        funcionario.setSenha(senha);
        FuncionarioVO l = (FuncionarioVO) this.controller.execute(OperationEnum.LOGINFUNCIONARIO, funcionario);
        while(l == null)
        {
            System.out.println("Senha ou CPF incorreto, tente novamente ou 0 para sair");
            cpf = this.scanner.next();
            if(cpf.equals("0"))
                return false;
            senha = this.scanner.next();
            if(senha.equals("0"))
               return false;
            funcionario.setCpf(cpf);
            funcionario.setSenha(senha);
            l = (FuncionarioVO) this.controller.execute(OperationEnum.LOGINFUNCIONARIO, funcionario);
        }
        this.logado = l;
        if((boolean) this.controller.execute(OperationEnum.EHGERENTE, this.logado.getId()));
            this.logadoEhGerente = true;
        return true;
       
    }
    public boolean menu()
    {
      
        if(!this.login())
            return false;
     
            
        while(true)
        {
            System.out.println("---------HOTELARIA--------");
            System.out.println("1 - Adicionar cliente     ");
            System.out.println("2 - Consultar cliente     ");
            //System.out.println("3 - Adicionar estrutura   ");
            System.out.println("3 - Adicionar reserva     ");
            System.out.println("0 - Encerrar              ");
            System.out.println("--------------------------");
            switch(this.scanner.nextInt())
            {
                case 1:
                    if(this.addCliente())
                        System.out.println("Cliente cadastrado com sucesso.");
                    else
                        System.err.println("Ocorreu um erro no cadastro de cliente.");
                    break;
                case 2:
                    this.consultaClientes();
                    break;
      
                case 3:
                    try{
                        if(this.addReserva())
                            System.out.println("Reserva cadastrada com sucesso!");
                        else
                            System.out.println("ERRO -> Ocorreu um erro no cadastro da reserva.");
                        
                    }
                    catch(ParseException e)
                    {
                        System.out.println("ERRO -> Um erro na formatação da Data ocorreu.");
                    }
                    break;
                        
                case 4:
                    break;
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
