# 组装Dao(基于实现)

## 创建Dao接口

![è¿éåå¾çæè¿°](https://img-blog.csdn.net/20160424182703802)



## 利用sqlSession实现接口

![è¿éåå¾çæè¿°](https://img-blog.csdn.net/20160424182727630)

SqlSession sqlsession = sqlsessionFactory.openSession();

User user = sqlsession.selectOne("test.findUserById",id);

sqlSession.commit();

sqlSession.close();

return user;



## 使用Dao工具类的便捷函数

![è¿éåå¾çæè¿°](https://img-blog.csdn.net/20160424183012121)

