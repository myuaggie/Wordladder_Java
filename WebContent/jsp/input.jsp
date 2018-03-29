<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>WordLadder</h2>
<form:form method="POST" action="/maven6/output">
   <table>
    <tr>
        <td><form:label path="dict">Dict Name</form:label></td>
        <td><form:input path="dict" /></td>
    </tr>
    <tr>
        <td><form:label path="word1">Word1</form:label></td>
        <td><form:input path="word1" /></td>
    </tr>
    <tr>
        <td><form:label path="word2">Word2</form:label></td>
        <td><form:input path="word2" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>