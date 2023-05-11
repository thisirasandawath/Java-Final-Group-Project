<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/AdminHeader.jsp"/>

<div class="manage-user-container">
    <form id="register-form" method="POST">
        <h2 class="admin-form-title">Manage Helpers</h2>
        <div class="table-wrapper">
            <table id="helpers-table">
                <tr>
                    <th>HelperID</th>
                    <th>Helper name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Phone Number</th>
                    <th>Action</th>
                </tr>
            </table>
        </div>
    </form>
</div>

<script src="<c:url value="/resources/static/js/ManageHelper.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>