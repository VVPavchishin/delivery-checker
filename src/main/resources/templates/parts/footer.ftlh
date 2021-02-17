<#include "security.ftlh">
<footer class="bg-light text-center bg-dark fixed-bottom text-lg-start">
    <div class="container-fluid fixed-bottom" style="margin-bottom: 5rem">
        <div class="row">
            <div class="col text-right">
                <#if isAdmin>
                <form class="form" method="post" enctype="multipart/form-data" action="index/refresh">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="tn btn-lg btn-success"
                            name="refresh" type="submit">REFRESH</button>
                </form>
                </#if>
            </div>
        </div>
    </div>
    <div class="text-center p-3 text-white">
        © 2021 Email:
        <a class="text-white" href="https://mail.google.com">pavchishin.v@gmail.com</a>
    </div>
</footer>