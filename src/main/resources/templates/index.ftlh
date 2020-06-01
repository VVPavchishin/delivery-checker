<#import "parts/common.ftlh" as co>
<@co.page>
    <div class="container-fluid" style="margin-top: 6.5rem">
        <div class="row">
            <div class="col-6 col-md-4">
                <#list filesTu as tFile>
                    <div class="card text-right mb-3 ml-3" style="width: 30rem;">
                        <div id="card-body" class="card-body text-white bg-dark">
                            <h5 class="card-title text-left">${tFile.fileTuName}</h5>
                            <p class="card-text"><h4>${tFile.fileTuPrice} UAN</h4>
                            <p class="card-text">${tFile.fileTuDate}</p>
                            <a href="#" class="btn btn-primary">${tFile.status}</a>
                        </div>
                    </div>
                </#list>
            </div>
            <div class="col-6 col-md-4">

            </div>
            <div class="col-6 col-md-4">
                <#list filesGdn as gFile>
                    <div class="card text-right mb-3 ml-3" style="width: 30rem;">
                        <div id="card-body" class="card-body text-white bg-dark">
                            <h5 class="card-title text-left">${gFile.fileGdnName}</h5>
                            <p class="card-text"><h4>${gFile.fileGdnPrice} UAN</h4>
                            <p class="card-text">${gFile.fileGdnDate}</p>
                            <a href="#" class="btn btn-primary">${gFile.tuFiles}</a>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</@co.page>