# Mybatis面试题

## Mybatis相对于IBatis的改进

a.动态sql由节点配置改成OGNL表达式

b.有接口绑定 包括注解绑定和xml绑定Sql



## 什么是MyBatis的接口绑定 有啥好处

将接口里的方法与SQL语句联系起来 调用方法就能执行对应SQL语句 这样就能便捷选择 灵活配置



# 接口绑定有几种方式 分别怎么实现

a.在接口方法前加上@Select @Update等注解 里面包含Sql语句

b.通过xml里写SQL来绑定 此时 xml的namespace必须为接口路径名



##什么时候用xml绑定 什么时候用xml绑定

当SQL语句比较复杂的时候 用xml绑定 一般用xml绑定较多



## MyBatits的动态语句

```sql
<!-- 2 if(判断参数) - 将实体类不为空的属性作为where条件 -->  
<select id="getStudentList_if" resultMap="resultMap_studentEntity" parameterType="liming.student.manager.data.model.StudentEntity">  
    SELECT ST.STUDENT_ID,  
           ST.STUDENT_NAME,  
           ST.STUDENT_SEX,  
           ST.STUDENT_BIRTHDAY,  
           ST.STUDENT_PHOTO,  
           ST.CLASS_ID,  
           ST.PLACE_ID  
      FROM STUDENT_TBL ST   
     WHERE  
    <if test="studentName !=null ">  
        ST.STUDENT_NAME LIKE CONCAT(CONCAT('%', #{studentName, jdbcType=VARCHAR}),'%')  
    </if>  
    <if test="studentSex != null and studentSex != '' ">  
        AND ST.STUDENT_SEX = #{studentSex, jdbcType=INTEGER}  
    </if>  
    <if test="studentBirthday != null ">  
        AND ST.STUDENT_BIRTHDAY = #{studentBirthday, jdbcType=DATE}  
    </if>  
    <if test="classId != null and classId!= '' ">  
        AND ST.CLASS_ID = #{classId, jdbcType=VARCHAR}  
    </if>  
    <if test="classEntity != null and classEntity.classId !=null and classEntity.classId !=' ' ">  
        AND ST.CLASS_ID = #{classEntity.classId, jdbcType=VARCHAR}  
    </if>  
    <if test="placeId != null and placeId != '' ">  
        AND ST.PLACE_ID = #{placeId, jdbcType=VARCHAR}  
    </if>  
    <if test="placeEntity != null and placeEntity.placeId != null and placeEntity.placeId != '' ">  
        AND ST.PLACE_ID = #{placeEntity.placeId, jdbcType=VARCHAR}  
    </if>  
    <if test="studentId != null and studentId != '' ">  
        AND ST.STUDENT_ID = #{studentId, jdbcType=VARCHAR}  
    </if>   
</select>  
```

通过if标签实现



## Mybatis实现一对多的查询

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.djp.config.mapper.OrdersCustomMapper">
    <!--订单查询关联用户和订单明细的信息的resultMap-->
    <resultMap id="orderAndOrderDetailResultMap" type="orders" extends="ordersUserResultMap">
        <!--配置订单信息 使用继承下面的-->
        <!--配置订单关联的用户信息 使用继承下面的-->
         <!--配置订单关联的订单明细信息
             一条订单关联查询出了多条明细，要使用collection进行映射
             collection :对关联查询到多条记录映射到集合中
             property：将关联查询到的多条记录映射到com.djp.pojo.Orders中的哪个属性
             ofType:指定映射到list集合属性中的pojo的类型
         -->
        <collection property="ordersDetails" ofType="OrdersDetail">
            <!--
                id:订单明细的唯一标示
                property:将订单明细的唯一标示映射到com.djp.pojo.OrdersDetail中的哪个属性
            -->
            <id column="orderdetail_id" property="id"/>
            <result column="orderid" property="orderId"/>
            <result column="itemsid" property="itemsId"/>
        </collection>
    </resultMap>
    <!--查询订单明细关联查询用户信息和订单明细信息的statement-->
    <select id="findOrderAndOrderDetailResultMap" resultMap="orderAndOrderDetailResultMap">
    select
     orders.*,
     t_user.address,
     t_user.name,
     t_user.brithday,
     orderdetail.id orderdetail_id,
     orderdetail.orderid,
     orderdetail.itemsid
      from
      orders,
      t_user,
      orderdetail
      where
      orders.userid=t_user.id AND orderdetail.orderid=orders.id
    </select>
    <!--订单查询关联用户的resultMap
        将整个查询结果映射到com.djp.pojo.Orders中
    -->
    <resultMap id="ordersUserResultMap" type="com.djp.pojo.Orders">
        <!--配置映射的订单信息
            result：普通列
            id:指定查询列中的唯一标示，订单信息中的唯一标示，如果有多个列组成多个唯一标示，配置多个id
            column：订单信息的唯一标示
            property：订单信息的唯一标示，列所映射到Orders中的哪个属性
        -->
        <id column="id" property="id"/>
        <result column="note" property="note"/>
        <result column="dateTime" property="dateTime"/>
        <result column="number" property="number"/>
        <result column="userId" property="userId"/>
        <!--配置订单关联的用户信息
            association：用于映射关联查询单个用户的信息
            property：将要关联查询的用户信息映射到orders中的哪个属性
            javaType：指定的类型，可以使用别名
        -->
        <association property="user" javaType="user">
            <!--
                id :关联查询用户的唯一标示
               column:指定表示用户信息的列
               property：对应user.java中的哪个属性
            -->
            <id column="id" property="id"/>
            <result column="name" property="name"/>
            <result column="pwd" property="pwd"/>
            <result column="address" property="address"/>
            <result column="brithday" property="brithday"/>
        </association>
    </resultMap>
    <!-- 查询订单关联查询用户信息 使用resultMap-->
    <select id="findOrderUserResultMap" resultMap="ordersUserResultMap">
select orders.*,t_user.address,t_user.name,t_user.brithday from orders, t_user where orders.userid=t_user.id
    </select>
    <!--查询订单关联查询用户信息-->
    <select id="findOrderUser" resultType="OrdersCustom">
select orders.*,t_user.address,t_user.name,t_user.brithday from orders, t_user where orders.userid=t_user.id
    </select>
</mapper>

作者：西安公交巴士
链接：https://www.jianshu.com/p/42dc7598eb70
来源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
```





