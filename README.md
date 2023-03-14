   #### 参照项目：详细说明
[《Spring Boot 如何热加载jar实现动态插件？》](https://mp.weixin.qq.com/s/Fg-jsoFon5LwsPAaBbeiew)

#### 目录结构
- **plugin-impl**：插件实现
- **plugin-users**：插件使用样例
- **plugins-interface**：插件接口包

1.使用了proguard-maven-plugin插件进行代码混淆
2.使用classfinal对插件包进行加密，其中需要修改classfinal从CommonUtil中读取密码。
    java -jar c:\\classfinal-fatjar-1.2.1.jar -file plugin-impl-0.0.1-SNAPSHOT.jar -packages com.plugin -exclude com.plugin.util.CommonUtil -pwd 123456 -Y
3.使用自定义dll对CommonUtil进行加密处理，参照了https://github.com/sea-boat/ByteCodeEncrypt.git
4.启动项目，通过dll对CommonUtil密码进行修改。java -agentpath:c:\\encryptor.dll -javaagent:c:\\classfinal-fatjar-1.2.1.jar -jar plugin-users-0.0.1-SNAPSHOT.jar 