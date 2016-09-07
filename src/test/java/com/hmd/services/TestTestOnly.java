package com.hmd.services;

import com.halalmeatdepot.domain.testonly.Person;
import com.halalmeatdepot.domain.testonly.PersonProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

/**
 * Created by sjchen on 9/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {"/storefront.xml"})

@Transactional
public class TestTestOnly {
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @Rollback(value = false)
    public void test(){
        Person person = new Person();
        person.setName("me");
        PersonProfile personProfile=new PersonProfile();
        personProfile.setProfileName("prifile");
        person.setPersonProfile(personProfile);
        personProfile.setPersonInProfile(person);
        Session session= sessionFactory.getCurrentSession();
        session.save(person);
    }
}
