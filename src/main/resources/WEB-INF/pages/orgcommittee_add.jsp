<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New OrgCommittee Member</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="main" class="btn btn-info navbar-btn">Main</button></li>
                    <li><button type="button" id="add_participant" class="btn btn-info navbar-btn">Participants</button></li>
                    <li><button type="button" id="add_lecture" class="btn btn-info navbar-btn">Lectures</button></li>
                    <li><button type="button" id="add_section" class="btn btn-info navbar-btn">Sections</button></li>
                    <li><button type="button" id="add_sponsor" class="btn btn-info navbar-btn">Sponsors</button></li>
                    <li><button type="button" id="add_orgcommittee" class="btn btn-info navbar-btn">Organizing Committee</button></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>


    <form role="form" enctype="multipart/form-data" action="/orgcommittee/add" method="post">
        <div class="form-group">
            <h3>Add New Organizing Committee Member</h3>
        </div>
        <div class="form-group">
            <label for="exampleInputname">First Name</label>
            <input type="text" name="name" class="form-control" id="exampleInputName">
        </div>
        <div class="form-group">
            <label for="exampleInputSurname">Surname</label>
            <input type="text" name="surname" class="form-control" id="exampleInputSurname">
        </div>
        <div class="form-group">
            <label for="exampleInputPhone">Phone</label>
            <input type="text" name="phone" class="form-control" id="exampleInputPhone">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail">E-mail</label>
            <input type="text" name="email" class="form-control" id="exampleInputEmail">
        </div>
        <div class="form-group">
            <label for="exampleInputAppointment">Appointment</label>
            <input type="text" name="appointment" class="form-control" id="exampleInputAppointment">
        </div>
        <input type="submit" class="btn btn-info" value="Add">
    </form>

    <hr style="border: 1px solid deepskyblue">
    <h2>Added Committee Members</h2>
    <table class="table table-striped">
        <thead>
        <tr class="warning">
            <td></td>
            <td><b>Name</b></td>
            <td><b>Surname</b></td>
            <td><b>Phone</b></td>
            <td><b>E-mail</b></td>
            <td><b>Appointment</b></td>
        </tr>
        </thead>
        <c:forEach items="${orgcommittee}" var="orgcommittee">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${orgcommittee.id}" id="checkbox_${orgcommittee.id}"/></td>
                <td>${orgcommittee.name}</td>
                <td>${orgcommittee.surname}</td>
                <td>${orgcommittee.phone}</td>
                <td>${orgcommittee.email}</td>
                <td>${orgcommittee.appointment}</td>
            </tr>
        </c:forEach>
    </table>

    <button type="button" id="delete_committee" class="btn btn-info">Delete Checked Org Members</button>
    <hr style="border: 1px solid deepskyblue">
</div>

<script>
    $('#main').click(function(){
        window.location.href='/';
    })

    $('#add_participant').click(function(){
        window.location.href='/participant_add';
    })

    $('#add_lecture').click(function(){
        window.location.href='/lecture_add';
    })

    $('#add_section').click(function(){
        window.location='/section_add';
    })

    $('#add_sponsor').click(function(){
        window.location.href='/sponsor_add';
    })

    $('#add_orgcommittee').click(function(){
        window.location.href='/orgcommittee_add';
    })

    $('#delete_committee').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/orgcommittee/delete", data);
        setTimeout(function(){window.location.href='/orgcommittee_add'},300)
    })
</script>
</body>
</html>