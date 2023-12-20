package service.impl;

import dao.EtudiantDao;
import dao.FiliereDao;
import dao.impl.EtudiantDaoImpl;
import dao.impl.FiliereDaoIpml;
import entities.Etudiant;
import service.EtudiantService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {

    private EtudiantDao dao = new EtudiantDaoImpl();
    @Override
    public List<Etudiant> getEtudiantsTrie() {
        List<Etudiant> etudiants = dao.getAll();

        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        return etudiants;
    }
}
