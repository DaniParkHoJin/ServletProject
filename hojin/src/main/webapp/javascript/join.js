ns4 = (document.layers) ? true : false;

function ect_view() {
	if (ns4) {
		document.ect_input.visibility = "show"
	} else {
		document.all.ect_input.style.visibility = "visible";
	}
}

function ect_hide() {
	if (ns4) {
		document.ect_input.visibility = "hide";
	} else {
		document.all.ect_input.style.visibility = "hidden";
	}
}

function zipcode_openwin() {
	new daum.Postcode({
		oncomplete: function(data) {
			document.getElementById('zipcode').value = data.zonecode;
			document.getElementById('id_address1').value = data.address;
		}
	}).open();
}

function checkForm(regForm) {
	// 이름(실명) 유효성 검사
	function validateName() {
		let nameField = document.getElementById('name_id').value.trim();
		let regex = /^[가-힣]{2,}$/;

		if (!regex.test(nameField)) {
			alert("이름을 한글로 2글자 이상 입력해주세요.");
			return false;
		}

		return true;
	}

	// 회원ID 유효성 검사
	function validateUserID() {
		let userIDField = document.getElementById('id_userid').value.trim();
		let regex = /^[a-zA-Z][a-zA-Z0-9]{3,17}$/;

		if (!regex.test(userIDField)) {
			alert("회원ID는 영문자로 시작하는 4~18자의 영문, 숫자를 조합하여 입력해주세요.");
			return false;
		}

		return true;
	}

	// 비밀번호 유효성 검사
	function validatePassword() {
		let passwordField = document.getElementById('id_password').value;
		let regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;

		if (!regex.test(passwordField)) {
			alert("비밀번호는 영문 대소문자, 숫자, 특수문자를 포함하여 최소 8자 이상 입력해주세요.");
			return false;
		}

		return true;
	}
	// 비밀번호와 비밀번호 확인 일치 여부 검사
	function validatePasswordMatch() {
		let password = document.getElementById('id_password').value;
		let repassword = document.getElementById('id_repassword').value;

		if (password !== repassword) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return false;
		}

		return true;
	}

	// 이메일 유효성 검사
	function validateEmail() {
		let emailField = document.getElementById('id_email').value;
		let regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

		if (!regex.test(emailField)) {
			alert("올바른 이메일 주소를 입력해주세요.");
			return false;
		}

		return true;
	}

}

const fn_sendMember = () => {
	let regform = document.regform;

	let id = regform.name_userid.value;
	let name = regform.name_name.value;
	let pwd = regform.name_password.value;
	let email = regform.name_email.value;

	if (id.length == 0 || id == "") {
		alert("아이디는 필수입니다.");
	} else if (pwd.length == 0 || pwd == "") {
		alert("비밀번호는 필수입니다.");
	} else if (name.length == 0 || name == "") {
		alert("이름은 필수입니다.");
	} else if (email.length == 0 || email == "") {
		alert("이메일은 필수입니다.");
	} else {
		regform.method = "post";
		regform.action = "join";
		regform.submit();
	}

}

function fn_process() {
	// 텍스트   박스에   입력한   ID 를   가져온다. 
	var _id = $("#id_userid").val();
	if (_id == '') {
		alert("ID를 입력하세요");
		return;
	}
	$.ajax({
		type: "post",
		async: true,
		url: "http://localhost:8080/hojin/idcheck",
		dataType: "text",
		data: {
			id: _id
		},
		success: function(data, textStatus) {
			// alert(data);
			// 서버에서   전송된   결과에    따라    메시지를   표시한다. 
			if (data == 'usable') {
				$('#message').text("사용할   수   있는   ID 입니다.");
				// 사용할   수   있는   ID 면   버튼을   비활성화시킨다. 
				$('#check_id').prop("disabled", true);
			} else {
				$('#message').text("사용할   수   없는   ID 입니다.");
			}
		},
		error: function(data, textStatus) {
			alert("에러가 발생했습니다.");
			
		},
		complete: function(data, textStatus) {
			//alert("작업을완료   했습니다");
		}
	}); //end ajax 
}