<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="fragment/header.jsp" %>
<div class="container form-container">
    <form action = "balancedBracket" class = "form-box" method="post">
        Expression: <input type="text" name="expression"><br>
        <input type="submit"  value="Submit">
    </form>

</div>