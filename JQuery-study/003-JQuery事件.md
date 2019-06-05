# JQuery事件

## 基本形式

```java
<script type="text/javascript">
$(document).ready(function(){
  $("button").click(function(){
    $("p").hide();
  });
});
</script>
```

   属性是对元素的补充说明与选择



## JQuery常用方法

+ $(document).ready(function) : 当DOM再次加载时执行
+ $(selector).click(function) : 当某个元素被点击时执行
+ $(selector).dblclick(function) : 当某个元素被双击时执行
+ $(selector).focus(function) : 当聚焦于输入框时执行
+ $(selector).mouseover(function) : 当鼠标移动到元素上时执行