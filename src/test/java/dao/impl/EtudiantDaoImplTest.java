package dao.impl;

import dao.EtudiantDao;
import dao.FiliereDao;
import entities.Etudiant;
import entities.Filiere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantDaoImplTest {
    private EtudiantDao etudiantDao;
    private FiliereDao filiereDao;
    @BeforeEach
    void setUp() {
        etudiantDao = new EtudiantDaoImpl();
        filiereDao = new FiliereDaoIpml();
    }
    @Test
    void saveOrUpdate() {
        Etudiant e = new Etudiant();
        e.setNom("e2");
        e.setPrenom("e2");
        e.setCne("e");
      //  Filiere f= filiereDao.getByCode("SMI");
     //   e.setFiliere(f);
        boolean save = etudiantDao.saveOrUpdate(e);
        assertTrue(save);
       assertNotNull(e.getId());
    }

    @Test
    void delete() {
        Etudiant e = new Etudiant();
        e.setNom("youssef");
        e.setPrenom("khalifi");
        e.setCne("P123456789");
        etudiantDao.saveOrUpdate(e);
        boolean del = etudiantDao.delete(e);
        assertTrue(del);
    }
    @Test
    void getById() {
        Etudiant e = new Etudiant();
        e.setNom("youssef");
        e.setPrenom("khalifi");
        e.setCne("P123456789");
        etudiantDao.saveOrUpdate(e);
       Etudiant e2 =  etudiantDao.getById(e.getId());
        assertEquals(e.getId() , e2.getId());
    }
    @Test
    void getAll() {
        List<Etudiant> etudiants = etudiantDao.getAll();
        assertNotNull(etudiants);
    }
}