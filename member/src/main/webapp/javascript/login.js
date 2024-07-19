const fn_sendMember = () => {
	let regform = document.regform;
	
	let id = regform.userid.value;
	let password = regform.password.value;

	if (id.length == 0 || id == "") {
		alert("아이디는 필수입니다.");
	} else if (pwd.length == 0 || password == "") {
		alert("비밀번호는 필수입니다.");
	} else {
		regform.method = "post";
		regform.action = "join";
		regform.submit();
	}

}