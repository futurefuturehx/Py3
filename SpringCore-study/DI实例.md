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





​                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    