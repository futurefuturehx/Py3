# callBack与chaining

## callBack

```java
$(document).ready(function(){
  $("button").click(function(){
  $("p").hide(1000,function(){
    alert("The paragraph is now hidden");
    });
  });
});
```

操作之后返回信息 如上 返回信息写在大括号中



## chaining

```java
$(document).ready(function()
  {
  $("button").click(function(){
    $("#p1").css("color","red").slideUp(2000).slideDown(2000);
  });
});	
```

可以用点号进行连续操作