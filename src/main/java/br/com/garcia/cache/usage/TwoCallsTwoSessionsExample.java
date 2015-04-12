package br.com.garcia.cache.usage;

import org.hibernate.Session;

import br.com.garcia.cache.HibernateUtil;
import br.com.garcia.cache.model.Person;

public class TwoCallsTwoSessionsExample {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        Person person = (Person) session.load(Person.class, 1);
        
        System.out.println(person);
        
        person = (Person) session.load(Person.class, 1);
        
        System.out.println(person);
        
        session.getTransaction().commit();
        
        HibernateUtil.shutdown();
    }
}
