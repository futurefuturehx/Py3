# JDBC相对于Mybatis的劣势

1，数据库连接，使用时就创建，不使用就释放，**对数据库进行频繁连接开关和关闭，造成数据库资源浪费**，影响数据库的性能 
解决：使用数据库连接池管理数据库的连接 
2，sql语句使用硬编码在java程序中，修改sql语句，就需要重新编译java代码，不利于系统维护 
解决：**把sql语句放在xml配置文件中，修改sql语句也不需要重新编译java代码** 
3，向预编译语句PreparedStatement中设置参数，**对占位符位置和设置参数值，硬编码，修改sql语句也不需要重新编译java代码 **
**解决：把sql语句和占位符设置参数值放在xml配置文件中** 
4，从result中遍历结果集数据时，存在硬编码，将获取表的字段进行硬编码