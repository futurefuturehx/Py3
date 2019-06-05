# IOC实例

## Service类

```java
public interface UserService {
    public void addUser();
}
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("a_ico add user");
    }
}
```



## 配置bean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- 配置service 
        <bean> 配置需要创建的对象
            id ：用于之后从spring容器获得实例时使用的
            class ：需要创建实例的全限定类名
    -->
    <bean id="userServiceId" class="com.itheima.a_ioc.UserServiceImpl"></bean>
</beans>
```



## 使用Spring代理

```java
   @Test
    public void demo02(){
        //从spring容器获得
        //1 获得容器
        String xmlPath = "com/itheima/a_ioc/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //2获得内容 --不需要自己new，都是从spring容器获得
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        userService.addUser();  
```

改为getbean方式创建类

DI在IOC的基础上实现 IOC实现类的创建交给Spring管理 DI实现属性的注入交给Spring管理