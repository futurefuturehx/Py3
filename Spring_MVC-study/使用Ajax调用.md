# 使用Ajax调用

## 后端

```java
 //pass the parameters to front-end using ajax
    @RequestMapping("/getPerson")
    public void getPerson(String name,PrintWriter pw){
        pw.write("hello,"+name);        
    }
    @RequestMapping("/name")
    public String sayHello(){
        return "name";
    }
```



## 前端

```js
$(function(){
              $("#btn").click(function(){
                  $.post("mvc/getPerson",{name:$("#name").val()},function(data){
                      alert(data);
                  });
              });
          });
```

