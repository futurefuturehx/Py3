# JQuery选择器

## 元素选择器 

+ $("p")选取<p>元素
+ $("p.intro")选取所有class为intro的<p>元素
+ $("p # demo")选取所有id为demo的<p>元素T

   $\textcolor{red}{T:批量选择元素}$  $\textcolor{red}{整体做出修改}$



## 属性选择器

+ $("[href]") 选取所有带有 href 属性的元素
+ $("[href='#']") 选取所有带有 href 值等于 "#" 的元素
+ $("[href!='#']") 选取所有带有 href 值不等于 "#" 的元素
+ $("[href$='.jpg']") 选取所有 href 值以 ".jpg" 结尾的元素

   $\textcolor{red}{T:属性是对元素的补充说明与选择}$

   如 <body bgcolor="red"> 中 bgcolor是属性 red是属性值



## CSS选择器

将所有p元素的背景颜色改为红色

```java
$("p").css("background-color","red");
```

   $\textcolor{red}{T:选择之后再进行选择操作}$

