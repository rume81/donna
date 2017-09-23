<script type="text/javascript" src="${rc.contextPath}/js/custome/settlement.js"></script>
<div class="col-sm-10 open-account">
    <h3 class="text-center">Add new Settlement</h3>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="add_settlement" id="add_settlement" action="${rc.contextPath}/insertSettlement" method="post">                       
            <div class="form-group">
                <label class="col-sm-4 control-label">Settlement Name</label>
                <div class="col-sm-8">
                    <input type="text" id="stln" name="stln" class="form-control" id="stln">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default">Cancel</button>
                    <button type="button" class="btn btn-default" onclick="insertSettlement('${rc.contextPath}')">Add</button>
                </div>
            </div>
        </form>
    </div>
    
</div>