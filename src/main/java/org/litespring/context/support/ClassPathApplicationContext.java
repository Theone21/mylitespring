package org.litespring.context.support;

import org.litespring.context.AbstractApplicationContext;
import org.litespring.resource.ClassPathResource;
import org.litespring.resource.Resource;

public class ClassPathApplicationContext extends AbstractApplicationContext {

    public ClassPathApplicationContext(String filePath) throws Exception {
        super(filePath);
    }

    @Override
    public Resource getResourceByPath(String filePath) {
        return new ClassPathResource(filePath);
    }
}
