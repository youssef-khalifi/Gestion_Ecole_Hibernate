package dao.impl;

import dao.EtudiantDao;
import dao.Hsession;
import entities.Etudiant;
import entities.Filiere;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EtudiantDaoImpl implements EtudiantDao {
    private SessionFactory sessionFactory = Hsession.getSessionFactory();
    @Override
    public boolean saveOrUpdate(Etudiant etudiant) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(etudiant);
            transaction.commit();
            System.out.println("ajouter etudiant ok");
            return true;
        }catch (Exception e){
            System.out.println("ajouter etudiant error"+e.getMessage());
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Etudiant etudiant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(etudiant);
            transaction.commit();
            System.out.println("delete etudiant ok");
            return true;
        }catch (Exception e){
            System.out.println("delete etudiant Error"+e.getMessage());
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public Etudiant getById(Integer id) {
        Session session = sessionFactory.openSession();
        Etudiant etudiant = session.get(Etudiant.class , id);
        session.close();
        System.out.println("get etudiant by id ");
        return etudiant;
    }
    @Override
    public List<Etudiant> getAll() {
        List<Etudiant> etudiants = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            etudiants = session.createQuery("from Etudiant " , Etudiant.class).list();
            transaction.commit();
            System.out.println("get All etudiants ok");
        }catch (Exception e){
            System.out.println("get All etudiants Error"+e.getMessage());
            transaction.rollback();
        }finally {
            session.close();
        }
        return etudiants;
    }
}
