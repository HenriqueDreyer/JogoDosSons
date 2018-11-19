package services;

import dao.HibernateUtil;
import model.Animal;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AnimalService {

    private AnimalService(){}
    
    // TODO: Verificar onde é usada e se pode ser excluida
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
    
    // TODO: Renomear classe
    public static List<Animal> radom(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Animal.class);
        //criteria.add(Restrictions.eq('fieldVariable', anyValue));
        criteria.add(Restrictions.sqlRestriction("1=1 order by random()"));
        criteria.setMaxResults(4);

        return criteria.list();
    }
}
