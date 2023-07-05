<!DOCTYPE html>
<html>
<head>
	<title>User Signup</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
		<h2>User Signup</h2>
		<form method="POST" action="usersignup.php">
			<label for="first_name">First Name:</label>
            <input type="text"name="first_name" required><br><br>
			<label for="email">Email:</label>
			<input type="email" name="email" required><br><br>
			<label for="password">Password:</label>
			<input type="password" name="password" required><br><br>
            <label for="password">Password:</label>
			<input type="password" name="password" required><br><br>
			<input type="submit" name="submit" value="Signup">
		</form>
		<p>Already have an account? <a href="userlogin.php">Login here</a>.</p>
	</div>
</body>
</html>

<?php
// connect to the database
$host = "localhost";
$user = "root";
$password_db = "";
$database = "bank_management_system";

$conn = mysqli_connect($host, $user, $password_db, $database);

// check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// check if the form has been submitted
if (isset($_POST['submit'])) {
	$name = $_POST['name'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	// encrypt the password
	$encrypted_password = password_hash($password, PASSWORD_DEFAULT);

	// insert the new user into the user table
	$sql = "INSERT INTO user (name, email, password) VALUES ('$name', '$email', '$encrypted_password')";
	if (mysqli_query($conn, $sql)) {
	    echo "New user created successfully";
	} else {
	    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}

	// close the database connection
	mysqli_close($conn);
}
?>
