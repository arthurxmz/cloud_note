/**
 * ��������ҳ���js�ű�
 */
//��������
function changePassword() {
	$("#warning_1").hide();
	var ok = true;
	// ����������
	var userId = getCookie("uid");
	var lastPassword = $("#last_password").val().trim();
	var newPassword = $("#new_password").val().trim();

	// ��ʽ���
	if (userId == null) {
		ok = false;
		window.location.href = "log_in.html";
	}
	// ����ajax����
	if (ok) {
		$.ajax({
			url : path + "/user/changepassword.do",
			type : "post",
			data : {
				"userId" : userId,
				"lastPassword" : lastPassword,
				"newPassword" : newPassword
			},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					alert(result.msg);
				}
				if (result.status == 1) {
					$("#warning_1").show();
				}
			},
			error : function() {
				alert("�޸������쳣");
			}
		});
	}

}

//������ҳ��
function back(){
	window.location.href = "edit.html";
}