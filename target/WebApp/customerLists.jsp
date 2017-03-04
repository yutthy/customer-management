<%@ include file="template/header.jsp" %>


<div class="container">
    <center>
        <h2>Customer Management</h2>
    </center>

    <div class="container">
        <div class="row">
            <button class="btn btn-primary add" id="add">Add</button>
            <button class="btn btn-success edit" id="edit">Edit</button>
            <button class="btn btn-danger delete" id="delete">Delete</button>
        </div>
        <div class="row">
            <table id="table-customer"
                   data-toggle="table"
                   data-toolbar="#get"
                   data-url="/getCustomers"
                   data-search="true"
                   data-pagination="true"
                   data-side-pagination="server"
                   data-page-list="[20,50,100]"
                   data-pagination="true"
                   data-height="500"
                   data-sort-order="desc"
            >
                <thead>
                <tr>
                    <th data-field="status" data-checkbox="true"></th>
                    <th data-field="id">ID</th>
                    <th data-field="firstName">First Name</th>
                    <th data-field="lastName">Last Name</th>
                    <th data-field="gender">Gender</th>
                    <th data-field="dob">Date of Birth</th>
                    <th data-field="email">Email</th>
                    <th data-field="address">Address</th>
                    <th data-field="phone">Phone</th>
                    <th data-field="createdDate">Created Date</th>
                    <th data-field="modifiedDate">Modified Date</th>

                </tr>
                </thead>
            </table>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Customer Information</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="first-name">First Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control first-name" id="first-name" placeholder="Enter First Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="last-name">Last Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control last-name" id="last-name" placeholder="Enter Last Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="gender">Gender:</label>
                            <div class="col-sm-10">
                                <select class="form-control gender" id="gender">
                                    <option value="1">Male</option>
                                    <option value="2">Female</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="dob">Date of Birth:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control last-name" id="dob" placeholder="Enter Date of Birth">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="dob">Email:</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control email" id="email" placeholder="Enter Email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="dob">Phone:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control phone" id="phone" placeholder="Enter Phone">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="dob">Address:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control address" id="address"></textarea>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary save">Save</button>
                    <button type="button" class="btn btn-default exit" id="exit">Close</button>
                </div>
            </div>

        </div>
    </div>



</div> <!-- /container -->


<script>

    $(function(){
        $('#save').on('click', function(){

            var id          = $(this).attr('data-id')

            var firstName   = $('#first-name').val();
            var lastNmae    = $('#last-name').val();
            var gender      = $('#gender').val();
            var dob         = $('#dob').val();
            var email       = $('#email').val();
            var address     = $('#address').val();
            var phone       = $('#phone').val();

            if(firstName == '' || lastNmae == '' || gender == '' || dob == '' || email == '' || address == '' || phone == ''){
                $('#message').html('<div class="alert alert-danger">  <strong>All Fields Are Required!</strong></a></div>');
                return;
            }


            if(id) {
               id = id
            }else id = 0;

            $.ajax({
                url     : '/SaveUpdateCustomer',
                type    : 'POST',
                dataType: 'JSON',
                data : {
                    id          : id,
                    firstName   : firstName,
                    lastName    : lastNmae,
                    gender      : gender,
                    dob         : dob,
                    email       : email,
                    address     : address,
                    phone       : phone
                },
                success : function(r){
                    if(r.status){
                        $('#table-customer').bootstrapTable('refresh');
                        $('#message').html('<div class="alert alert-success">  <strong>Save Sucessfull!</strong></a></div>');
                    }else{
                        $('#message').html('<div class="alert alert-danger">  <strong>Save Fail!</strong></a></div>');
                    }
                }
            })
        })

        $('#delete').on('click', function(){
            var arrRow = $.map($('#table-customer').bootstrapTable('getSelections'), function (row) {
                return {id: row.id};
            });
            if (arrRow.length == 1) {
                bootbox.confirm("Do You Want to Delete This?", function (result) {
                    if (result) {

                        $.ajax({
                            url: '/deleteCustomer',
                            type: 'POST',
                            dataType: 'JSON',
                            data: {
                                id: id
                            },
                            success: function (r) {
                                if(r){
                                    $('#message').html('<div class="alert alert-success">  <strong>Delete Sucessfull!</strong></a></div>');
                                }else{
                                    $('#message').html('<div class="alert alert-danger">  <strong>Delete Fail!</strong></a></div>');
                                }
                            }
                        })
                    }
                });
            }else{
                $('#message').html('<div class="alert alert-warning">  <strong>Please Select Only One Row!</strong></a></div>');
            }
        })

        $('#edit').on('click', function(){
            var arrID = $.map($('#table-customer').bootstrapTable('getSelections'), function (row) {
                return row.id;
            });

            if(arrID.length == 1){
                $.ajax({
                    url     : '/getCustomerByID',
                    type    : 'POST',
                    dataType: 'JSON',
                    data    : {
                        id  : arrID
                    },
                    success : function(r){
                        if(r.length > 0){
                            clear();

                            $('#save').attr('data-id', r.id);
                            $('#first-name').val(r.firstName);
                            $('#last-name').val(r.lastName);
                            $('#gender').val(r.gender);
                            $('#dob').val(r.dob);
                            $('#email').val(r.email);
                            $('#address').val(r.address);
                            $('#phone').val(r.phone);
                        }
                    }

                })


                $('#myModal').modal('show');
            }else{
                $('#message').html('<div class="alert alert-warning">  <strong>Please Select Only One Row!</strong></a></div>');
            }
        })

        $('#exit').on('click', function(){
            clear();
            $('#myModal').modal('hide');
        })

        $('#add').on('click', function (){
            clear();
            $('#myModal').modal('show');
        })



    })

    function clear(){
        $('#save').removeAttr('data-id');
        $('#first-name').val("");
        $('#last-name').val("");
        $('#gender').val(1);
        $('#dob').val("");
        $('#email').val("");
        $('#address').val("");
        $('#phone').val("");
    }


</script>

<%@ include file="template/footer.jsp" %>
