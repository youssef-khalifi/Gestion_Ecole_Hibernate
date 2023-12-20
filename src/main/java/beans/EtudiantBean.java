package beans;

import entities.Etudiant;
import entities.Filiere;
import service.EtudiantService;
import service.FiliereService;
import service.impl.EtudiantServiceImpl;
import service.impl.FiliereServiceImpl;

import java.util.List;

public class EtudiantBean {

    private Etudiant etudiant;
    private EtudiantService etudiantService;
    private FiliereService filiereService;
    private boolean isModify;

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public EtudiantBean() {
        this.etudiant = new Etudiant();
        this.filiereService = new FiliereServiceImpl();
        this.etudiantService = new EtudiantServiceImpl();
        this.isModify = false;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public boolean isModify() {
        return isModify;
    }
    public List<Etudiant> getEtudiants(){
        return this.etudiantService.getEtudiantsTrie();
    }
    public List<Filiere> getFilieres(){
        return this.filiereService.getFiliereTrie();
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }
    public String getLabel(){
        if (!isModify) {
            return  "Enregistrer";
        } else {
            return "Modifier";
        }
    }
}
