<?php
include 'config.php';
// Message to be sent
$message = $_POST['message'];

// Set POST variables
$url = 'https://android.googleapis.com/gcm/send';

$link = mysql_connect($host, $username, $password) or die('<br>'.mysql_error());

if ($link) {
	mysql_select_db($dbname, $link) or die('<br>'.mysql_error());

	$query = 'SELECT registration_id FROM registration';

	#echo '<br>'.$query;

	$query_result = mysql_query($query, $link) or die('<br>'.mysql_error());
	$count = count($query_result);

	$arrayList = array();

	while($row = mysql_fetch_array($query_result)){
  		array_push($arrayList, $row[0]);
	}

	mysql_free_result($query_result); 
	mysql_close($link);

	$fields = array(
                'registration_ids'  => $arrayList,
                'data'              => array( "message" => $message ),
                );

	$headers = array( 
                    'Authorization: key=' . $_POST['apiKey'],
                    'Content-Type: application/json'
                );

	echo '<br>'.json_encode( $fields );

	// Open connection
	$ch = curl_init();

	// Set the url, number of POST vars, POST data
	curl_setopt( $ch, CURLOPT_URL, $url );

	curl_setopt( $ch, CURLOPT_POST, true );
	curl_setopt( $ch, CURLOPT_HTTPHEADER, $headers);
	curl_setopt( $ch, CURLOPT_RETURNTRANSFER, true );

	curl_setopt( $ch, CURLOPT_POSTFIELDS, json_encode( $fields ) );

	// Execute post
	$result = curl_exec($ch);

	// Close connection
	curl_close($ch);

	echo '<br>'.$result;
}
?>