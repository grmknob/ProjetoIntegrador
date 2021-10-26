package controller;

import java.util.ArrayList;
import model.Pessoa;

    public class CPessoa implements InterfaceController<Pessoa> {

        ArrayList<Pessoa> pessoas = new ArrayList<>();//Repositório de Pessoas
        int idPessoa = 1;

        @Override
        public ArrayList<Pessoa> getAll() {
            return pessoas;
        }

        @Override
        public int gerarId() {
            return this.idPessoa++;
        }

        @Override
        public void add(Pessoa p) {
            this.pessoas.add(p);
        }


        public void mokPessoas() {
            Pessoa p1 = new Pessoa();
            p1.setIdPessoa(this.gerarId());
            p1.setNomePessoa("Romario");
            p1.setCpf("12312312312");
            p1.setEndereco("Rua Mario Camelo");
            p1.setTelefone("51998998998");
            p1.setIdade(45);
            p1.setStatus(true);
            this.add(p1);

            Pessoa p2 = new Pessoa();
            p2.setIdPessoa(this.gerarId());
            p2.setNomePessoa("Jorge");
            p2.setCpf("32132132132");
            p2.setEndereco("Av. dos Elefantes");
            p2.setIdade(29);
            p2.setTelefone("51988988988");
            p2.setStatus(false);
            this.add(p2);
        }

        public boolean verCPF(String cpf) {
            boolean verCPF = false;
            for (Pessoa listPes : pessoas) {
                if (listPes.getCpf().equals(cpf)) {
                    verCPF = true;
                    break;
                }
            }
            return verCPF;
        }

        public boolean verStatusPes(String cpf) {
            boolean verStatus = false;
            for (Pessoa listPes : pessoas) {
                if (listPes.getCpf().equals(cpf)) {
                    verStatus = listPes.isStatus();
                    break;
                }
            }
            return verStatus;
        }

        @Override
        public Pessoa getByDoc(String cpf) {
            Pessoa p = new Pessoa();
            for (Pessoa listPes : pessoas) {
                if (listPes.getCpf().equals(cpf)) {
                    p = listPes;
                    break;
                }
            }
            return p;
        }

        public void alteraStatus(String cpf, int status) {
            for (Pessoa listPes : pessoas) {
                if (listPes.getCpf().equals(cpf)) {
                    listPes.setStatus(status == 1);
                    break;
                }
            }
        }

        @Override
        public boolean deletar(Pessoa p) {
            boolean remove = this.pessoas.remove(p);
            return remove;
        }

        public int pesqIdPes(String cpf) {
            int idPessoa = 0;
            for (Pessoa listPes : pessoas) {
                if (listPes.getCpf().equals(cpf)) {
                    idPessoa = listPes.getIdPessoa();
                    break;
                }
            }
            return idPessoa;
        }

        public String getNomePes(int idPessoa){
            String nome = null;
            for(Pessoa listPes: pessoas){
                if (listPes.getIdPessoa()==idPessoa) {
                    nome = listPes.getNomePessoa();
                    break;
                }
            }
            return nome;
        }

    }

