package com.lagou.io;

import java.io.InputStream;


public class Resource {

    // 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存在
    public static InputStream getResourceAsSteam(String path){
        InputStream resourceAsStream = Resource.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;

    }
}
