# DI实例

## dao

```java
public interface BookDao {
    public void save();
}
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("di  add book");
    }
}
```

dao层是最接近数据库的增删改查操作

而使用 直接可以通过类型使用 这就是集成为dao的好处



## service

```java
public interface BookService {

    public abstract void addBook();

}
public class BookServiceImpl implements BookService {

    // 方式1：之前，接口=实现类
//  private BookDao bookDao = new BookDaoImpl();
    // 方式2：接口 + setter
    private BookDao bookDao;                      
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addBook(){
        this.bookDao.save();
    }

}
```

而service层是借助dao层完成组合操作 以适应实际情况 

如小明买一本书需扣除小明一部分钱 再加上商店一部分钱



## bean配置

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- 
    模拟spring执行过程
        创建service实例：BookService bookService = new BookServiceImpl() IoC  <bean>
        创建dao实例：BookDao bookDao = new BookDaoImpl()         IoC
        将dao设置给service：bookService.setBookDao(bookDao);     DI   <property>

        <property> 用于进行属性注入
            name： bean的属性名，通过setter方法获得
                setBookDao ##> BookDao  ##> bookDao
            ref ：另一个bean的id值的引用
     -->

    <!-- 创建service -->
    <bean id="bookServiceId" class="com.itheima.b_di.BookServiceImpl">
        <property name="bookDao" ref="bookDaoId"></property>
    </bean>

    <!-- 创建dao实例 -->
    <bean id="bookDaoId" class="com.itheima.b_di.BookDaoImpl"></bean>


</beans>
```

通过bean将bookDao与bookService进行耦合 注意到bookService没有直接进行new 

而是通过设置构造函数接收bookDao 所以也注意到注入属性不一定仅是单纯的变量 

也可以是注入一个对象 IOC仅做到了创建一个对象 没有实现注入到另外一个类以一个对象

​                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    