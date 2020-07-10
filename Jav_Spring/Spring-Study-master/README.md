# Spring-Study

## 1. Spring

### 1.1 简介

spring理念：是现有的技术更加容易使用，本身是一个大杂烩。

- SSH：Struct2 + Spring + Hibernate
- SSM: SpringMVC + Spring + Mybatis

官网： https://spring.io/projects/spring-framework#overview 

官方下载： https://repo.spring.io/release/org/springframework/spring/ 

GitHub： https://github.com/spring-projects/spring-framework 



[Spring Web MVC](https://mvnrepository.com/artifact/org.springframework/spring-webmvc) **»** [5.2.5.RELEASE](https://mvnrepository.com/artifact/org.springframework/spring-webmvc/5.2.5.RELEASE)

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.7.RELEASE</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.3.RELEASE</version>
</dependency>
```



- spring是开源的免费的容器。
- spring是一个轻量级的，非入侵式的。
- 控制反转（IOC），面向切面编程 (AOP)。
- 支持事务处理，对框架整合的支持。

总结：spring是一个轻量级的控制反转(IOC)和面向切面编程(AOP)的框架。

### 1.2 组成

![在这里插入图片描述](F:\Java\Java_Study\Jav_Spring\Spring-Study-master\README.assets\20200628180016435.png)

* **核心容器**：核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 BeanFactory，它是工厂模式的实现。BeanFactory 使用控制反转（IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。
  Spring 上下文：Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。
* **Spring AOP**：通过配置管理特性，Spring AOP 模块直接将面向切面的编程功能 , 集成到了 Spring 框架中。所以，可以很容易地使 Spring 框架管理任何支持 AOP的对象。Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖组件，就可以将声明性事务管理集成到应用。
* **Spring DAO**：JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵从通用的 DAO 异常层次结构。
* **Spring ORM**：Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。
* **Spring Web 模块**：Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与 Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。
* **Spring MVC 框架**：MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText 和 POI。

![在这里插入图片描述](F:\Java\Java_Study\Jav_Spring\Spring-Study-master\README.assets\20200628180025728.png)

### 1.3 拓展

![在这里插入图片描述](F:\Java\Java_Study\Jav_Spring\Spring-Study-master\README.assets\20200628180035980.png)

- Spring Boot
  - 一个快速开发的脚手架
  - 基于SpringBoot可以快速的开发单个微服务
- Spring Cloud
  - Spring Cloud是基于SpringBoot实现的



**Spring Boot与Spring Cloud**

-   Spring Boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务;
-   Spring Cloud是基于Spring Boot实现的；
-   Spring Boot专注于快速、方便集成的单个微服务个体，Spring Cloud关注全局的服务治理框架；
-   Spring Boot使用了约束优于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置 , Spring Cloud很大的一部分是基于Spring Boot来实现，Spring Boot可以离开Spring Cloud独立使用开发项目，但是Spring Cloud离不开Spring Boot，属于依赖的关系。
-   SpringBoot在SpringClound中起到了承上启下的作用，如果你要学习SpringCloud必须要学习SpringBoot。

## 2.IOC理论

### 2.1 理论推导

1. UserDao
2. UserDaoImp
3. UserSevice
4. UserServiceImp

在之前，用户的需求可能会影响原来的代码。

使用一个set。

```java
public void setUserDao(UserDao userDao){
    this.userDao = userDao;
}
```

- 之前是主动创建对象，控制权在程序员手上。
- 使用set之后，是被动接受对象。

![img](F:\Java\Java_Study\Jav_Spring\Spring-Study-master\README.assets\20200608095331772.png)

### 2.3 本质

​		**控制反转IoC**(Inversion of Control)，是一种设计思想，**DI(依赖注入)**是实现IoC的一种方法，也有人认为DI只是IoC的另一种说法。没有IoC的程序中 , 我们使用面向对象编程 , 对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是：**获得依赖对象的方式反转了。**

![在这里插入图片描述](F:\Java\Java_Study\Jav_Spring\Spring-Study-master\README.assets\20200628180055895.png)



​		采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

​		**控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection,DI）。**

## 3. Hello Spring

pojo中

```java
package com.frans.pojo;

public class Hello {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

resource种

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--bean = 对象-->
    <!--id = 变量名-->
    <!--class = new的对象-->
    <!--property 相当于给对象中的属性设值-->
    
    <bean id="hello" class="com.frans.pojo.Hello">
        <property name="name" value="Spring"/>
    </bean>
</beans>
```

test

```java
import com.frans.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {

    public static void main(String[] args) {
        //获取spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象下能在都在spring·中管理了，我们要使用，直接取出来就可以了
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
```

bean = 对象
id = 变量名
class = new的对象
property 相当于给对象中的属性设值

核心用set注入

第一个文件中

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userdaomysql" class="com.frans.dao.UserDaoMysqlImpl"></bean>

    <bean id="userServiceImpl" class="com.frans.service.UserServiceImp">
        <!--ref引用spring中已经创建很好的对象-->
        <!--value是一个具体的值-->
        <property name="userDao" ref="userdaomysql"/>
    </bean>

</beans>
```



## 4. IOC创建对象的方式

1. 使用无参构造创建对象，默认。
2. 使用有参构造

### 4.1 下标赋值

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="user" class="com.frans.pojo.User">
        <constructor-arg index="0" value="frans"/>
    </bean>
</beans>
```

>不是通过`set`注入。

### 4.2类型赋值（不建议使用）

```xml
<bean id="user" class="com.frans.pojo.User">
    <constructor-arg type="java.lang.String" value="dong"/>
</bean>
```

### 4.3直接通过参数名

```xml
<bean id="user" class="com.frans.pojo.User">
    <constructor-arg name="name" value="frans"></constructor-arg>
</bean>
```

Spring类似于婚介网站！

你想不想要，对象都在里面。注册bean之后用不用被实例化。



## 5. Spring配置

### 5.1 别名

```xml
<bean id="user" class="com.frans.pojo.User">
    <constructor-arg name="name" value="frans"></constructor-arg>
</bean>

<alias name="user" alias="user2aaa"/>
```



### 5.2  **Bean的配置**

- id：bean的id标识符
- class：bean对象所对应的类型
- name：别名，更高级，可以同时取多个别名。



### 5.3  **import**

一般用于团队开发，它可以将多个配置文件，导入合并为一个

```xml
<import resource="beans.xml"/>
```



## 6. DI依赖注入

### 6.1  **构造器注入**

### 6.2 **set方式注入**（重点）

- 依赖：bean对象的创建依赖于容器
- 注入：bean对象中的所有属性，由容器来注入

【环境搭建】

1. 复杂类型
2. 真实测试对象

```java
package com.pojo;

import java.util.*;

public class Student {

    private String name;
    private Address address;

    private String[] books;
    private List<String> hobbies;

    private Map<String, String> card;
    private Set<String> game;

    private Properties infor;
    private String wife;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", hobbies=" + hobbies +
                ", card=" + card +
                ", game=" + game +
                ", infor=" + infor +
                ", wife='" + wife + '\'' +
                '}';
    }
}
```

```java
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="address" class="com.pojo.Address">
        <property name="address" value="xian"></property>
    </bean>

    <bean id="student" class="com.pojo.Student">
        <property name="name" value="frans"/>
        <property name="address" ref="address"/>

        <!--数组注入-->
        <property name="books">
            <array>
                <value>三国</value>
                <value>西游</value>
                <value>水浒</value>
            </array>
        </property>

        <!--list-->
        <property name="hobbies">
            <list>
                <value>eat</value>
                <value>drink</value>
                <value>play</value>
            </list>
        </property>

        <property name="card">
            <map>
                <entry key="1" value="12"/>
                <entry key="2" value="23"/>
            </map>
        </property>

        <property name="game">
            <set>
                <value>wangzhe</value>
                <value>daota</value>
                <value>lol</value>
            </set>
        </property>

        <property name="wife">
            <null></null>
        </property>

        <!--properties-->
        <property name="infor">
            <props>
                <prop key="id">20200405</prop>
                <prop key="name">hdk</prop>
            </props>
        </property>
    </bean>

</beans>
```

**第三方**

p标签和c标签

```java
package com.pojo;

public class User {

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p命名空间注入/set注入-->
    <bean id="use" class="com.pojo.User" p:name="dong" p:age="10">
    </bean>

    <!--c命名空间/构造器-->
    <bean id="use2" class="com.pojo.User" c:name="kun" c:age="19"></bean>
</beans>
```



**bean的作用域**

![1586093707060](C:\Users\QHQ\AppData\Roaming\Typora\typora-user-images\1586093707060.png)

1. 单例模式（默认）

```xml
<bean id="use2" class="com.pojo.User" c:name="kun" c:age="19" scope="singleton"></bean>
```

2. 原型模式: 每次从容器中get的时候，都产生一个新对象！

```xml
<bean id="use2" class="com.pojo.User" c:name="kun" c:age="19" scope="prototype"></bean>
```

3. 其余的request、session、application这些只能在web开放中使用！



## 7. Bean的自动装配

- 自动装配是Spring是满足bean依赖的一种方式
- Spring会在上下文自动寻找，并自动给bean装配属性
- 

在Spring中有三种装配的方式

1. 在xml中显示配置
2. 在java中显示配置
3. 隐式的自动装配bean 【重要】



1. 环境搭建：一个人有两个宠物

2. Byname自动装配：byname会自动查找，和自己对象set对应的值对应的id

   保证所有id唯一，并且和set注入的值一致

3. Bytype自动装配：byType会自动查找，和自己对象属性相同的bean

   保证所有的class唯一

```java
public class Cat {
    public void jiao(){
        System.out.println("miao");
    }
}
```

````java
public class Dog {

    public void jiao(){
        System.out.println("wow");
    }

}
````

```java
package com.pojo;


public class People {

    private Cat cat;
    private Dog dog;
    private String name;

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="cat11" class="com.pojo.Cat"/>
    <bean id="dog" class="com.pojo.Dog"/>
    <!--byname会自动查找，和自己对象set对应的值对应的id-->
    <!--<bean id="people" class="com.pojo.People" autowire="byName">-->
        <!--<property name="name" value="frans"></property>-->
    <!--</bean>-->
    <!--byType会自动查找，和自己对象属性相同的bean-->
    <bean id="people" class="com.pojo.People" autowire="byType">
        <property name="name" value="frans"></property>
    </bean>

</beans>
```



**使用注解自动装配**

jdk1.5支持的注解，spring2.5支持的注解

 The introduction of annotation-based configuration raised the question of whether this approach is “better” than XML. 

导入context约束

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

@Autowire

在属性上个使用，也可以在set上使用

我们可以不用编写set方法了

```java
public class People {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;
}
```

```xml
@Nullable 字段标志的注解，说明这个字段可以为null
```

如果@Autowired自动装配环境比较复杂。自动装配无法通过一个注解完成的时候

我们可以使用@Qualifier(value = "dog")去配合使用，指定一个唯一的id对象

```java
public class People {
    @Autowired
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog")
    private Dog dog;
    private String name;
}
```

@Resource(name="dog")也可以

区别：

- @autowire通过byType实现，而且必须要求这个对象存在

- @resource默认通过byName实现，如果找不到，通过byType实现



## 8. 使用注解开发

在spring4之后，必须要保证aop的包导入

使用注解需要导入contex的约束

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

1. 属性如何注入

```java
@Component
public class User {
    
    @Value("dong")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

2. 衍生的注解

@Component有几个衍生注解，会按照web开发中，mvc架构中分层。

- dao （@Repository）
- service（@Service）
- controller（@Controller）

这四个注解功能一样的，都是代表将某个类注册到容器中

3. 作用域

@Scope("singleton")

```java
@Component
@Scope("prototype")
public class User {

    @Value("dong")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

小结：

xml与注解

- xml更加万能，维护简单
- 注解，不是自己的类，使用不了，维护复杂

最佳实践：

- xml用来管理bean
- 注解只用来完成属性的注入

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>
    <!--指定要扫描的包-->
    <context:component-scan base-package="com.pojo"/>

</beans>
```



## 9. 使用java方式配置spring

JavaConfig

Spring的一个子项目，在spring4之后，，他成为了核心功能

```java
@Configuration //这个也会被spring容器托管，注册到容器中，因为他本来就是一个@Component
@ComponentScan("com.pojo")
@Import(Config2.class)
public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }

}
```

```java
@Component
public class User {

    @Value("dong")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

这种纯java配置方式

在springboot中，随处可见



## 10. 动态代理

动态代理和静态代理

角色一样

动态代理类是动态生成的，不是我们直接写好的！

动态代理：基于接口，基于类

- 基于接口：JDK的动态代理【使用】
- 基于类：cglib
- java字节码

InvocationHandler

Proxy

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//会这个类，自动生成代理类
public class ProxyInvocation implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

    //处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seefransse();
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }

    public void seefransse(){
        System.out.println("see fransse");
    }

    public void fare(){
        System.out.println("fare");
    }
}
```

```java
public interface Rent {
    void rent();
}
```

```java
public class Host implements Rent {
    public void rent() {
        System.out.println("host rent");
    }
}
```

```java
public class Client {

    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色
        ProxyInvocation proxyInvocation = new ProxyInvocation();

        //通过调用程序处理角色来处理我们要调用的接口对象
        proxyInvocation.setRent(host);

        Rent proxy = (Rent) proxyInvocation.getProxy();  //这里的proxy是动态生成的

        proxy.rent();
    }
}
```



## 11.AOP

```xml
<dependencies>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.4</version>
    </dependency>
</dependencies>
```

方法一：使用spring接口【springAPI接口实现】

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beanss
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--注册bean-->
    <bean id="userservice" class="com.service.UserServiceImp"></bean>
    <bean id="log" class="com.log.Log"/>
    <bean id="afterlog" class="com.log.AfterLog"/>

    <!--配置aop-->
    <aop:config>
        <!--切入点：expression:表达式，execution（要执行的位置）-->
        <aop:pointcut id="point" expression="execution(* com.service.UserServiceImp.*(..))"/>
        <!--执行环绕-->
        <aop:advisor advice-ref="log" pointcut-ref="point"/>
        <aop:advisor advice-ref="afterlog" pointcut-ref="point"/>
    </aop:config>

</beans>
```

```java
public class UserServiceImp implements UserService {


    public void add() {
        System.out.println("add");
    }

    public void delete() {
        System.out.println("delete");
    }

    public void query() {
        System.out.println("query");
    }

    public void update() {
        System.out.println("update");
    }
}
```

```java
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {
    //method：要执行的目标对象的方法
    //args：参数
    //target：目标对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+method.getName());
    }
}
```

```java
public class AfterLog implements AfterReturningAdvice {

    //returnVaule: 返回值
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName()+returnValue);
    }
}
```

```java
public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplcationContext.xml");
        //动态代理代理的是接口
        UserService userService = (UserService) context.getBean("userservice");
        userService.add();
    }
}
```

方法二：自定义来实现AOP【主要是切面定义】

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--注册bean-->
    <bean id="userservice" class="com.service.UserServiceImp"></bean>
    <bean id="log" class="com.log.Log"/>
    <bean id="afterlog" class="com.log.AfterLog"/>

    <bean id="diy" class="com.diy.DiyPointcut">
    </bean>
    <aop:config>
        <!--自定义切面-->
        <aop:aspect ref="diy">
            <!--切入点-->
            <aop:pointcut id="point" expression="execution(* com.service.UserServiceImp.*(..))"/>
            <aop:before method="before" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>
        </aop:aspect>
    </aop:config>

</beans>
```

```java
public class DiyPointcut {

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }
}
```

方法三：注解方式

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">
    
    <bean id="ann" class="com.diy.Annotation"></bean>
    <aop:aspectj-autoproxy/>
    <!--注册bean-->
    <bean id="userservice" class="com.service.UserServiceImp"></bean>
    
</beans>
```

```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect  //标注这个类是一个切面
public class Annotation {

    @Before("execution(* com.service.UserServiceImp.*(..))")
    public void before(){
        System.out.println("before");
    }

    @After("execution(* com.service.UserServiceImp.*(..))")
    public void after(){
        System.out.println("after");
    }

    //在环绕增强中，我们可以给地暖管一个参数，代表我们要获取切入的点
    @Around("execution(* com.service.UserServiceImp.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around");

        Object proceed = joinPoint.proceed();

        System.out.println("after around");
    }
}
```



## 12. 整合mybatis

文档： https://mybatis.org/spring/zh/ 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>spring-study</artifactId>
        <groupId>com.frans</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>spring-10-mybatis</artifactId>

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.4</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>


        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>

        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>

</project>
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

    <typeAliases>
        <package name="com.pojo"/>
    </typeAliases>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://111.230.212.103:3306/mybatis?userSSL=true&amp;
                userUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="hdk123"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper class="com.mapper.UserMapper"/>
    </mappers>
</configuration>
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.mapper.UserMapper">

    <select id="selectUser" resultType="user">
        select * from mybatis.user;
    </select>

</mapper>
```

