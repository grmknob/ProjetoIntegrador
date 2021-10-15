package model;

public class Comentario {
    private int idComent;
    private String Coment;
    private Site s;

    public Comentario() {
    }

    public Comentario(int idComent, String coment, Site s) {
        this.idComent = idComent;
        Coment = coment;
        this.s = s;
    }

    public int getIdComent() {
        return idComent;
    }

    public void setIdComent(int idComent) {
        this.idComent = idComent;
    }

    public String getComent() {
        return Coment;
    }

    public void setComent(String coment) {
        Coment = coment;
    }

    public Site getS() {
        return s;
    }

    public void setS(Site s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "idComent=" + idComent +
                ", Coment='" + Coment + '\'' +
                ", s=" + s +
                '}';
    }
}
