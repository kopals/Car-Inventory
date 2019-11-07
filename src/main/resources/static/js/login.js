var $ = function(id){
	return document.getElementById(id);
};

var sign_in = function(){
	var user = $("uid").value;
	var pwd = $("pwd").value;
	
	var isValid = true;
	
	if(user=="" ){
		$("user_name_error").innerHTML = "This field is required";
		isValid = false;
	}
	else
	{
		$("user_name_error").innerHTML = "";
	}
	
	if(pwd==""){
		$("pwd_error").innerHTML = "This field is required";
		isValid = false;
	}
	else
	{
		$("pwd_error").innerHTML = "";
	}
	
        if (validateEmail(user)) {

				isValid = true;
        }

        else {

            	$("user_name_error").innerHTML = "Enter valid email address";
				isValid = false;

            //e.preventDefault();

        }
	if(isValid)
	{
		$("email_form").submit();
	}
};


function validateEmail(sEmail) {

    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

    if (filter.test(sEmail)) {

        return true;

    }

    else {

        return false;

    }

}


window.onload = function(){
	$("Login").onclick = sign_in;
	
	// $('input').focus(function(){
	// 	 $(this).removeAttr('placeholder');
	// });
};