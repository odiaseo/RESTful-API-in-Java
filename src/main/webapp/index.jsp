<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBC Software Engineering Exercise</title>
</head>
<body>
	<h1>RESTful API to view and manage BBC programs</h1>
	<p>End point is:</p>
	<ul>
		<li><a href="/bbc/rest-api/programservice/programs/">List
				Programs</a>
		<li>View program by ID -
			/bbc/rest-api/programservice/programs/{program_id}</li>
		<li>View program by category -
			/bbc/rest-api/programservice/category/{category_name}</li>
		<li>View program availability -
			/bbc/rest-api/programservice/available/(true|false)</li>
		<li>Delete program -
			/bbc/rest-api/programservice/delete/{program_id} - HTTP Method must
			be DELETE</li>
		<li>Create program - /bbc/rest-api/programservice/create - HTTP
			Method must be POST and the body should contain the program data</li>
		<li>Update program - /bbc/rest-api/programservice/update - HTTP
			Method must be PUT and the body should contain the program data</li>
	</ul>

</body>
</html>
