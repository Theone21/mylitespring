package org.litespring.beans.factory.support;

import org.litespring.beans.factory.BeanDefinition;
import org.litespring.beans.factory.config.BeanDefinitionRegistry;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.util.ClassUtils;

import java.util.HashMap;
import java.util.Map;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory,
        BeanDefinitionRegistry {
    private ClassLoader classLoader;
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();



    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = this.beanDefinitionMap.get(beanId);
        if(bd.isSingleton()){
            Object obj = this.getSingleton(beanId);
            if(obj == null){
                obj = createBean(bd);
                this.registerSingleton(beanId, obj);
            }
            return obj;
        }
        return createBean(bd);
    }

    private Object createBean(BeanDefinition bd) {
        String beanClassName = bd.getBeanClassName();
        ClassLoader classLoader = this.getBeanClassLoader();
        Class<?> clz = null;
        try {
            clz = classLoader.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            //TODO 需要自定义异常
            throw new RuntimeException(e);
        }

    }

    @Override
    public BeanDefinition getBeanDefintion(String beanId) {
        return beanDefinitionMap.get(beanId);
    }

    @Override
    public void setBeanDefinition(String beanId, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanId, bd);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }
}
