<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>회원 가입창</title>
   <script type="text/javascript">
   function fn_sendMember(){
	   var frmMember=document.frmMember;
	   var id=frmMember.id.value;
	   var pwd=frmMember.pwd.value;
	   var name=frmMember.name.value;
	   var email=frmMember.email.value;
	   if(id.length==0 ||id==""){
	      alert("아이디는 필수입니다.");
	   }else if(pwd.length==0 ||pwd==""){
	      alert("비밀번호는 필수입니다.");
	   }
	   else if(name.length==0 ||name==""){
	      alert("이름은 필수입니다.");
	   }else if(email.length==0 ||email==""){
	      alert("이메일은 필수입니다.");
	   }else{
	      frmMember.method="post";
	      frmMember.action="userin";
	      frmMember.submit();
	   } 
	}
   </script>
<body>
<form name="frmMember">
<h1  style="text-align:center">회원 가입창</h1>
<table  align="center">
    <tr>
       <td width="200"><p align="right">아이디</td>
       <td width="400"><input type="text" name="id"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">비밀번호</td>
        <td width="400"><input type="password"  name="pwd"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">이름</td>
        <td width="400"><p><input type="text"  name="name"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">이메일</td>
        <td width="400"><p><input type="text"  name="email"></td>
    </tr>
    <tr>
        <td width="200"><p>&nbsp;</p></td>
        <td width="400">
	<input type="submit" value="가입하기" onclick="fn_sendMember()">
	<input type="reset" value="다시입력">
	<input  type="hidden" name="command" value="addMember" />	
  </td>
    </tr>
</table>
</form>
</body>
</html>