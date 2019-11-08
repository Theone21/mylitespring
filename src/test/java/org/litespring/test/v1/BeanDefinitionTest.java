package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.factory.BeanDefinition;
import org.litespring.beans.factory.config.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.resource.ClassPathResource;
import org.litespring.service.v1.PetStoreService;

public class BeanDefinitionTest {

    @Test
    public void testBeanDefinition() throws Exception {
        BeanDefinitionRegistry bdr = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(bdr);
        xmlBeanDefinitionReader.reader(new ClassPathResource("pet-store.xml"));
        BeanDefinition bd = bdr.getBeanDefintion("petStore");
        Assert.assertNotNull(bd);
        Assert.assertEquals(bd.getBeanClassName(), "org.litespring.service.v1.PetStoreService");
    }

    @Test
    public void testGetBean() throws Exception {
        DefaultBeanFactory bdr = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(bdr);
        xmlBeanDefinitionReader.reader(new ClassPathResource("pet-store.xml"));
        PetStoreService pss = (PetStoreService) bdr.getBean("petStore");
        Assert.assertNotNull(pss);
    }
}
