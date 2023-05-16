<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/AdminHeader.jsp"/>

<div class="center">
    <form:form action="food-modify-action?id=${food.foodID}" class="form-user-profile" id="update-form" method="post" modelAttribute="food">
        <h1>Food Details</h1>
        <table class="profile-table">
            <tr>
                <td>Food ID:</td>
                <td>${food.foodID}</td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><form:select class="form-input-box" id="category" path="category">
                        <form:option value="Burger">Burger</form:option>
                        <form:option value="Pizza">Pizza</form:option>
                        <form:option value="Salad">Salad</form:option>
                        <form:option value="Pasta">Pasta</form:option>
                        <form:option value="Drinks">Drinks</form:option>
                        <form:option value="Coffee">Coffee</form:option>
                        <form:option value="Desert">Desert</form:option>
                        <form:option value="Sides">Sides</form:option>
                    </form:select></td>
            </tr>
            <tr>
                <td><label for="title">Food Name:</label></td>
                <td><form:input id="title" name="title" path="title" maxlength="30"
                                placeholder="Enter Title here" type="text"/></td>
            </tr>
            <tr>
            	<td><label for="price">Price:</label></td> 
            	<td><form:input class="form-input-box" id="price" maxlength="5"
                                placeholder="Enter price here" type="text" path="price"/></td>
            </tr>                               
            <tr>
                <td><label for="description">Description:</label></td>
                <td><form:textarea id="description" name="description" class="food-description"
                                   placeholder="Enter food description here" rows="4" path="description"/></td>
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
<script src="<c:url value="/resources/static/js/ModifyFoodValidate.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>