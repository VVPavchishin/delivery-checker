<#import "parts/common.ftlh" as co>
<@co.page>
    <div class="container-fluid " style="margin-top: 6.5rem">
        <div class="row">
            <div class="col-2">
                <div id="sdn" class="sidenav bg-dark" style="margin-top: 4rem">
                    <a href="#about">About</a>
                    <a href="#services">Services</a>
                    <a href="#clients">Clients</a>
                    <a href="#contact">Contact</a>
                </div>
            </div>
            <div class="col-5">
                <#list filesTu as tFile>
                    <div class="card text-right mb-3 ml-5" style="width: 40rem; height: 18rem;">
                        <div id="card-body" class="card-body text-white bg-dark">
                            <h5 class="card-title text-left">${tFile.fileTuName}</h5>
                            <hr style="color: aliceblue">
                            <p class="card-text"><h4>${tFile.fileTuPrice?string(",##0.00;; roundingMode=halfEven")} UAN</h4>
                            <p class="card-text">${tFile.getFileTuDate()?date}</p>
                            <p class="card-text">${tFile.status}</p>
                            <form action="/show/${tFile.id}" method="get">
                                <a class="btn btn-primary" data-toggle="modal"
                                    data-name="${tFile.fileTuName}" data-target="#modalShow">Show</a>
                            </form>
                        </div>
                    </div>
                </#list>
            </div>
            <div class="col-5">
                <#list filesTu as tFile>
                    <div class="container mb-3 ml-10" style="width: 40rem; height: 18rem;">
                        <#list tFile.getGdnFiles() as gf>
                            <div class="card">
                                <div id="card-body" class="card-body mb-2 text-white bg-dark">
                                    <div class="row">
                                        <div class="col-6 col-md-4" style="font-weight:bold;">${gf.getFileGdnName()}</div>
                                        <div class="col-6 col-md-4">${gf.fileGdnDate?date}</div>
                                        <div class="col-6 col-md-4" style="font-weight:bold; text-align: right">${gf.fileGdnPrice?string(",##0.00;; roundingMode=halfEven")} UAN</div>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</@co.page>