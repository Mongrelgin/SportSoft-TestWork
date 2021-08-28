<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
    <title>Library</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/home-page" class="navbar-brand">Library</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/book">Books</a></li>
                <li><a href="/author">Authors</a></li>
                <li><a href="/genre">Genres</a></li>
            </ul>
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${mode=='MODE_GENRE' }">
        <div class="container text-center" id="tasksDiv">
            <h3>All Users</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="genre" items="${genres }">
                        <tr>
                            <td>${genre.id}</td>
                            <td>${genre.title}</td>
                            <td><a href="/delete-genre?id=${genre.id }"><span
                                    class="glyphicon glyphicon-trash"></span></a></td>
                            <td><a href="/edit-genre?id=${genre.id }"><span
                                    class="glyphicon glyphicon-pencil"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="container text-center">
            <h3>New Registration</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="add-genre">

                <div class="form-group">
                    <label class="control-label col-md-3">Title</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="title"
                               value="${genre.title }" />
                    </div>
                </div>
                <div class="form-group ">
                    <input type="submit" class="btn btn-primary" value="Add genre" />
                </div>
            </form>
        </div>
    </c:when>
    <c:when test="${mode=='MODE_UPDATE_GENRE' }">
        <div class="container text-center">
            <h3>Update Genre</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="add-genre">
                <input type="hidden" name="id" value="${genre.id }" />
                <div class="form-group">
                    <label class="control-label col-md-3">Title</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="title"
                               value="${genre.title }" />
                    </div>
                </div>
                <div class="form-group ">
                    <input type="submit" class="btn btn-primary" value="Update" />
                </div>
            </form>
        </div>
    </c:when>
</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>