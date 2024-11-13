<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>買い物リスト</title>
</head>
<body>
	<h1>買い物リスト</h1>
	<a class="add" href="/Shopping/CreateServlet">追加</a>
	<c:choose>
		<c:when test="${empty itemList}">
			<p>アイテムを追加してください。</p>
		</c:when>
		<c:otherwise>
			<form action="/Shopping/DeleteServlet" method="post">
				<c:forEach var="item" items="${itemList}" >
					<div class="flex">
						<div class="item">
							<input type="checkbox" name="id" value="${item.id}">
							${item.name}<span>${item.kind}</span>
						</div>
						<a class="update" href="/Shopping/UpdateServlet?id=${item.id}">変更</a>
					</div>
				</c:forEach>
				<div class="delete">
					<input type="submit" value="削除">
				</div>
			</form>
			<div class="copy">
			<button id="copy">リンクをコピー</button>
			</div>
			<p class="copy_text">http://localhost:8080/Shopping/ReadServlet</p>
		</c:otherwise>
	</c:choose>
		<script type="text/javascript">
			let copyText = document.querySelector(".copy_text").textContent;
			const copyTarget = document.getElementById("copy");
			
			copyTarget.onclick = () => {
				navigator.clipboard.writeText(copyText);
				copyTarget.textContent = "Copied"
			}
		</script>
</body>
</html>