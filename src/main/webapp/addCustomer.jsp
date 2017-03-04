<%@ include file="template/header.jsp" %>


<div class="container">
    <center>
        <h2>Customer Management</h2>
    </center>

    <br/>

    <div class="container">
        <form>
            <div class="form-group row">
                <label for="first-name" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control first-name" id="first-name" placeholder="First Name">
                </div>
            </div>

            <div class="form-group row">
                <label for="last-name" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="last-name" placeholder="Last Name">
                </div>
            </div>

            <div class="form-group row">
                <label for="gender" class="col-sm-2 col-form-label">Gender</label>
                <div class="col-sm-10">
                    <select class="form-control gender" id="gender">
                        <option value="1">Male</option>
                        <option value="2">Female</option>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" placeholder="Email">
                </div>
            </div>

            <div class="form-group row">
                <label for="dob" class="col-sm-2 col-form-label">Date of Birth</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="dob" placeholder="Date of Birth">
                </div>
            </div>

            <div class="form-group row">
                <label for="address" class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm-10">
                    <textarea class="form-control address" id="address" placeholder="Address"></textarea>
                </div>
            </div>

            <div class="form-group row">
                <label for="phone" class="col-sm-2 col-form-label">Date of Birth</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" placeholder="Phone">
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-12">
                    <button class="btn btn-primary pull-right">Save</button>
                </div>
            </div>
        </form>
    </div>



</div> <!-- /container -->


<script>

    $(function(){

    })

</script>

<%@ include file="template/footer.jsp" %>
