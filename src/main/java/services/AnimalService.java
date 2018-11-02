package services;

import dao.HibernateUtil;
import model.Animal;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class AnimalService {

    private AnimalService(){}

    public static List<Animal> listar(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Animal ");

        //session.close();
        return query.list();
    }

    public static void add(Animal animal) {
        Session session = HibernateUtil.getSession();
        session.save(animal);
    }
}
