package br.com.garcia.cache.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person implements Serializable{
    private static final long serialVersionUID = -7527047348693267334L;

    @Id
    private Integer id;
    
    @Column
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
}