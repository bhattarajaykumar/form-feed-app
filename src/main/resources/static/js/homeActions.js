$(document).ready(function() {
	$('#submit').click(function(event) {
		$("#submitResponse").html('');
		var firstName = $('#firstName').val();
		var lastName = $('#lastName').val();
		var email = $("#email").val();
		var address = $('#address').val();
		var skills = $('#skills').val();
		if( firstName.trim() != '' && lastName.trim() != '' && email.trim() != '' &&
			address.trim() != '' && skills.trim() != ''
		)	{
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "/sendFeed",
				data: JSON.stringify(
					{
						'firstName': firstName,
						'lastName': lastName,
						'email' : email,
						'address' : address,
						'skills':  skills
					}
				),
				cache: false,
				success: function(result) {
					$("#submitResponse").html(result);
					console.log(result);
					$('#firstName').val('');
					$('#lastName').val('');
					$("#email").val('');
					$("#address").val('');
					$("#skills").val('');
				},
				error: function(err) {

				}
			});
		}
		event.preventDefault();
	});

});