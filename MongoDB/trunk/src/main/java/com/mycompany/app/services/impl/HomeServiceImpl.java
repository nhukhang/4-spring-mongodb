package com.mycompany.app.services.impl;

import com.mycompany.app.dao.PersonDAO;
import com.mycompany.app.modal.Person;
import com.mycompany.app.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 12/4/14
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class HomeServiceImpl implements HomeService {


    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    private PersonDAO personDAO;

    @Override
    public String findByGender(String gender) {
        List<Person> persons = personDAO.findByGender(gender);
        return persons.toString();
    }
}
