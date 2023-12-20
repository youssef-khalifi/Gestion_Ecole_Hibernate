package dao.impl;

import dao.FiliereDao;
import dao.Hsession;
import entities.Filiere;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FiliereDaoIpml implements FiliereDao {
    private SessionFactory sessionFactory = Hsession.getSessionFactory();

    @Override
    public boolean saveOrUpdate(Filiere filiere) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(filiere);
            transaction.commit();
            System.out.println("ajouter filiere ok");
            return true;
        }catch (Exception e){
            System.out.println("ajouter filiere error"+e.getMessage());
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Filiere filiere) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(filiere);
            transaction.commit();
            System.out.println("delete filiere ok");
            return true;
        }catch (Exception e){
            System.out.println("delete filiere Error"+e.getMessage());
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public Filiere getById(Integer id) {
        Session session = sessionFactory.openSession();

        Filiere filiere = session.get(Filiere.class , id);
        session.close();
        System.out.println("get filiere by id ");
        return filiere;
    }

    @Override
    public List<Filiere> getAll() {
        List<Filiere> filieres = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            filieres = session.createQuery("from Filiere " , Filiere.class).list();
            transaction.commit();
            System.out.println("get All filieres ok");
        }catch (Exception e){
            System.out.println("get All filieres Error"+e.getMessage());
            transaction.rollback();
        }finally {
            session.close();
        }
        return filieres;
    }

    @Override
    public Filiere getByCode(String code) {

        Filiere filiere = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<Filiere> query = session.createQuery("FROM Filiere WHERE code = :code", Filiere.class);
            query.setParameter("code", code);
            filiere = query.uniqueResult();
            transaction.commit();
            System.out.println("Get Filiere By Code OK");
        } catch (Exception e) {
            System.out.println("Get Filiere By Code Error: " + e.getMessage());
            transaction.rollback();
        }finally {
            session.close();
        }
        return filiere;
    }
}
