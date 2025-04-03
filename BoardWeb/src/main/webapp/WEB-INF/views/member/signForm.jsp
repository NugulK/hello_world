<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signForm.jsp)</h3>
<form action="signUp.do" method="post" enctype="multiPart/form-data">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="userId" class="form-control">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="userPw" class="form-control">
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="userName" class="form-control">
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<input type="file" name="userImg" class="form-control">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원가입" class="btn btn-primary">
				<input type="reset" value="초기화" class="btn btn-secondary">
			</td>
		</tr>
	</table>
</form>
