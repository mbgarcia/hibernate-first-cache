package br.com.garcia.cache.usage;

import org.hibernate.Session;

import br.com.garcia.cache.HibernateUtil;
import br.com.garcia.cache.model.Person;

public class TwoCallsSameSessionExample {

    public static void main(String[] args) {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
        
        sessionOne.beginTransaction();
        sessionTwo.beginTransaction();
        
        System.out.println((Person) sessionOne.load(Person.class, 1));
        System.out.println((Person) sessionOne.load(Person.class, 1));
        
        System.out.println((Person) sessionTwo.load(Person.class, 1));
        
        
        sessionOne.getTransaction().commit();
        HibernateUtil.shutdown();
        sessionTwo.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
