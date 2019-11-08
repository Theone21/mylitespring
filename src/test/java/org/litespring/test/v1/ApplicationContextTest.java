package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathApplicationContext;
import org.litespring.service.v1.PetStoreService;

public class ApplicationContextTest {

    @Test
    public void testGetBean() throws Exception {
        ApplicationContext cpa = new ClassPathApplicationContext("pet-store.xml");
        PetStoreService pss = (PetStoreService) cpa.getBean("petStore");
        Assert.assertNotNull(pss);
    }
}
