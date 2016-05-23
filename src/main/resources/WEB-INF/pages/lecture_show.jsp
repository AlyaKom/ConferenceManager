<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Lecture</title>
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

    <h2 align="center"><c:out value="${title}"/></h2>
    <h4 align="center">Section: <c:out value="${section}"/></h4>
    <h3 align="center">Author: <c:out value="${name}"/> <c:out value="${surname}"/></h3>
    <h4 align="center">Company <c:out value="${company}"/></h4>
    <h5 align="center"><c:out value="${abstract}"/></h5>

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

    $('#delete_lecture').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/lecture/delete", data);
        setTimeout(function(){window.location.href='/lecture_add'},300);
    })
</script>
</body>
</html>