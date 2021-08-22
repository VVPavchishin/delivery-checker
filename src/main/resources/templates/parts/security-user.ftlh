<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>
<#if know>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    isMyUser = user.isMyUser()
    >
<#else>
    <#assign
    isMyUser = false
    >
</#if>