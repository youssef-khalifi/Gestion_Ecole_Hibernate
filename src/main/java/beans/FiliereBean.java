package beans;

import entities.Filiere;
import service.FiliereService;
import service.impl.FiliereServiceImpl;

import java.util.List;

public class FiliereBean {

    private Filiere filiere;
    private FiliereService filiereService;
    private boolean isModify;

    public FiliereBean() {
        this.filiere = new Filiere();
        this.filiereService = new FiliereServiceImpl();
        this.isModify = false;
    }

    public boolean isModify() {
        return isModify;
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    public List<Filiere> getFiliers(){
        return this.filiereService.getFiliereTrie();
    }

    public String getLabel(){

        if (!isModify) {
            return  "Enregistrer";
        } else {
            return "Modifier";
        }
    }
    @Override
    public String toString() {
        return "FiliereBean{" +
                "filiere=" + filiere +
                '}';
    }
}
