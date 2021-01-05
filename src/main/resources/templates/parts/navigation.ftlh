
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top mb-3">
    <a class="navbar-brand" href="/">Delivery</a>
    <button class="navbar-toggler" type="button" data-toggle="dropdown" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto"></ul>
        <form class="form-inline" method="post" enctype="multipart/form-data" action="/refresh">
            <button class="btn btn-lg btn-outline-success my-2 my-sm-0" name="refresh" type="submit">REFRESH</button>
        </form>
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle mr-3" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Options
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                    <button class="dropdown-item" type="button">Table</button>
                    <button class="dropdown-item" type="button">Path</button>
                    <button class="dropdown-item" type="button">About</button>
                </div>
            </li>
        </ul>
    </div>
</nav>