<#import "parts/common.ftlh" as co>
<#import "parts/leftside.ftlh" as ls>
<#assign count = 1>

<@co.page>
    <div class="row">
        <@ls.leftside/>
        <div class="col-10">
            <table class="table" style="margin-top: 5rem; margin-left: 1rem">
                <thead class="thead-dark">
                <tr>
                    <th class="table_label" scope="col">#</th>
                    <th class="table_label" scope="col">Code</th>
                    <th class="table_label" scope="col">Name</th>
                    <th class="table_label" scope="col">Quantity</th>
                    <th class="table_label" scope="col">Price</th>
                    <th class="table_label" scope="col">Total price</th>
                    <th class="table_label" scope="col">Part DOS</th>
                    <th class="table_label" scope="col">Status</th>
                </tr>
                </thead>
                <tbody>
                <#list expParts as part>
                    <tr>
                        <#if part.partTuStatus == "EXPECTED">
                            <td id="danger" class="table-danger">
                                ${count}
                                <#assign count = count + 1>
                            </td>
                            <td id="danger" class="table-danger">${part.partTuCode}</td>
                            <td id="danger" class="table-danger">${part.partTuName}</td>
                            <td id="danger" class="table-danger">${part.partTuQuantity}</td>
                            <td id="danger" class="table-danger">${part.partTuPrice?string(",##0.00;; roundingMode=halfEven")} UAN</td>
                            <td id="danger" class="table-danger">${(part.partTuQuantity * part.partTuPrice)?string(",##0.00;; roundingMode=halfEven")} UAN</td>
                            <td id="danger" class="table-danger">${part.partTuDos}</td>
                            <td id="danger" class="table-danger">${part.partTuStatus}</td>
                        <#elseif part.partTuStatus == "DELIVERED">
                            <td id="success" class="table-success">
                                ${count}
                                <#assign count = count + 1>
                            </td>
                            <td id="success" class="table-success">${part.partTuCode}</td>
                            <td id="success" class="table-success">${part.partTuName}</td>
                            <td id="success" class="table-success">${part.partTuQuantity}</td>
                            <td id="success" class="table-success">${part.partTuPrice?string(",##0.00;; roundingMode=halfEven")} UAN</td>
                            <td id="success" class="table-success">${(part.partTuQuantity * part.partTuPrice)?string(",##0.00;; roundingMode=halfEven")} UAN</td>
                            <td id="success" class="table-success">${part.partTuDos}</td>
                            <td id="success" class="table-success">${part.partTuStatus}</td>
                        </#if>

                    </tr>
                <#else>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@co.page>