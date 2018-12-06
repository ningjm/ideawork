<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="/js/vue.js"></script>
</head>
<body>
我是一个页面：获得freemarker数据为：
<div>
    <#--assign标签只能接收字符串，不能接收对象和集合-->
    <#assign aa='${aa}'><#--此时模板中的变量的名称和模型中的变量名称一致，不是覆盖，而是隐藏-->
    <p>${aa}</p>
    <#list  users as user><#--循环迭代-->
        <#--<#if (p.name != 'jj')>-->   <#--if判断-->
             <#--<div>-->
                 <#--${p.name}-->
             <#--</div>-->
        <#--</#if>-->

        <#if user?? && user.name??> <#--判断null--><#--如果要判断空字符串用：name != ''-->
            <p>${user.name}</p>     <#--不为null-->
        <#else>
            <p>我是空对象或者空属性2</p><#--为null-->
        </#if>
    </#list>
    <!--此种注释在浏览器可以看见-->
    <#--此种注释属于freemarker的注释，在浏览器不可见-->
</div>
</body>
</html>