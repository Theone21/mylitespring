package org.litespring.beans.factory.support;

import org.litespring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public void registerSingleton(String beanId, Object obj) {
        if(this.getSingleton(beanId) != null){
            throw new RuntimeException("该" + beanId + "bean 已经存在");
        }
        this.singletonObjects.put(beanId, obj);
    }

    @Override
    public Object getSingleton(String beanId) {
        return singletonObjects.get(beanId);
    }
}
