<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="userForm.css" rel="stylesheet"> <!-- Odniesienie do pliku CSS -->
</head>
<body>
<div class="container">
    <h1 class="text-center mt-5">Create User</h1>
    <form:form action="${pageContext.request.contextPath}/users/create" method="post" modelAttribute="user" class="mt-4">
        <div class="form-group">
            <label for="username">Username:</label>
            <form:input path="username" cssClass="form-control" id="username" required="true"/>
            <form:errors path="username" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" cssClass="form-control" id="email" type="email" required="true"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:input path="password" cssClass="form-control" id="password" type="password" required="true"/>
            <form:errors path="password" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="level">Level:</label>
            <form:input path="level" cssClass="form-control" id="level" type="number" required="true"/>
            <form:errors path="level" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="xp">XP:</label>
            <form:input path="xp" cssClass="form-control" id="xp" type="number" required="true"/>
            <form:errors path="xp" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Create</button>
    </form:form>
    <div class="list-group">
        <a href="${pageContext.request.contextPath}/users" class="list-group-item list-group-item-action">User List</a>
    </div>
</div>
</body>
</html>
