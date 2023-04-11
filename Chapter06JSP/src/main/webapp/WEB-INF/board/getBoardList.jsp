<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<div align="center">
		<h3>Board List</h3>
		<table border="1" class="table table-hover">
			<thead class="table-light">
				<tr>
					<th width="100">번호</th>
					<th width="200">제목</th>
					<th width="150">작성자</th>
					<th width="150">등록일</th>
					<th width="100">조회수</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach var="board" items="${boardList}"> <!-- controller의 model.addAttribute에 들어가있는 항목 -->
					<tr>
						<td>${board.seq}</td>
						<td><a href="getBoard?seq=${board.seq }">${board.title}</a></td>
						<td>${board.writer}</td>
						<td><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
						<td>${board.cnt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="insertBoard">새글 등록</a>
	</div>
</body>
</html>