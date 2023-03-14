package com.qf.users.controller;

import com.qf.users.utils.ClassLoaderUtil;
import com.qf.users.utils.SpringUtil;
import com.qf.util.PluginInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author qf
 * @version 1.0
 * @date 2023/2/20
 * <p>
 * Github: https://github.com/qf8505
 */
@Slf4j
@RestController
public class TestController {
    @Autowired(required = false)
    private PluginInterface pluginInterface;

    @Resource
    private SpringUtil springUtil;

    /**
     * jar的地址
     */
    @Value("${targetUrl}")
    private String targetUrl;
    /**
     * 插件类全路径
     */
    @Value("${pluginClass}")
    private String pluginClass;

    @GetMapping("/test")
    public String test() {
        return pluginInterface.sayHello("test plugin");
    }

    /**
     * 运行时注册bean
     */
    @GetMapping("/reload")
    public Object reload() throws ClassNotFoundException {
        log.info("targetUrl========={}",targetUrl);
        ClassLoader classLoader = ClassLoaderUtil.getClassLoader(targetUrl);
        Class<?> clazz = classLoader.loadClass(pluginClass);
        springUtil.registerBean(clazz.getName(), clazz);
        Object bean = springUtil.getBean(clazz.getName());
        if(bean instanceof PluginInterface){
            PluginInterface plugin = (PluginInterface)bean;
            this.pluginInterface = plugin;
            log.info(plugin.init("init"));
            return plugin.sayHello("test reload");
        }else{
            log.info(bean.getClass().getInterfaces()[0].getName());
            return bean.toString();
        }
    }

    /**
     * 移除bean
     * @return
     * @throws ClassNotFoundException
     */
    @GetMapping("/remove")
    public Object remove() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoaderUtil.getClassLoader(targetUrl);
        Class<?> clazz = classLoader.loadClass(pluginClass);
        springUtil.removeBean(clazz.getName());
        this.pluginInterface = null;
        Object bean = springUtil.getBean(clazz.getName());
        if(bean!=null) {
            log.info(bean.toString());
        }
        return clazz.getName();
    }
}
