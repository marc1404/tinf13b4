<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>AJAX</title>
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<table class="table">
				<tr>
					<th>Name</th>
					<th>Vorname</th>
					<th>E-Mail</th>
					<th>Mobil</th>
				</tr>
			</table>
			<ul class="pagination pagination-lg">
				<li onclick="loadPage1()">
					<a href="#">Seite 1</a>
				</li>
  				<li onclick="loadPage2()">
  					<a href="#">Seite 2</a>
  				</li>
			</ul>
		</div>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
		<script>
			"use strict";
			
			function loadPage1(){
				$.get("page1.json", function(data){
					refreshTable(data);
				});
			}
			
			function loadPage2(){
				
			}
			
			function refreshTable(json){
				var html = [];
				
				for(var i = 0; i < json.addresses.length; i++){
					var address = json.addresses[i];
					
					html.push("<tr><td>" + address.name + "</td><td>" + address.vorname + "</td><td>" + address.email + "</td><td>" + address.mobil + "</tr>");
				}
				console.log(html.join(""));
				$("table").html(html.join(""));
			}
		</script>
	</body>
</html>