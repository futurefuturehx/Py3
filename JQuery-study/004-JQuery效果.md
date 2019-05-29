# JQuery效果

## 隐藏与显示

```html
<script type="text/javascript">
$(document).ready(function(){
  $("#hide").click(function(){
  $("p").hide();
  });
  $("#show").click(function(){
  $("p").show();
  });
});
</script>
```

```html
<button id="hide" type="button">隐藏</button>
<button id="show" type="button">显示</button>
```

对于对应id执行对应操作 操作某个元素 产生某种效果



## 淡入淡出

fadeIn()用于淡入已隐藏的元素

```html
$(selector).fadeIn(speed,callback);
```

有三种淡入速度控制方式

```html
$("#div1").fadeIn();
```

瞬间淡入

```html
$("#div2").fadeIn("slow");
```

缓慢淡入

```html
$("#div3").fadeIn(3000);
```

3000毫秒淡入



fadeOut()用于淡出可见元素

```html
$(selector).fadeOut(speed,callback);
```

也有三种淡出速度控制方式

```html
$("#div1").fadeOut();
```

瞬间淡出

```html
$("#div2").fadeOut("slow");
```

缓慢淡出

```html
$("#div3").fadeOut(3000);
```

3000毫秒淡出



## Class

class是指一类 id是指一个 class大于id



## 滑动

slideDown() slideUp()用于上下滑动 类似于fadeIn()的使用方式

slideToggle() 如果元素向下滑动 则表示向上滑动

​                       如果元素向上滑动 则表示向下滑动

而滑动的意思即某个元素的展开与收缩

```java
<script type="text/javascript"> 
$(document).ready(function(){
$(".flip").click(function(){
    $(".panel").slideToggle("slow");
  });
});
</script>
```

```java
<div class="panel">
<pW3School，你可以找到你所需要的所有网站建设教程。</p>W3School - 领先的 Web 技术教程站点</p>
<p>在 >
</div>
 
<p class="flip">请点击这里</p>
```

点击flip类 对panel类进行收缩