package org.litespring.resource;

import org.litespring.util.ClassUtils;


import java.io.InputStream;

public class ClassPathResource implements Resource {

    private String filePath;

    public ClassPathResource(String filePath){
        this.filePath = filePath;
    }

    @Override
    public InputStream getInputStream() {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        return classLoader.getResourceAsStream(filePath);
    }
}
