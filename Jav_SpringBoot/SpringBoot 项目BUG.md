## SpringBoot 项目BUG



thymeleaf关于静态资源报错问题：

![image-20210319113923613](C:\Users\樊世雄\AppData\Roaming\Typora\typora-user-images\image-20210319113923613.png)



@enablewebmvc记得要去掉，我就是没去掉浪费了四十分钟!  而enablewebmvc它会让你的静态资源链接无法加载，是引入webmvcconfigurationsupport的，也就是spring会跳过springboot的自动装配（也就是webmvautoconfiguration），会扫描不到src/main/resource/static下的静态资源，但如果使用@enableautoconfiguration 注解会读取呀妹儿（yaml）和properties的配置!