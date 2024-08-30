<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create/Edit Task</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="taskForm.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Task Form</a>
</nav>
<div class="container">
    <h1 class="text-center my-4">Create/Edit Task</h1>
    <form:form method="post" modelAttribute="task" action="/tasks/create">
        <form:hidden path="id"/>
        <div class="form-group">
            <label for="title">Task Title</label>
            <form:input path="title" cssClass="form-control" id="title" placeholder="Enter task title"/>
            <form:errors path="title" cssClass="alert"/>

        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="description" cssClass="form-control" id="description" rows="3" placeholder="Enter task description"/>
            <form:errors path="description" cssClass="alert"/>
        </div>
        <div class="form-group">
            <label for="difficulty">Difficulty</label>
            <form:select path="difficulty">
                <option value="EASY">Easy</option>
                <option value="MEDIUM">Medium</option>
                <option value="HARD">Hard</option>
            </form:select>
            <form:errors path="difficulty" cssClass="alert"/>
        </div>
        <div class="form-group">
            <label for="points">Points</label>
            <form:input path="points" cssClass="form-control" id="points" type="number" placeholder="Enter points"/>
            <form:errors path="points" cssClass="alert"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
   </div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
