package main;

import controller.CComentario;
import controller.CPessoa;
import controller.CSite;

import model.Comentario;
import model.Pessoa;
import model.Site;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;


public class MProjeto {

    public static Scanner ler = new Scanner(System.in);
    public static CPessoa cadPessoas = new CPessoa();
    public static CSite cadSites = new CSite();
    public static CComentario cadComent = new CComentario();

    public static String leTexto(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public static void menu(){
        System.out.println("\n__ Menu Principal __");
        System.out.println("1 - Ver Pessoa...");
        System.out.println("2 - Ver Site...");
        System.out.println("0 - Sair...");
        System.out.println("Selecione alguma opção: ");
    }

    public static void menuP(){
        System.out.println("\n__ Cadastro Pessoa __");
        System.out.println("1 - Cadastrar Pessoa");
        System.out.println("2 - Alterar Status Pessoa");
        System.out.println("3 - Atualizar Pessoa");
        System.out.println("4 - Deletar Pessoa");
        System.out.println("5 - Imprimir Pessoas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha um opção: ");
    }

    public static void menuC() {
        System.out.println("\n__ Cadastro de Site __");
        System.out.println("1 - Cadastrar Site");
        System.out.println("2 - Atualizar URL");
        System.out.println("3 - Deletar Site");
        System.out.println("4 - Imprimir Sites");
        System.out.println("0 - Voltar");
        System.out.print("Escolha um opção: ");
    }

    public static void cadPessoa() {
        boolean system;

        do {
            System.out.println("-- Cadastro de Pessoa --");
            System.out.println("");
            int id;
            String nomePessoa;
            String cpf;
            String endereco;
            String telefone;
            int idade;
            boolean status;
            System.out.print("Informe o nome da Pessoa: ");
            nomePessoa = leTexto();
            boolean testaCPF = false;
            do {
                System.out.print("Informe o CPF: ");
                cpf = leTexto();
                if (cpf.length() != 11) {
                    testaCPF = true;
                    System.out.println("CPF incorreto, tente novamente!");
                } else {
                    testaCPF = cadPessoas.verCPF(cpf);
                }
            } while (testaCPF);
            System.out.print("Informe o endereço: ");
            endereco = leTexto();
            boolean testaTel;
            do {
                testaTel = false;
                System.out.print("Informe o telefone com DDD: ");
                telefone = leTexto();
                if (telefone.length() != 10 && telefone.length() != 11) {
                    testaTel = true;
                    System.out.println("Telefone informado esta incorreto");
                }
            } while (testaTel);
            System.out.print("Informe a idade: ");
            idade = ler.nextInt();
            System.out.print("Pessoa esta ativa no cadastro? 1-Sim / 2-Não: ");
            byte statusN = ler.nextByte();
            status = statusN == 1;
            id = cadPessoas.gerarId();
            Pessoa p = new Pessoa(id, nomePessoa, cpf, endereco, telefone, idade, status);
            cadPessoas.add(p);

            System.out.print("Deseja continuar cadastrando? S/N: ");
            char continuar = ler.next().charAt(0);
            system = (continuar == 's' || continuar == 'S');
        } while (system);
    }

    public static void alteraStatus() {
        System.out.println("-- Altera Status --");
        System.out.println("");
        System.out.print("Informe o CPF: ");
        String cpf = leTexto();
        if (cadPessoas.verCPF(cpf)) {
            int status;
            if (cadPessoas.verStatusPes(cpf)) {
                System.out.println("Status ativo, quer inativar esta Pessoa: 0-Sim | 1-Não");
                status = ler.nextInt();
                System.out.println("Concluído!");
            } else {
                System.out.println("Status inativo, quer ativar esta Pessao: 1-Sim | 0-Não");
                status = ler.nextInt();
                System.out.println("Concluído!");
            }
            cadPessoas.alteraStatus(cpf, status);
        } else {
            System.out.println("CPF não existe!");
            System.out.println("Deseja cadastrar este CPF? 1-Sim | 0-Não");
            int c = ler.nextInt();
            if (c == 1) {
                cadPessoa();
            }
        }
    }

    public static void atualizaPessoa() {
        System.out.println("-- Atualiza Pessoa --");
        System.out.println("");
        System.out.print("Informe o CPF: ");
        String cpf = leTexto();
        if (cadPessoas.verCPF(cpf)) {
            Pessoa p = new Pessoa();
            p = cadPessoas.getByDoc(cpf);
            System.out.println("Atualizando Pessoa: " + p.getNomePessoa());
            boolean atualiza = false;
            do {
                System.out.println("1 - Atualizar tudo");
                System.out.println("2 - Atualizar nome");
                System.out.println("3 - Atualizar endereço");
                System.out.println("4 - Atualizar telefone");
                System.out.println("5 - Atualizar idade");
                System.out.println("Escolha um opção:");
                int op = ler.nextInt();
                switch (op) {
                    case 1:
                        System.out.print("Informe o nome: ");
                        p.setNomePessoa(leTexto());
                        System.out.print("\nInforme o endereço: ");
                        p.setEndereco(leTexto());
                        System.out.print("\nInforme o telefone: ");
                        p.setTelefone(leTexto());
                        System.out.print("\nInforme a idade: ");
                        p.setIdade(ler.nextInt());
                        atualiza = false;
                        break;
                    case 2:
                        System.out.print("Informe o nome: ");
                        p.setNomePessoa(leTexto());
                        atualiza = false;
                        break;
                    case 3:
                        System.out.print("\nInforme o endereço: ");
                        p.setEndereco(leTexto());
                        atualiza = false;
                        break;
                    case 4:
                        System.out.print("\nInforme o telefone: ");
                        p.setTelefone(leTexto());
                        atualiza = false;
                        break;
                    case 5:
                        System.out.print("\nInforme a idade: ");
                        p.setIdade(ler.nextInt());
                        atualiza = false;
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                        atualiza = true;
                }
            } while (atualiza);
            System.out.println("Atualização concluída com sucesso!");
        } else {
            System.out.println("CPF não existe!");
            System.out.println("Deseja cadastrar este CPF? 1-Sim | 0-Não");
            int c = ler.nextInt();
            if (c == 1) {
                cadPessoa();
            }
        }
    }

    public static void imprimePessoas() {
        if (!cadPessoas.getAll().isEmpty()) {
            for (Pessoa listPes : cadPessoas.getAll()) {
                System.out.println("---");
                System.out.println("Id: " + listPes.getIdPessoa());
                System.out.println("Nome: " + listPes.getNomePessoa());
                System.out.println("CPF: " + listPes.getCpf());
                System.out.print("Status: ");
                if (listPes.isStatus()) {
                    System.out.println("Ativo");
                } else {
                    System.out.println("Inativo");
                }
            }
        } else {
            System.out.println("Não existem pessoas cadastradas!");
        }
    }

    public static void deletarPessoa() {
        System.out.println("-- Deletar Pessoa --");
        System.out.println("");
        boolean delP;
        do {
            delP = false;
            System.out.print("Informe o CPF: ");
            String cpf = leTexto();
            if (cadPessoas.verCPF(cpf)) {
                Pessoa p;
                p = cadPessoas.getByDoc(cpf);
                System.out.println("Deseja realmente deletar esta pessoa? "
                        + p.getNomePessoa() + " 1-Sim | 0-Não");
                int i = ler.nextInt();
                if (i == 1) {
                    if (cadPessoas.deletar(p)) {
                        System.out.println("Pessoa deletada com sucesso!");
                    } else {
                        System.out.println("Ocorreu um erro ao deletar!");
                    }
                } else {
                    System.out.println("Ok, entendemos sua decisão!");
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.print("Deseja tentar novamente? 1-Sim | 0-Não");
                int i = ler.nextInt();
                delP = i == 1;
            }
        } while (delP);
    }

    public static void cadSite(){
        boolean continuarSit;
        do {
            System.out.println("-- Cadastro de Site --");
            Site s = new Site();
            boolean verNome = false;
            String nome;
            do {
                System.out.println("Informe o nome do Site: ");
                nome = leTexto();
                verNome = cadSites.verNome(nome);
                if (verNome) {
                    System.out.println("Informação inválida!");
                }
            } while (verNome);
            s.setNome(nome);
            System.out.println("Informe a url do site: ");
            s.setUrl(leTexto());
            boolean cpfExiste = false;
            do {
                System.out.print("Informe CPF do usuario: ");
                String cpf = leTexto();
                cpfExiste = cadPessoas.verCPF(cpf);
                if (cpfExiste) {
                    s.setIdPessoa(cadPessoas.pesqIdPes(cpf));
                } else {
                    System.out.println("CPF inválido, tente novamente!");
                }
            } while (!cpfExiste);
            cadSites.add(s);
            System.out.println("Cadastrado com sucesso!"
                    + "\nSite sob o nome: " + s.getNome()
                    + " e atribuido ao usuario(a) "
                    + cadPessoas.getNomePes(s.getIdPessoa()));

            System.out.println("Deseja cadastrar outro site? 1-Sim | 0-Não");
            int sSite = ler.nextInt();
            continuarSit = sSite == 1;
            } while (continuarSit);

        }

        public static void imprimirSites(){
            System.out.println("-- Lista de Sites --");
            for(Site listSite : cadSites.getAll()){
                System.out.println("---");
                System.out.println("Nome: " + listSite.getNome());
                System.out.println("Url: " + listSite.getUrl());
                System.out.println("Usuario: "
                        + cadPessoas.getNomePes(listSite.getIdPessoa()));
            }
        }

        public static void deletarSite(){
            System.out.println("-- Remover Site --");
            System.out.println("Informe o nome do site: ");
            String nomeUrl = leTexto();
            if(cadSites.verNome(nomeUrl)){
                Site site = cadSites.getByDoc(nomeUrl);
                System.out.println("Deseja realmente excluir este site? "
                        + "\nUrl: " + site.getUrl()
                        + "\nNome: " + site.getNome()
                        + "\n1 (sim) / 2 (não)");
                int op = ler.nextInt();
                if (op == 1) {
                    cadSites.deletar(site);
                    System.out.println("Site removido com sucesso!");
                } else {
                    System.out.println("Operação cancelada...");
                }
            } else {
                System.out.println("Nome ou url não cadastrados(as)!");
            }
        }

        public static void alterarSite(){
            System.out.println("-- Atualizar URL --");
            System.out.println("Informe o nome do Site: ");
            String nome = leTexto();
            if(cadSites.verNome(nome)){
                Site site = cadSites.getByDoc(nome);
                System.out.println("Deseja atualizar a URL deste site? "
                        + "\nUrl: " + site.getUrl()
                        + "\nNome: " + site.getNome()
                        + "\n1 (sim) / 2 (não)");
                int opA = ler.nextInt();
                if(opA == 1){
                    boolean up;
                    do{
                        System.out.println("Atualizaões: "
                                + "\n1 - Url"
                                + "\n0 - Sair"
                                + "\nDigite uma opção: ");
                        int op = ler.nextInt();
                        switch (op){
                            case 1:
                                System.out.println("Inorme a Url: ");
                                site.setUrl(leTexto());
                                up = false;
                                break;
                            case 2:
                                boolean cpfPes;
                                do{
                                    System.out.println("Informe o CPF do usuario: ");
                                    String cpf = leTexto();
                                    cpfPes = cadPessoas.verCPF(cpf);
                                    if(cpfPes){
                                        site.setIdPessoa(cadPessoas.pesqIdPes(cpf));
                                    } else {
                                        System.out.println("CPF inválido!");
                                    }
                                } while (!cpfPes);
                                up = false;
                                break;
                            case 0:
                                up = false;
                                break;
                            default:
                                up = true;
                                System.out.println("Opção inválida!");
                                break;
                            }
                        }while (up);
                    System.out.println("Atualização ");
                    } else {
                    System.out.println("Atualização cancelada!");
                }
            } else {
                System.out.println("Url incorreta ou Site não cadastrado!");
            }
        }

        public static void main(String[] args){

            cadPessoas.mokPessoas();
            cadSites.mokSite();
            cadComent.mokComentarios();
            System.out.println(cadComent.getAll().toString());
            int opM;
            String s = "s";

            do{
                menu();
                int m = ler.nextInt();
                switch (m){
                    case 1:
                        menuP();
                        opM = ler.nextInt();
                        switch (opM){
                            case 1:
                                cadPessoa();
                                break;
                            case 2:
                                alteraStatus();
                                break;
                            case 3:
                                atualizaPessoa();
                                break;
                            case 4:
                                deletarPessoa();
                                break;
                            case 5:
                                imprimePessoas();
                                break;
                            case 0:
                                //voltar
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        break;
                    case 2:
                        menuC();
                        opM = ler.nextInt();
                        switch (opM){
                            case 1:
                                cadSite();
                                break;
                            case 2:
                                alterarSite();
                                break;
                            case 3:
                                deletarSite();
                                break;
                            case 4:
                                imprimirSites();
                                break;
                            case 0:
                                //voltar
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        break;
                    case 0:
                        s = "n";
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (s.equalsIgnoreCase("s"));
            System.out.println("Aplicação encerrada!");
        }
    }
