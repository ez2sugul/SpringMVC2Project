<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<title>Error</title>
</head>
<script language="javascript">
</script>
<body bgcolor="#ffffff" text="#000000">

<!-- 타이틀 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="93%">문제 발생!(java.lang.ArithmeticException에 대한 예외 화면)</td>
	</tr>
</table>
<!-- 타이틀 끝 -->
<table width="100%" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="center">
		<table width="375" height="153" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td height="153">
				<table width="500" border="0" cellspacing="0" cellpadding="0">
					<tr><td>Message:</td><td></td><td></td></tr>
					<tr>
						<td width="50">&nbsp;</td>
						<td width="400">${exception.message}</td>
						<td width="50">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td align="center"></td>
	</tr>
</table>
</body>
</html>

