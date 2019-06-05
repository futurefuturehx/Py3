# AJAX

## load方法

### 简单使用

```java
$(document).ready(function(){
  $("#btn1").click(function(){
    $('#test').load('/example/jquery/demo_test.txt');
  })
})
```

从外部加载内容并覆盖元素原有内容



### 信息返回

```java
$(document).ready(function(){
  $("button").click(function(){
    $("#div1").load("/example/jquery/demo_test.txt",function(responseTxt,statusTxt,xhr){
      if(statusTxt=="success")
        alert("外部内容加载成功！");
      if(statusTxt=="error")
        alert("Error: "+xhr.status+": "+xhr.statusText);
    });
  });
});
```

load方法使用之后会自动产生statusTxt 根据判断statusTxt的值返回不同的信息



## GET与POST

get用于请求数据 会有数据缓存

post主要用于处理数据

 

### GET

```java
$.get(URL,data,function(data,status,xhr),dataType)
```

URL--请求地址

data--传入的数据

function.data--传回的数据

status--请求的状态

xhr--XMLHttpRequest 对象

dataType--规定预期返回对象，如xml json等