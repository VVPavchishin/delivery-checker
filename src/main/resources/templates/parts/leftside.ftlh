<#include "security.ftlh">
<#macro leftside>
    <div class="col-md-2 p-0">
        <div id="sdn" class="sidenav bg-dark">
            <a href="/delivery/info">Information</a>
            <a href="/delivery/active">Active</a>
            <a href="/delivery/all-parts">Spare parts</a>
            <#if isAdmin>
                <a href="/delivery/user">Users</a>
                <a href="#">Preference</a>
            </#if>

        </div>
    </div>
</#macro>