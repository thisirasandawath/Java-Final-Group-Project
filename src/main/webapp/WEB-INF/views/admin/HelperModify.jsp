<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/AdminHeader.jsp"/>

<div class="center">
    <form:form action="helper-modify-action?id=${helper.helperID}" class="form-user-profile" id="update-form" method="post" modelAttribute="helper">
        <h1>Helper Profile</h1>
        <table class="profile-table">
            <tr>
                <td>Helper ID:</td>
                <td>${helper.helperID}</td>
            </tr>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><form:input id="name" name="name" path="name" maxlength="30"
                                placeholder="Enter name here" type="text"/></td>
            </tr>            
            <tr>
                <td><label for="phoneNumber">Phone:</label></td>
                <td><form:input id="phoneNumber" name="phoneNumber" path="phoneNumber" maxlength="14"
                                placeholder="Enter phone number here" type="text"/></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>${helper.gender}</td>
            </tr>
            <tr>
                <td>Age:</td>
                <td>${helper.age}</td>
            </tr>
        </table>
        <div>
            <div class="center-text">
                <p id="message">
                    <% if (request.getParameter("error") != null){
                    	out.print("<p class=\"error-message\">Please fill out all the fields properly.</p>");	
                    }                        
                    if (request.getParameter("updated") != null) {
                        out.print("<p class=\"success\">Your details has been successfully updated.</p>");
                    }
                    %>
                </p>
            </div>
            <input class="button" id="confirm-button" type="submit" value="Confirm">
        </div>
    </form:form>
</div>

<script src="<c:url value="/resources/static/js/Logic.js"/>"></script>
<script src="<c:url value="/resources/static/js/ModifyHelperValidate.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>