# JQuery动画

## 前提

默认情况下 元素是无法移动的 需要移动 首先将元素的CSS属性设置为relative fixed 或 absolute



## 举例

```java
$(document).ready(function(){
  $("button").click(function(){
    $("div").animate({left:'250px'});
  });
});</script> 
```

几乎可以使用animate操作任何属性 且可以同时操作多个属性



## 特色举例

### 操作多个属性

```java
$("button").click(function(){
  $("div").animate({
    left:'250px',
    opacity:'0.5',
    height:'150px',
    width:'150px'
  });
}); 
```



### 使用预定义值

```java
$("button").click(function(){
  $("div").animate({
    height:'toggle'
  });
});
```



### 按照队列顺序操作

```java
$("button").click(function(){
  var div=$("div");
  div.animate({height:'300px',opacity:'0.4'},"slow");
  div.animate({width:'300px',opacity:'0.8'},"slow");
  div.animate({height:'100px',opacity:'0.4'},"slow");
  div.animate({width:'100px',opacity:'0.8'},"slow");
});
```



## 停止动画

```java
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideDown(5000);
  });
  $("#stop").click(function(){
    $("#panel").stop();
  });
});
```

