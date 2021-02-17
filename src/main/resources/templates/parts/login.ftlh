<#include "security.ftlh">
<#macro login path>
    <div class="sidenav">
        <div class="login-main-text">
            <h2>Delivery<br> Login Page</h2>
            <p>Login or register from here to access.</p>
        </div>
    </div>
    <div class="main">
        <div class="col-md-6 col-sm-12">
            <div class="login-form">
                <form action="${path}" method="post">
                    <div class="form-group">
                        <label>User Name</label>
                        <input type="text" class="form-control" name="username" placeholder="User Name">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <#if path == "/login">
                    <button type="submit" class="btn btn-black">Login</button>
                        <#else>
                    <button type="submit" class="btn btn-black">Register</button>
                    </#if>
                </form>
            </div>
        </div>
    </div>
</#macro>

<#macro logout>
    <#if isAdmin>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-success">Sign out</button>
    </form>
    </#if>
</#macro>
