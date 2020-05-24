<#import "parts/common.ftlh" as c>
<@c.page>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">File name</th>
            <th scope="col">File date</th>
            <th scope="col">Total price</th>
        </tr>
        </thead>
        <tbody>
        <#assign x = 0>
        <#list files as file>
            <#assign x++>
        <tr>
            <th scope="row">${x}</th>
            <td>${file.fileTuName}</td>
            <td>${file.fileTuDate}</td>
            <td>${file.fileTuPrice}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</@c.page>