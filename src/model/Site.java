package model;

public class Site {

    private int idSite;//PK
    private String url;
    private String nome;
    private int idPessoa;//FK banco de dados

    public Site() {
    }

    public Site(int idSite, String url, String nome, int idPessoa) {
        this.idSite = idSite;
        this.url = url;
        this.nome = nome;
        this.idPessoa = idPessoa;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Site{" +
                "idSite=" + idSite +
                ", url='" + url + '\'' +
                ", nome='" + nome + '\'' +
                ", idPessoa=" + idPessoa +
                '}';
    }
}
