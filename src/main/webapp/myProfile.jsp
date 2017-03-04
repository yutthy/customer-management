<%@ include file="template/header.jsp" %>

<link rel="stylesheet" href="css/myProfile.css" />

<div class="container">


    <div class="container">
        <div class="row">
            <div class="col-md-5  toppad  pull-right col-md-offset-3 ">

                <a href="/logout" >Logout</a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title"><%= session.getAttribute("email") %></h3>
                    </div>
                    <div class="panel-body">
                        <form>
                        <div class="row">
                            <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="upload/<%= session.getAttribute("urlPhoto") %>" class="img-circle img-responsive photo"> </div>

                            <div class=" col-md-9 col-lg-9 ">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>ID:</td>
                                        <td><%= session.getAttribute("id") %></td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td><%= session.getAttribute("email") %></td>
                                    </tr>
                                    <tr>
                                        <td>Created Date:</td>
                                        <td><%= session.getAttribute("createdDate") %></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <input type="file" id="file" name="file" size="50" />
                                <input type="button" class="btn btn-primary pull-right upload" value="Upload Image">
                            </div>
                        </div>
                        </form>
                    </div>
                    <div class="panel-footer">
                        <div class="message" id="message"></div>
                        <!--<a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>-->
                    </div>

                </div>
            </div>
        </div>
    </div>



</div> <!-- /container -->


<script>

    $(function(){
        $('.upload').on('click', function(){
            var files = $('#file')[0].files[0];
            var data_string = {
                files			: files
            }
            var formData = new FormData();
            for (var key in data_string) {
                formData.append(key, data_string[key]);
            }

            $.ajax({
                url: '/upload',
                type: 'POST',
                dataType: 'JSON',
                data: formData,
                enctype: 'multipart/form-data',
                processData: false,  // tell jQuery not to process the data
                contentType: false,
                success: function (r) {
                    $('#message').html('');

                    if(r.uploadState){
                        $('.photo').prop('src', 'upload/'+r.msg);
                    }else{
                        $('#message').html('<div class="alert alert-danger">  <strong>' + r.msg + '</strong></a></div>');
                    }
                }
            });
        })
    })

</script>

<%@ include file="template/footer.jsp" %>