```java
public interface UserMapper {
    List<User> selectUser();
}
```

整合

方法一：

![1586177510119](C:\Users\QHQ\AppData\Roaming\Typora\typora-user-images\1586177510119.png)

UserMapperImpl

```java
package com.mapper;

import com.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> selectUser() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
```

mybatis.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

    <typeAliases>
        <package name="com.pojo"/>
    </typeAliases>

</configuration>
```

spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--data source-->
    <bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://111.230.212.103:3306/mybatis?userSSL=true&amp;
                userUnicode=true&amp;characterEncoding=UTF-8"/>
        <property name="username" value="root"/>
        <property name="password" value="hdk123"/>
    </bean>

    <!--sqlsession-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="datasource" />
        <!--bound mybatis-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:com/mapper/UserMapper.xml"/>
    </bean>

    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <constructor-arg index="0" ref="sqlSessionFactory"/>
    </bean>

    <bean id="userMapper" class="com.mapper.UserMapperImpl">
        <property name="sqlSessionTemplate" ref="sqlSession"></property>
    </bean>

</beans>
```

test

```java
import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class Mytest {


    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
    }
}

```



方法二：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--data source-->
    <bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://111.230.212.103:3306/mybatis?userSSL=true&amp;
                userUnicode=true&amp;characterEncoding=UTF-8"/>
        <property name="username" value="root"/>
        <property name="password" value="hdk123"/>
    </bean>

    <!--sqlsession-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="datasource" />
        <!--bound mybatis-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:com/mapper/UserMapper.xml"/>
    </bean>

    <!--<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">-->
        <!--<constructor-arg index="0" ref="sqlSessionFactory"/>-->
    <!--</bean>-->

    <!--<bean id="userMapper" class="com.mapper.UserMapperImpl">-->
        <!--<property name="sqlSessionTemplate" ref="sqlSession"></property>-->
    <!--</bean>-->

    <bean id="userMapper2" class="com.mapper.UserMapperIml2">
        <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
    </bean>

