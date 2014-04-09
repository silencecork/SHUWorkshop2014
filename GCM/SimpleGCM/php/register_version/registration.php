<?php 
	include 'config.php';
	
	$id = $_GET['id'];

	$link = mysql_connect($host, $username, $password) or die('<br>'.mysql_error());

	if ($link) {
		mysql_select_db($dbname, $link) or die('<br>'.mysql_error());

		$query = 'SELECT COUNT(*) as total FROM registration where registration_id=\''.$id.'\'';

		$result = mysql_query($query, $link) or die('<br>'.mysql_error());
		$count = count($result);

		if ($count > 0) {
			$row = mysql_fetch_assoc($result);
  			$find = $row['total'];	
  			if ($find <= 0) {
  				$insert_sql = 'INSERT INTO registration (registration_id) VALUES (\''.$id.'\')';
  				mysql_query($insert_sql, $link) or die('<br>'.mysql_error());
  			}
  			echo get_reuslt_json('00');
		} 
		
		mysql_free_result($result); 
		mysql_close($link);
	}

	function get_reuslt_json($result_code) {
		$fields = array(
                'result'  => $result_code,
        );
		return json_encode($fields);
	}

?>