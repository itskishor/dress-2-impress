<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Dress 2 Impress</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav justify-content-center">
             <li id="viewclothes">
              <a class="nav-link" href="${contextRoot}/show/all/clothes">View Clothes</a>
            </li>
            <li id="manageclothes">
              <a class="nav-link" href="${contextRoot}/manage/clothes">Manage Clothes</a>
            </li>
          </ul>
          <ul class="navbar-nav ml-auto">
          <li id="admin">                                               <!-- class="nav-item" -->
              <a class="nav-link" href="${contextRoot}/admin">Admin</a>
            </li>
             <li id="employee">
              <a class="nav-link" href="${contextRoot}/employee">Employee</a>
            </li>
             <li id="supplier">
              <a class="nav-link" href="${contextRoot}/supplier">Supplier</a>
            </li>
            <li id="signin">
              <a class="nav-link" href="${contextRoot}/signin">Sign In</a>
            </li>
           <li id="cart" class="nav-item">
              <a class="nav-link" href="${contextRoot}/cart">
			  <button style="font-size:12px">Cart <i class="fa fa-shopping-cart"></i></button></a>
            </li>
          </ul>
        </div> 
      </div>
    </nav>