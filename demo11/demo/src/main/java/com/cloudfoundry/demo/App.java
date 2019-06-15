package com.cloudfoundry.demo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import com.cloudfoundry.demo.config.SpringApplicationContextInitializer;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class,MongoDataAutoConfiguration.class})
public class App implements  EmbeddedServletContainerCustomizer{

    public static void main(String[] args) {
    	//构造器，支持方便的fluent API和上下文层次结构
        new SpringApplicationBuilder(App.class).
        		//向应用程序添加一些初始化器(在加载任何bean定义之前应用于ApplicationContext)。
                initializers(new SpringApplicationContextInitializer())
                .application()
                .run(args);
    }
    @Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8087); 		
	}
}