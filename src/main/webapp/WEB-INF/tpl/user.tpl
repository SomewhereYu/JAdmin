<#include "header.tpl">
<body>
<h2>freemarker</h2>
<#if errorCode?exists >
<div>${errorMsg}</div>
<#else>
<div>${config.title}</div>
<div>${user}</div>
</#if>
</body>
</html>