</beans>
```

```java
package com.mapper;

import com.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperIml2 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> selectUser() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
```



## 13. 声明式事务

- 要么都成功，要么都失败
- 十分重要，涉及到数据一致性
- 确保完整性和一致性

事务的acid原则：

- 原子性

- 一致性

- 隔离性

  - 多个业务可能操作一个资源，防止数据损坏

- 持久性

  - 事务一旦提交，无论系统发生什么问题，结果都不会被影响。

  

Spring中的事务管理

- 声明式事务
- 编程式事务

声明式事务

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        https://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-tx.aop">

    <!--data source-->
    <bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://111.230.212.103:3306/mybatis?userSSL=true&amp;
                userUnicode=true&amp;characterEncoding=UTF-8"/>
        <property name="username" value="root"/>
        <property name="password" value="hdk123"/>
    </bean>

    <!--sqlsession-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="datasource" />
        <!--bound mybatis-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:com/mapper/*.xml"/>
    </bean>

    <!--声明式事务-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <constructor-arg ref="datasource" />
    </bean>

    <!--结合aop实现事务置入-->
    <!--配置事务的类-->
    <tx:advice id="tx1" transaction-manager="transactionManager">
        <!--给哪些方法配置事务-->
        <!--配置事务的传播特性-->
        <tx:attributes>
            <tx:method name="add" propagation="REQUIRED"/>
            <tx:method name="delete" propagation="REQUIRED"/>
            <tx:method name="update" propagation="REQUIRED"/>
            <tx:method name="*" propagation="REQUIRED"/>
            <tx:method name="query" read-only="true"/>
        </tx:attributes>
    </tx:advice>

    <!--配置事务切入-->
    <aop:config>
        <aop:pointcut id="txpointxut" expression="execution(* com.mapper.*.*(..))"/>
        <aop:advisor advice-ref="tx1" pointcut-ref="txpointxut"/>
    </aop:config>

</beans>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <import resource="spring-dao.xml"/>

    <bean id="userMapper2" class="com.mapper.UserMapperIml2">
        <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
    </bean>

</beans>
```

Mapper

```java
package com.mapper;

import com.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    int addUser(User user);
    int delete(int id);
}
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.mapper.UserMapper">
    <select id="selectUser" resultType="user">
        select * from mybatis.user;
    </select>

    <insert id="addUser" parameterType="user">
        insert into mybatis.user (id, name, pwd) values
        (#{id}, #{name}, #{pwd})
    </insert>

    <delete id="delete" parameterType="int">
        delete from mybatis.user where id=#{id}
    </delete>
</mapper>
```

```java
package com.mapper;

import com.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperIml2 extends SqlSessionDaoSupport implements UserMapper {

    public List<User> selectUser() {
        User user = new User(6, "long", "zhi");
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(user);
        mapper.delete(6);
        return mapper.selectUser();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int delete(int id) {
        return getSqlSession().getMapper(UserMapper.class).delete(id);
    }
}
```
