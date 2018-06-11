/**
 * �û�ע�ắ��
 */
function regist() {
	var username = $("#regist_username").val().trim();
	var nick = $("#nickname").val().trim();
	var password = $("#regist_password").val().trim();
	var final_password = $("#final_password").val().trim();

	// ��ʾ����״̬
	var ok = true;
	// ����û���
	if (username == "") {
		$("#warning_1").show();
		ok = false;
	}
	// ������룺1����������Ƿ�Ϊ�� 2��������볤���Ƿ�С��6

	if (password == "") {
		$("#warning_2 span").html("���벻��Ϊ��");
		$("#warning_2").show();
		ok = false;
	} else if (password.length > 0 && password.length < 6) {
		$("#warning_2 span").html("���볤��Ҫ����6λ");
		$("#warning_2").show();
		ok = false;
	}
	// ���ȷ������
	if (final_password != password) {
		$("#warning_3").show();
		ok = false;
	}

	if (ok) {// ���ͨ��
		// ����ajax����
		$.ajax({
			url : "user/add.do",
			type : "post",
			data : {
				"username" : username,
				"nick" : nick,
				"password" : password
			},
			dataType : "json",
			success : function(result) {
				if (result.status == 1) {
					$("#warning_1").html(result.msg);
					$("#warning_1").show();

				} else if (result.status == 0) {
					alert(result.msg);
					$("#back").click();
				}

			},
			error : function() {
				alert("ע��ʧ��");
			}
		})
	}
}