package controller;

import model.Site;

import java.util.ArrayList;

public class CSite implements InterfaceController<Site>{
    ArrayList<Site> sites = new ArrayList<>();
    int idSite = 1;

    @Override
    public int gerarId(){
        return this.idSite++;
    }

    @Override
    public ArrayList<Site> getAll(){
        return this.sites;
    }

    @Override
    public void add(Site s){
        this.sites.add(s);
    }

    @Override
    public boolean deletar (Site s){
        boolean rs = this.sites.remove(s);
        return rs;
    }

    public void mokSite(){
        Site s1 = new Site();
        s1.setIdSite(this.gerarId());
        s1.setNome("G1");
        s1.setUrl("https://g1.globo.com/saude/coronavirus/");
        s1.setIdPessoa(1);
        this.add(s1);

        Site s2 = new Site();
        s2.setIdSite(this.gerarId());
        s2.setNome("ZH");
        s2.setUrl("https://gauchazh.clicrbs.com.br/ultimas-noticias/tag/coronavirus/");
        s2.setIdPessoa(2);
        this.add(s2);
    }

    public boolean verNome(String nome){
        boolean verNome = false;
        for(Site listSite: sites){
            if(listSite.getNome().equalsIgnoreCase(nome)){
                verNome = true;
                break;
            }
        }
        return verNome;
    }

    @Override   public Site getByDoc(String nome){
        Site sit = null;
        for(Site listSite: sites){
            if(listSite.getNome().equalsIgnoreCase(nome)){
                sit = listSite;
                break;
            }
        }
        return sit;
    }
}
