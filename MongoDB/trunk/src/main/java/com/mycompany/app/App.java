package com.mycompany.app;

import com.mongodb.MongoClient;
import com.mycompany.app.modal.Person;
import com.mycompany.app.services.HomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App{

    public static void main( String[] args ){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        HomeService homeService = (HomeService)context.getBean("homeService");
        System.out.println(homeService.findByGender("m"));

        try{
            //testConnectionNoMappingHibernate();
        }catch (Exception e){
            System.out.println("Got error: " + e.getMessage());
        }
    }

    public static void testConnectionNoMappingHibernate() throws Exception{
        String DB_NAME = "test";
        String PERSON_COLLECTION = "nettuts";
        String MONGO_HOST = "localhost";
        int MONGO_PORT = 27017;

        MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
        MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
        //Person p = new Person();
        //mongoOps.insert(p, PERSON_COLLECTION);
        List<Person> p1 = mongoOps.find(
                new Query(Criteria.where("gender").is("m")),
                Person.class, PERSON_COLLECTION);

        System.out.println("found: " + p1.size());
        System.out.println(p1.toString());
        //mongoOps.dropCollection(PERSON_COLLECTION);
        mongo.close();
    }
}
