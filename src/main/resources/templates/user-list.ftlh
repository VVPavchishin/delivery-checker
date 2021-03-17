<#import "parts/common.ftlh" as co>
<#import "parts/leftside.ftlh" as ls>
<#assign count = 1>
<@co.page>
    <div class="container" style="margin-top: 5.5rem;">
        <div class="row">
            <@ls.leftside/>
            <div class="col-md-10">
                <p class="font-weight-bold" style="font-size: 45px; color: forestgreen">List of users</p>
                <table class="table table-striped table-dark">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col" style="text-align: center">#</th>
                        <th scope="col" style="text-align: center">User name</th>
                        <th scope="col" style="text-align: center">User role</th>
                        <th scope="col" style="text-align: center">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list users as user>
                        <tr>
                            <td style="text-align: center">
                                <div style="width: 2rem; font-size: 25px; font-weight: bold;">
                                    ${count}
                                    <#assign count = count + 1>
                                </div>
                            </td>
                            <td style="text-align: center">
                                <div class="badge badge-primary text-wrap" style="width: 12rem; font-size: 20px;">
                                    ${user.username}
                                </div>
                            </td>
                            <td class="align-middle" style="text-align: center">
                                <div class="badge badge-success text-wrap" style="width: 15rem; font-size: 18px;">
                                    <#list user.roles as role>${role}<#sep>, </#list>
                                </div>
                            </td>
                            <td style="text-align: center">
                                <div class="row">
                                    <div class="col-sm-3 ml-5">
                                        <a class="btn btn-primary" href="/user/edit/${user.id}">Edit user</a>
                                    </div>
                                    <div class="col-sm-3 ml-5">
                                        <form method="post" action="user/delete">
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
    </div>
</@co.page>