<#import "parts/common.ftlh" as co>

<@co.page>
    <div class="container" style="margin-top: 5.5rem; margin-right: 10rem;">
        <h2>User editor</h2>
        <form action="/delivery/user/edit" method="post">
            <div class="col-auto">
                <label>Name</label>
                <input type="text" name="username" value="${user.username}">
            </div>
            <div class="col-auto">
                <#list roles as role>
                    <div class="form-check mb-2">
                        <label>
                            <input type="checkbox" class="form-check-inline" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>
                            ${role}
                        </label>
                    </div>
                </#list>
            </div>
            <div class="col-auto">
                <input type="hidden" name="userId" value="${user.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary mb-2">Save</button>
            </div>
        </form>
    </div>
</@co.page>