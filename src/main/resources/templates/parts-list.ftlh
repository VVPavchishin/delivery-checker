<#import "parts/common.ftlh" as co>
<#assign count = 1>

<@co.page>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 fixed-top one">
                <div class="container-fluid">
                    <div id="card_list_parts" class="card">
                        <div id="card-body" class="card-body text-white bg-dark">
                            <h5 class="card-title text-left">${tuFile.fileTuName}</h5>
                            <hr>
                            <p class="card-text"><h5>${tuFile.fileTuPrice?string(",##0.00;; roundingMode=halfEven")} UAN</h5>
                            <p class="card-text">${tuFile.getFileTuDate()?datetime?string('dd-MM-yyyy')}</p>
                            <p class="card-text">${tuFile.status}</p>
                        </div>
                    </div>
                </div>
                <div class="container-fluid" style="margin-top: 10rem">
                    <#list gdnFiles as gFile>
                        <div class="card">
                            <div id="card-body" class="card-body mb-2 text-white bg-dark">
                                <div class="row">
                                    <div class="col-6 col-md-4" style="font-size: 12px">${gFile.getFileGdnName()}</div>
                                    <div class="col-6 col-md-3" style="font-size: 10px">${gFile.fileGdnDate?datetime?string('dd-MM-yyyy')}</div>
                                    <div class="col-6 col-md-5" style="font-size: 12px">${gFile.fileGdnPrice?string(",##0.00;; roundingMode=halfEven")} UAN</div>
                                </div>
                            </div>
                        </div>
                    <#else>
                    </#list>
                </div>

            </div>
            <div id="table-parts" class="col-md-9 mb-5 offset-md-3 two">
                <table class="table">
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
                    <#list parts as part>
                        <tr>
                            <td class="table_body">
                                ${count}
                                <#assign count = count + 1>
                            </td>
                            <td class="table_body">${part.partTuCode}</td>
                            <td class="table_body">${part.partTuName}</td>
                            <td class="table_body">${part.partTuQuantity}</td>
                            <td class="table_body">${part.partTuPrice?string(",##0.00;; roundingMode=halfEven")} UAN</td>
                            <td class="table_body">${(part.partTuQuantity * part.partTuPrice)?string(",##0.00;; roundingMode=halfEven")} UAN</td>
                            <td class="table_body">${part.partTuDos}</td>
                            <td class="table_body">${part.partTuStatus}</td>
                        </tr>
                    <#else>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <div class="container-fluid fixed-bottom" style="margin-bottom: 5rem">
        <div class="row">
            <div class="col text-right">
                <form class="form" method="post" enctype="multipart/form-data" action="/back">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-lg btn-success"
                            name="back" type="submit">RETURN</button>
                </form>
            </div>
        </div>
    </div>
</@co.page>