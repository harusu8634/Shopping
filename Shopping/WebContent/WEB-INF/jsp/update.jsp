<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>買い物リスト</title>
</head>
<body>
	<h1>買い物リスト</h1>
	<h2>食材名または種類を変更できます。</h2>
	<form action="/Shopping/UpdateServlet" method="post">
		食材名：<input type="text" name="name" value="${item.name}" >
		種類：<div>
				<label><input type="radio" value="野菜・果物" name="kind" required>野菜・果物</label>
			</div>
			<div>
				<label><input type="radio" value="肉・魚" name="kind">肉・魚</label>
			</div>
			<div>
				<label><input type="radio" value="加工食品" name="kind">加工食品</label>
			</div>
			<div>
				<label><input type="radio" value="乳製品" name="kind">乳製品</label>
			</div>
			<div>
				<label><input type="radio" value="パン・菓子類" name="kind">パン・菓子類</label>
			</div>
			<div>
				<label><input type="radio" value="飲料" name="kind">飲料</label>
			</div>
			<div>
				<label><input type="radio" value="日用品" name="kind">日用品</label>
			</div>
			<div>
				<label><input type="radio" value="その他" name="kind">その他</label>
			</div>
			<input type="hidden" name="id" value="${item.id}">
			<input type="submit" value="更新">
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script type="text/javascript">
		$(()=>{
			function value() {
				$('input[value="${item.kind}"]').prop('checked', true);
			}
			
			value();
		});
	</script>
</body>
</html>