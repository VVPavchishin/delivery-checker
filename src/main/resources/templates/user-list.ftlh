<#import "parts/common.ftlh" as co>
<#import "parts/leftside.ftlh" as ls>
<#assign count = 1>
<@co.page>
    <div class="row p-0 m-0">
        <@ls.leftside/>
        <div class="col mr-4">
            <p class="font-weight-bold" style="font-size: 45px; color: forestgreen">List of users</p>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">User name</th>
                    <th scope="col">User role</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <#list users as user>
                    <tr>
                        <td>
                            <div style="width: 1rem; font-size: 20px; font-weight: bold;">
                                ${count}
                                <#assign count = count + 1>
                            </div>
                        </td>
                        <td>
                            <div style="width: 12rem; font-size: 20px;">
                                ${user.username}
                            </div>
                        </td>
                        <td>
                            <div style="width: 13rem; font-size: 18px;">
                                <#list user.roles as role>${role}<#sep>, </#list>
                            </div>
                        </td>
                        <td>
                            <div class="row p-0 m-0">
                                <div class="col">
                                    <a class="btn btn-primary" href="/delivery/user/edit/${user.id}">Edit user</a>
                                </div>
                                <div class="col ml-5">
                                    <form method="post" action="/delivery/user/delete">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <button class="btn btn-danger" name="userId" value="${user.id}" type="submit">Delete user</button>
                                    </form>
                                </div>
                            </div>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@co.page>