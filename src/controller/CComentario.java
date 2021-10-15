package controller;

import model.Comentario;
import main.MProjeto;
import java.util.ArrayList;

public class CComentario implements InterfaceController<Comentario> {
    ArrayList<Comentario> comentarios = new ArrayList<>();
    int idComent = 1;

    @Override
    public int gerarId(){
        return idComent++;
    }

    @Override
    public void add(Comentario o){
        this.comentarios.add(o);
    }

    @Override
    public ArrayList<Comentario> getAll(){
        return comentarios;
    }

    @Override
    public boolean deletar(Comentario o){
        boolean del = comentarios.remove(o);
        return del;
    }

    @Override
    public Comentario getByDoc(String d){
        return null;
    }

    public void mokComentarios(){
        Comentario c1 = new Comentario();
        c1.setIdComent(gerarId());
        c1.setComent("G1!");
        c1.setS(MProjeto.cadSites.getByDoc("G1"));
        comentarios.add(c1);

        Comentario c2 = new Comentario();
        c2.setIdComent(gerarId());
        c2.setComent("ZH!");
        c2.setS(MProjeto.cadSites.getByDoc("ZH"));
        comentarios.add(c2);
    }

}
