#Spring_Mybatis步骤（基于XML）

## 建立表

```sql
create table users (
    id int primary key auto_increment,
    name varchar(20),
    age int
);
insert into users (name, age) values('Tom', 12);
insert into users (name, age) values('Jack', 11);
```



## 建立实体类

```java
public class User {

    private int id;
    private String name;
    private int age;

    public User() { }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```



## 配置mybatisConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
<environments default="development">
    <!-- development:开发环境 work:工作模式 -->
    <environment id="development">
        <transactionManager type="JDBC" />
        <!-- 数据库连接方式 -->
        <dataSource type="POOLED">
            <property name="driver" value="com.mysql.jdbc.Driver" />
            <property name="url" value="jdbc:mysql://192.168.1.150/test" />
            <property name="username" value="root" />
            <property name="password" value="123456" />
        </dataSource>
    </environment>
</environments>

<!-- 注册表映射文件 -->
<mappers>
    <mapper resource="com/mybatis/userMapper.xml"/>
</mappers>

</configuration>
```



# 配置映射文件(与实体类放在同一个包)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.mybatis.userMapper">
    <!-- 根据id查询一个User对象 -->
    <select id="getUser" parameterType="int" resultType="com.mybatis.User">
        select * from users where id=#{id}
    </select>
    <select id="getUserAll" resultType="com.mybatis.User">
        select * from users
    </select>

    <!-- 插入一个User对象 -->
    <insert id="insertUser" parameterType="com.mybatis.User">
        insert into users (name, age) value(#{name}, #{age})
    </insert>

    <!-- 删除一个User对象 -->
    <delete id="deleteUser" parameterType="int">
        delete from users where id=#{id}
    </delete>

    <!-- 更新一个User对象-->
    <update id="updateUser" parameterType="com.mybatis.User">
        update users set name=#{name}, age=#{age} where id=#{id}
    </update>
</mapper>
```



## CRUD

```java
public class mybaitstest {

    SqlSessionFactory sessionFactory = null;
    SqlSession sqlSession = null;

    {
        String resource = "mybatisConfig.xml";
        // 加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建sqlSession的工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession，默认是手动提交事务的，使用自动提交的话加上参数 true
        sqlSession = sessionFactory.openSession(true);
    }

    public void testSelectUser() {
        // 映射sql的标识字符串
        String statement = "com.mybatis.userMapper" + ".getUser";
        // 执行查询返回一个唯一user对象的sql
        User user = sqlSession.selectOne(statement, 1);
        System.out.println(user);
    }

    public void testSelectAll() {
        List<User> users = sqlSession.selectList("com.mybatis.userMapper.getUserAll");
        System.out.println(users);
    }

    public void testInsertUser(User user) {
        int insert = sqlSession.insert("com.mybatis.userMapper.insertUser", user);
        // 如果不是自动提交的话，需要使用 sqlSession。commit()
        System.out.println(insert);
    }

    public void testDeleteUser(int id) {
        int delete = sqlSession.delete("com.mybatis.userMapper.deleteUser", id);
        System.out.println(delete);
    }

    public void testUpdateUser(User user) {
        int update = sqlSession.update("com.mybatis.userMapper.updateUser", user);
        System.out.println(update);
    }

    public static void main(String[] args) throws IOException {

        new mybaitstest().testSelectUser();
    }
}
```

