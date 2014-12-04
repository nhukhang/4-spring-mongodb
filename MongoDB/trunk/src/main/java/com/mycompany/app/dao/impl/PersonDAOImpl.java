package com.mycompany.app.dao.impl;

import com.mongodb.WriteResult;
import com.mycompany.app.dao.PersonDAO;
import com.mycompany.app.modal.Person;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 12/4/14
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonDAOImpl implements PersonDAO{

    private MongoOperations mongoOps;
    private static final String PERSON_COLLECTION = "nettuts";  /* like a table */

    public PersonDAOImpl(MongoOperations mongoOps){
        this.mongoOps=mongoOps;
    }

    @Override
    public void create(Person p) {
        this.mongoOps.insert(p, PERSON_COLLECTION);
    }

    @Override
    public Person readById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
    }

    @Override
    public void update(Person p) {
        this.mongoOps.save(p, PERSON_COLLECTION);
    }

    @Override
    public int deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = this.mongoOps.remove(query, Person.class, PERSON_COLLECTION);
        return result.getN();
    }

    @Override
    public List<Person> findByGender(String gender) {
        Query query = new Query(Criteria.where("gender").is(gender));
        return mongoOps.find(query, Person.class, PERSON_COLLECTION);
    }
}
