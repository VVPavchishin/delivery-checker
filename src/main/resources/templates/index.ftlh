<#import "parts/common.ftlh" as co>
<#import "parts/leftside.ftlh" as ls>
<@co.page>
    <div class="container-fluid " style="margin-top: 6.5rem">
        <div class="row">
            <@ls.leftside/>
            <div class="col-md-5">
                <#list filesTu as tFile>
                    <div class="card text-right mb-3 ml-5" style="width: auto; height: 18rem;">
                        <div id="card-body" class="card-body text-white bg-dark">
                            <h5 class="card-title text-left">${tFile.fileTuName}</h5>
                            <hr style="color: aliceblue">
                            <p class="card-text"><h4>${tFile.fileTuPrice?string(",##0.00;; roundingMode=halfEven")} UAN</h4>
                            <p class="card-text">${tFile.getFileTuDate()?datetime?string('dd-MM-yyyy')}</p>
                            <p class="card-text">${tFile.status}</p>
                            <form action="/parts" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button class="btn btn-primary" name="tuName" value="${tFile.fileTuName}">Show</button>
                            </form>
                        </div>
                    </div>
                <#else>
                </#list>
            </div>
            <div class="col-md-5">
                <#list filesTu as tFile>
                    <div class="container mb-3 ml-10" style="width: auto; height: 18rem;">
                        <#list tFile.getGdnFiles() as gf>
                            <div class="card">
                                <div id="card-body" class="card-body mb-2 text-white bg-dark">
                                    <div class="row">
                                        <div class="col-6 col-md-4" style="font-weight:bold;">${gf.getFileGdnName()}</div>
                                        <div class="col-6 col-md-4">${gf.fileGdnDate?datetime?string('dd-MM-yyyy')}</div>
                                        <div class="col-6 col-md-4" style="font-weight:bold; text-align: right">${gf.fileGdnPrice?string(",##0.00;; roundingMode=halfEven")} UAN</div>
                                    </div>
                                </div>
                            </div>
                        <#else>
                        </#list>
                    </div>
                <#else>
                </#list>
            </div>
        </div>
    </div>
    <div class="container-fluid fixed-bottom" style="margin-bottom: 5rem">
        <div class="row">
            <div class="col text-right">
                <form class="form" method="post" enctype="multipart/form-data" action="index/refresh">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="tn btn-lg btn-success"
                            name="refresh" type="submit">REFRESH</button>
                </form>
            </div>
        </div>
    </div>
</@co.page>