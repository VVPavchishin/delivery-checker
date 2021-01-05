<#import "parts/common.ftlh" as co>
<@co.page>
    <div class="container-fluid" style="margin-top: 6.5rem">
    <div class="row">
        <div class="col">
            <#list filesTu as tFile>
                <div class="card text-right mb-3 ml-5" style="width: 45rem; height: 18rem;">
                    <div id="card-body" class="card-body text-white bg-dark">
                        <h5 class="card-title text-left">${tFile.fileTuName}</h5>
                        <hr style="color: aliceblue">
                        <p class="card-text"><h4>${tFile.fileTuPrice?string(",##0.00;; roundingMode=halfEven")} UAN</h4>
                        <p class="card-text">${tFile.getFileTuDate()?date}</p>
                        <p class="card-text">${tFile.status}</p>
                        <a href="#" class="btn btn-primary">Show</a>
                    </div>
                </div>
            </#list>
        </div>
        <div class="col">
            <#list filesTu as tFile>
                <div class="container mb-3 ml-10" style="width: 45rem; height: 18rem;">
                    <#list tFile.getGdnFiles() as gf>
                    <div class="card">
                        <div id="card-body" class="card-body mb-2 text-white bg-dark">
                            <h6 class="card-title text-left" style="font-weight:bold;">${gf.getFileGdnName()}</h6>
                            <form class="form-horizontal custom-form" role="form">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="col-md-6">
                                                    <a class="card-text" style="font-weight:bold;">${gf.fileGdnPrice?string(",##0.00;; roundingMode=halfEven")} UAN</a>
                                            </div>
                                            <div class="col-md-6">
                                                    <a class="card-text">${gf.fileGdnDate?date}</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    </#list>
                </div>
            </#list>
        </div>
    </div>
</@co.page>