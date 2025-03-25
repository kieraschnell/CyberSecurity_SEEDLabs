<?php
// Function to create a sql connection.
function getDB() {
  $dbhost = "10.9.0.6";
  $dbuser = "seed";
  $dbpass = "dees";
  $dbname = "sqllab_users";

  // Create a DB connection
  $conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
  if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error . "\n");
  }
  return $conn;
}

$input_uname = $_GET['username'];
$input_pwd   = $_GET['Password'];
$hashed_pwd  = sha1($input_pwd);

// create a connection
$conn = getDB();

$result = $conn->prepare("SELECT id, name, eid, salary, ssn FROM credential WHERE name = ? AND Password = ?");
if (!$result) {
  die("Prepare failed: " . $conn->error);
}

$result->bind_param("ss", $input_uname, $hashed_pwd);

$result->execute();

$result->bind_result($id, $name, $eid, $salary, $ssn);
.
if ($result->fetch()) {
}

$result->close();
$conn->close();
?>