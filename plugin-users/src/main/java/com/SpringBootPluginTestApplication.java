package com;

import com.qf.users.config.PluginImportBeanDefinitionRegistrar;
import com.qf.users.utils.ByteCodeEncryptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

//@ComponentScan("com.plugin.impl")
@Slf4j
@SpringBootApplication
//@Import(PluginImportBeanDefinitionRegistrar.class)
public class SpringBootPluginTestApplication {
    public static class CustomGenerator implements BeanNameGenerator {

        @Override
        public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
            return definition.getBeanClassName();
        }
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootPluginTestApplication.class)
                .beanNameGenerator(new CustomGenerator())
                .run(args);
    }

//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootPluginTestApplication.class, args);
//    }
}
