package org.litespring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.factory.BeanDefinition;
import org.litespring.beans.factory.config.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.GenericBeanDefinition;
import org.litespring.resource.Resource;

import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {

    private BeanDefinitionRegistry beanDefinitionRegistry;


    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry){
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void reader(Resource resource) throws Exception {
        InputStream is = resource.getInputStream();
        SAXReader reader = new SAXReader();
        Document doc = reader.read(is);
        Element root = doc.getRootElement();
        Iterator<Element> iter = root.elementIterator();
        while(iter.hasNext()){
            Element ele = iter.next();
            String id = ele.attributeValue("id");
            String className = ele.attributeValue("class");
            BeanDefinition bd = new GenericBeanDefinition(id, className);
            this.beanDefinitionRegistry.setBeanDefinition(id, bd);
        }
    }
}
