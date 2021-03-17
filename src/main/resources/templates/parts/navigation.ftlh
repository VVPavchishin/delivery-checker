<#include "security.ftlh">
<#import "login.ftlh" as lo>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top mb-3">
    <a class="navbar-brand" href="/delivery"><img src="images/logo.png" alt="logo" style="height: 50px; width: 150px"></a>
    <button class="navbar-toggler" type="button" data-toggle="dropdown"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto"></ul>
        <#if isAdmin>
            <form class="form-inline my-2 my-lg-0" method="get" action="/index">
                <input class="form-control mr-sm-2" type="search" name="filter" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </#if>
        <#if name == "Registration">
            <a class="navbar-text" href="/registration" id="uname">${name}</a>
        <#else>
            <div class="navbar-text" id="uname">${name}</div>
        </#if>
        <@lo.logout/>
    </div>
</nav>
<footer class="bg-light text-center bg-dark fixed-bottom text-lg-start">
    <div class="text-center p-3 text-white">
        © 2021 Email:
        <a class="text-white" href="https://mail.google.com">pavchishin.v@gmail.com</a>
    </div>
</footer>