package org.litespring.test.v1;

import org.junit.Test;
import org.litespring.resource.ClassPathResource;
import org.litespring.resource.Resource;
import org.springframework.util.Assert;

public class ResourceTest {

    @Test
    public void test1(){
        Resource resource = new ClassPathResource("pet-store.xml");
        Assert.notNull(resource.getInputStream(), "");
    }
}
