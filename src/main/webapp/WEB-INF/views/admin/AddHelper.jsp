<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/AdminHeader.jsp"/>

<div class="add-user-form">
    <form:form id="add-helper-form" method="POST" modelAttribute="helper">
        <h2 class="admin-form-title">Add Helper</h2>
        <fieldset>
            <div>
                <div>
                    <label class="form-label" for="chefname">Helper name</label>
                    <form:input class="form-input-box" id="helpername"
                                name="chefname" placeholder="Enter helper name here" type="text" path="name"/>
                </div>
                <div>
                    <label class="form-label" for="age">Age</label>
                    <form:input class="form-input-box" id="age" name="age"
                                placeholder="Enter age here" type="text" path="age"/>
                </div>               
                
                <div>
                    <label>Gender</label>
                    <div class="radio-button" id="radio-button-box">
                        <form:radiobutton id="male" name="gender" value="Male" path="gender"/>
                        <label class="radio-label" for="male">Male</label>
                        <form:radiobutton id="female" name="gender" value="Female" path="gender"/>
                        <label class="radio-label" for="female">Female</label>
                    </div>
                </div>
                
                <div>
                    <label class="form-label" for="phone">Phone Number</label>
                    <form:input class="form-input-box" id="phone" name="phoneNumber"
                                placeholder="Enter phone number here" type="text" path="phoneNumber"/>
                </div>
            </div>
        </fieldset>
        <p id="admin-prompt"></p>
        <div class="center">
            <input id="form-submit" type="submit" class="button" value="Add Helper">
        </div>
    </form:form>
</div>

<script src="<c:url value="/resources/static/js/Logic.js"/>"></script>
<script src="<c:url value="/resources/static/js/AddHelper.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>