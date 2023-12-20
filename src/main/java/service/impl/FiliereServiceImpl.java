package service.impl;

import dao.FiliereDao;
import dao.impl.FiliereDaoIpml;
import entities.Filiere;
import service.FiliereService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FiliereServiceImpl implements FiliereService {

    private FiliereDao dao = new FiliereDaoIpml();
    @Override
    public List<Filiere> getFiliereTrie() {
        List<Filiere> filieres = dao.getAll();

        Collections.sort(filieres, new Comparator<Filiere>() {
            @Override
            public int compare(Filiere o1, Filiere o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        return filieres;
    }
}
