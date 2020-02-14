<?php

	require 'includes/PHPMailer.php';
	require 'includes/SMTP.php';
	require 'includes/Exception.php';

	use PHPMailer\PHPMailer\PHPMailer;
	use PHPMailer\PHPMailer\SMTP;
	use PHPMailer\PHPMailer\Exception;
	
	if(isset($_GET['key']) && isset($_GET['email']) && isset($_GET['password'])){
		if($_GET['key'] == "cse299"){
			$mail = new PHPMailer();
			$mail->isSMTP();
			$mail->Host = "smtp.gmail.com";
			$mail->SMTPAuth = true;
			$mail->SMTPSecure = "tls";
			$mail->Port = "587";
			$mail->Username = "299spring2020@gmail.com";
			$mail->Password = "cse299project";
			$mail->Subject = "Tenant Portal reset password!";
			$mail->setFrom('299spring2020@gmail.com');
			$mail->isHTML(true);
			$mail->Body = "<h1 style=\"color: #20B2AA;\">Dear user!</h1><p>You have requested to change the password of the Tenant account. "
							. "We have assigned a new password for your account.</p>"
							. "<p>The new password for your account is: <b>". $_GET['password'] ."</b></p>";
			$mail->addAddress($_GET['email']);
			if($mail->send()){
				echo json_encode(array('result' => true));
			}else{
				echo json_encode(array('result' => false));
			}
			$mail->smtpClose();
		}else{
			echo json_encode(array('result' => false));
		}
	}else{
		echo json_encode(array('result' => false));
	}
	
	
	
	
	
	
	
	