<div id="loginModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    Please Login
                </h3>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" id="userNameInput"
                               placeholder="User Name" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="password" id="passwordInput"
                               placeholder="Password" class="form-control" >
                    </div>
                </div>

            </div>

            <div class="modal-footer">
                <span id="loginMessage" class="glyphicon"></span>

                <button type="button" id="submitButton" class="btn  btn-default">
                    <span class="glyphicon glyphicon-user"></span> Submit
                </button>

                <button type="button" id="cancelButton" class="btn  btn-default" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove-sign"></span> Cancel
                </button>

            </div>

        </div>
    </div>

</div>