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
        assertNotNull(filiere.getId());
    }

    @Test
    void delete() {
        Filiere filiere = new Filiere();
        filiere.setCode("Test");
        filiere.setLibelle("Test");
        boolean delete = filiereDao.saveOrUpdate(filiere);
        assertTrue(delete);
    }
    @Test
    void getById() {
        Filiere f = new Filiere();
        f.setCode("Test2");
        f.setLibelle("Test2");
        filiereDao.saveOrUpdate(f);
        Filiere filiere = filiereDao.getById(f.getId());
        assertEquals(f.getId() , filiere.getId());
    }
    @Test
    void getAll() {
        List<Filiere> filieres = filiereDao.getAll();
        assertNotNull(filieres);
    }
}