<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3 class="my-4 " align="left">Categories</h3>
<div class="list-group">

	<c:forEach  items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/clothes" class="list-group-item" id="a_${category.name}">${category.name}</a>
	</c:forEach>
</div>
 