package com.mycompany.app.dao;

import com.mycompany.app.modal.Person;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 12/4/14
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersonDAO {
    public void create(Person p);
    public Person readById(String id);
    public void update(Person p);
    public int deleteById(String id);
    public List<Person> findByGender(String gender);
}
