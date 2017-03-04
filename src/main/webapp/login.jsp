<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/login.css" />

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>

<div class="container">

    <form class="form-signin">

        <div class="message" id="message"></div>

        <h4 class="form-signin-heading">Please sign in</h4>
        <hr/>
        <label for="email" class="sr-only">Username</label>
        <input type="text" id="email" class="form-control email" name="email" placeholder="Email" autofocus value="admin@gmail.com">
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control password" name="password" placeholder="Password" value="admin@gmail.com">

        <button class="btn btn-primary btn-block" type="button" id="sign-in">Sign in</button>
    </form>
</div> <!-- /container -->


<script>

    $(function(){
        $('#sign-in').on('click', function(){
            var email = $('#email').val();
            var password = $('#password').val();

            $("#message").html("");

            $.post("/login", {email : email, password : password}, function(r){
                if(r.isLogin) {
                    //$('#message').html('<div class="alert alert-success"> <strong>Login Success!</strong></a></div>');
                    window.location = '/customerLists.jsp';
                }
                else  $('#message').html('<div class="alert alert-danger">  <strong>Login Fail!</strong></a></div>');
            }, "JSON");
        })

    })

</script>


<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
