package dao.impl;

import dao.FiliereDao;
import entities.Filiere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiliereDaoIpmlTest {

    private FiliereDao filiereDao;
    @BeforeEach
    void setUp() {
        filiereDao = new FiliereDaoIpml();
    }

    @Test
    void getByCode() {
        Filiere f = new Filiere();
        f.setCode("zzz");
        f.setLibelle("zzz");
        filiereDao.saveOrUpdate(f);

        Filiere f2 = filiereDao.getByCode(f.getCode());

        assertEquals(f.getCode() , f2.getCode());
    }

    @Test
    void saveOrUpdate() {

        Filiere filiere = new Filiere();
        filiere.setCode("SMI");
        filiere.setLibelle("Science Math");
        boolean save = filiereDao.saveOrUpdate(filiere);

        assertTrue(save);
    }

    @Test
    void delete() {
        Filiere f = filiereDao.getById(38);
        assertTrue(filiereDao.delete(f));
    }

    @Test
    void getById() {
        Filiere f = filiereDao.getById(14);
        assertEquals("SMI" , f.getCode());
    }

    @Test
    void getAll() {

        List<Filiere> filieres = filiereDao.getAll();

        for (Filiere f : filieres){
            System.out.println(f.toString());
        }
    }
}