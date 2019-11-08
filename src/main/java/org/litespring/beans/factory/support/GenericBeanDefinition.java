package org.litespring.beans.factory.support;

import org.litespring.beans.factory.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition
{
    private String beanId;
    private String beanClassName;
    private String scope = SCOPE_DEFAULT;
    private boolean singleton = true;
    private boolean prototype = false;

    public GenericBeanDefinition(String beanId, String beanClassName){
        this.beanId = beanId;
        this.beanClassName = beanClassName;
    }


    @Override
    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public boolean isPrototype() {
        return prototype;
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = !this.singleton;
        this.scope = scope;
    }

    @Override
    public String getBeanClassName() {
        return beanClassName;
    }

    @Override
    public String getBeanId() {
        return beanId;
    }
}
