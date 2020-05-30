<#import "parts/common.ftlh" as c>
<@c.page>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Or file name</th>
            <th scope="col">File name</th>
            <th scope="col">File date</th>
            <th scope="col">Total price</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>
        <#assign x = 0>
        <#list files as file>
            <#assign x++>
        <tr>
            <th scope="row">${x}</th>
            <td>${file.originalTuName}</td>
            <td>${file.fileTuName}</td>
            <td>${file.fileTuDate}</td>
            <td>${file.fileTuPrice}</td>
            <td>${file.status}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</@c.page>