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


    <form role="form" enctype="multipart/form-data" action="/lecture/add" method="post">
        <div class="form-group">
            <h3>Add New Lecture</h3>
        </div>

        <div class="form-group">
            <label for="exampleInputTitle">Title</label>
            <input type="text" name="name" class="form-control" id="exampleInputTitle">
        </div>

        <div class="form-group">
            <label for="exampleInputParticipant">Author</label>
            <select class="selectpicker form-control" name="participant" id="exampleInputParticipant">
                <option value="-1">No Author</option>
                <c:forEach items="${participant}" var="participant">
                <option value="${participant.id}">${participant.name} ${participant.surname}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleInputSection">Section</label>
            <select class="selectpicker form-control" name="section" id="exampleInputSection">
                <option value="-1">No Section</option>
                <c:forEach items="${section}" var="section">
                    <option value="${section.id}">${section.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleInputText">Abstract</label>
            <input type="text" name="text" class="form-control" id="exampleInputText">
        </div>
        <input type="submit" class="btn btn-info" value="Add">
    </form>

    <hr style="border: 1px solid deepskyblue">

            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                   Section
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="/lecture_add">No Section</a></li>
                    <c:forEach items="${sectionput}" var="sectionput">
                        <li><a href="/section/${sectionput.id}">${sectionput.name}</a></li>
                    </c:forEach>
                </ul>
            </div>

            <form class="navbar-form navbar-left" role="search" action="/search_lecture" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="pattern" placeholder="Title">
                </div>
                <button type="submit" class="btn btn-info">Search</button>
            </form>

    <table class="table table-striped">
        <thead>
        <tr class="warning">
            <td></td>
            <td><b>Title</b></td>
            <td><b>Author</b></td>
            <td><b>Section</b></td>
            <td></td>
        </tr>
        </thead>
        <c:forEach items="${lectures}" var="lecture">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${lecture.id}" id="checkbox_${lecture.id}"/></td>
                <td>${lecture.name}</td>
                <c:choose>
                    <c:when test="${lecture.participant ne null}">
                        <td>${lecture.participant.name} ${lecture.participant.surname}</td>
                    </c:when>
                    <c:otherwise>
                        <td>No Author</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${lecture.section ne null}">
                        <td>${lecture.section.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>No Section</td>
                    </c:otherwise>
                </c:choose>
                <td><button type="button" id="show_lecture" class="btn btn-info" onclick="window.location='/lecture/${lecture.id}';">More Details</button></td>
            </tr>
        </c:forEach>
    </table>

    <button type="button" id="delete_lecture" class="btn btn-info">Delete Checked Lectures</button>
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

    $('#delete_lecture').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/lecture/delete", data);
        setTimeout(function(){window.location.href='/lecture_add'},300)
    })
</script>
<script>
    $('.selectpicker').selectpicker();
</script>
<script>
    $('.dropdown-toggle').dropdown();
</script>

</body>
</html>