# Spring_Mybatis步骤(基于注解)

## 首先定义映射接口

```java
public interface IUserMapper {

    @Insert("insert into users (name, age) value(#{name}, #{age})")
    public int add(User user);

    @Delete("delete from users where id=#{id}")
    public int deleteById(int id);

    @Update("update users set name=#{name}, age=#{age} where id=#{id}")
    public int update(User user);

    @Select("select * from users where id=#{id}")
    public User getById(int id);

    @Select("select * from users")
    public List<User> getAll();
}
```



## 然后在mybatisConfig.xml中注册接口

```xml
<!-- 注册表映射文件 -->
<mappers>
    <mapper class="com.mybatis.IUserMapper"/>
</mappers>
```



## CRUD

```java
/**
 * 使用注解测试的方法
 */
public void test() {
    IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

    User user = userMapper.getById(1);
    System.out.println(user);
}
```

