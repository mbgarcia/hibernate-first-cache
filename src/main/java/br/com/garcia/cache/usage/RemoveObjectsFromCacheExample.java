package br.com.garcia.cache.usage;

import org.hibernate.Session;

import br.com.garcia.cache.HibernateUtil;
import br.com.garcia.cache.model.Person;

public class RemoveObjectsFromCacheExample {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        System.out.println((Person) session.load(Person.class, 1));
        System.out.println((Person) session.load(Person.class, 1));

        session.evict((Person) session.load(Person.class, 1));
        
        System.out.println((Person) session.load(Person.class, 1));
        
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
