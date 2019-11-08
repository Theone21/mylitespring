package org.litespring.beans.factory.config;


import org.litespring.beans.factory.BeanDefinition;

public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefintion(String beanId);

    void setBeanDefinition(String beanId, BeanDefinition bd);
}
