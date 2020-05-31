<#import "parts/common.ftlh" as co>
<@co.page>
    <div class="container-fluid" style="margin-top: 6.5rem">
        <#assign x = 0>
        <#list files as file>
            <#assign x++>
            <div class="card text-right mb-3 ml-3" style="width: 30rem;">
                <div id="card-body" class="card-body text-white bg-dark">
                    <h5 class="card-title text-left">${file.fileTuName}</h5>
                    <p class="card-text"><h4>${file.fileTuPrice} UAN</h4>
                    <p class="card-text">${file.fileTuDate}</p>
                    <a href="#" class="btn btn-primary">${file.status}</a>
                </div>
            </div>
        </#list>
    </div>
</@co.page>