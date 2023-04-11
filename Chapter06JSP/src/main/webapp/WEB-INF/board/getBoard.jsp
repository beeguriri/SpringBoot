<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
	<div align="center">
		<h3>게시글 상세</h3> 
		<hr>
		<form action="updateBoard" method="post">
			<input name="seq" type="hidden" value="${board.seq}" } />
			<table border="1">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${board.title}" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" cols="40" rows="10" >${board.content }</textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${board.cnt}</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value=" 글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<!-- 컨트롤러로 갔다가 jsp로 전달 -->
		<a href="insertBoardView">글 등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList">글목록</a>
	</div>
</body>
</html>