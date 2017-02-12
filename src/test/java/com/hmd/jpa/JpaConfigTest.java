package com.hmd.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;


/**
 * Created by Ady on 2/12/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront-jpa.xml"
})
@Transactional
public class JpaConfigTest {



    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void testConfig() {
        Assert.notNull(entityManager);
    }

}
