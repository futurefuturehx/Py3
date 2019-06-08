# 组装Dao（基于XML)

1，在UserMapper.xml文件中namespace等于UserMapper接口地址 

![è¿éåå¾çæè¿°](https://img-blog.csdn.net/20160424205422345)

2，UserMapper.java接口中的方法名要和UserMapper.xml中的statement的id一致 
3，UserMapper.java接口中的方法输入参数要和UserMapper.xml中的statement的parameterType指定的类型一致

4，UserMapper.java接口中的方法的返回值类型要和UserMapper.xml中的statement的resultType指定的类型一致 



## 测试代码

![è¿éåå¾çæè¿°](https://img-blog.csdn.net/20160424210552661)

通过主配置文件build sqlSessionFactory

openSession getMapper



## 基于实现相对于基于XML的问题

![è¿éåå¾çæè¿°](https://img-blog.csdn.net/20160424183158685)