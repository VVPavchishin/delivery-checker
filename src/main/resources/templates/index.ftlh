<#import "parts/common.ftlh" as co>
<@co.page>
    <div class="container-fluid" style="margin-top: 6.5rem">
    <div class="row">
        <div class="col">
            <#list filesTu as tFile>
                <div class="card text-right mb-3 ml-3" style="width: 40rem; height: 15rem;">
                    <div id="card-body" class="card-body text-white bg-dark">
                        <h5 class="card-title text-left">${tFile.fileTuName}</h5>
                        <hr style="color: aliceblue">
                        <p class="card-text"><h4>${tFile.fileTuPrice} UAN</h4>
                        <p class="card-text">${tFile.fileTuDate}</p>
                        <p class="card-text">${tFile.status}</p>
                        <a href="#" class="btn btn-primary">Show</a>
                    </div>
                </div>
            </#list>
        </div>
        <div class="col">
            <#list filesTu as tFile>
                <div class="card mb-3" style="width: 40rem; height: 15rem;">
                    <#list tFile.getGdnFiles() as gf>
                        <div class="alert alert-dark" role="alert">
                            ${gf.getFileGdnName()} <<< ${gf.fileGdnDate} >>> ${gf.fileGdnPrice}UAN
                        </div>
                    </#list>
                </div>
            </#list>
        </div>
    </div>
</@co.page>