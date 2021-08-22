<#import "parts/common.ftlh" as co>
<#import "parts/leftside.ftlh" as ls>

<@co.page>
    <div class="row">
        <@ls.leftside/>
        <form class="mt-5" action="/delivery/user/edit" method="post">
            <h2 class="font-weight-bold" style="font-size: 45px; color: forestgreen">User editor</h2>
            <div class="col-auto">
                <label class="mr-4">Name</label>
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