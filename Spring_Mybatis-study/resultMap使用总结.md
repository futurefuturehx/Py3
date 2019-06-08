# resultMap使用总结

`也就是把字段对应映射到对应的实体属性中`

## 映射属性

### pojo对象

```java
public class TShopSku  {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商品名
     */
    private String skuName;

    /**
     * 分类ID
     */
    private Long categoryId;

   
    /**
     * 主键ID
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID,
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商品名
     * @return SKU_NAME 商品名
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 商品名
     * @param skuName 商品名
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    /**
     * 分类ID
     * @return CATEGORY_ID 分类ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 分类ID
     * @param categoryId 分类ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
```



### 对应的resultMap

```xml
<resultMap id="BaseResultMap" type="com.meikai.shop.entity.TShopSku">
    <id column="ID" jdbcType="BIGINT" property="id" />
    <result column="SKU_NAME" jdbcType="VARCHAR" property="skuName" />
    <result column="CATEGORY_ID" jdbcType="BIGINT" property="categoryId" />
</resultMap> 

```



## 映射属性集合

`通过collection完成属性集合的映射`

### pojo对象

```java
/**
     * 属性集合
     */
    private List<TShopAttribute> attributes;
   
    /**
     * 获得属性集合
     */
    public List<TShopAttribute> getAttributes() {
        return attributes;
    }
    
    /**
     * 设置属性集合
     * @param attributes
     */
     public void setAttributes(List<TShopAttribute> attributes) {
        this.attributes = attributes;
     }

```



### 对应的resultMap

`id result collection ofType`

```xml
<resultMap id="BasePlusResultMap" type="com.meikai.shop.entity.TShopSku">
    <id column="ID" jdbcType="BIGINT" property="id" />
    <result column="SKU_NAME" jdbcType="VARCHAR" property="skuName" />
    <result column="CATEGORY_ID" jdbcType="BIGINT" property="categoryId" />
    <collection property="attributes" ofType="com.meikai.shop.entity.TShopAttribute" > 
        <id column="AttributeID" jdbcType="BIGINT" property="id" />
        <result column="attribute_NAME" jdbcType="VARCHAR" property="attributeName" />
    </collection>
</resultMap>

```



## 级联

Mybatis中的级联分为三种：

　　①鉴别器（discriminator）：

​                           它是一个根据某些条件决定采用具体实现类级联的方案，比如体检表要分性别去区分。

　　②一对一（association）：比如学生证和学生就是一对一的关系，雇员和工牌就是一对一的级联。

　　③一对多（collection）：比如班主任和学生就是一对多的关系。