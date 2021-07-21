<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
				
		$('#personaList').DataTable({
			//pageLenght:2,
			ajax:{
				url:'/api/shops',
				dataSrc:''
			},
			columns:[
				{
					title:'Id',
					data:'id'
				},
				{
					title:'Nombre',
					data:'nombre'
				},
				{
					title:'Capacidad',
					data:'capacidad'
				}
			]
			
		});
		
	});

	
	</script>

</head>
<body>

	<div class="container">
		<table class="table table-striped" id="personaList">
            
        </table>
	
	</div>
	
	<!-- <thead>
				<tr>
					<th> Id </th> 
					<th> Nombre </th> 
					<th> Capacidad </th> 
				</tr>
			</thead>
			
			 
            <tbody>
				<c:forEach var="tienda" items="${tiendas}" varStatus="i">
					
					<tr>
						<td>${i.index +1}</td>
						<td>${tienda.nombre}</td>
						<td>${tienda.capacidad}</td>
						<td><a href="#editarTienda+${i.index +1}" class="button-warning">Editar</a></td>
						<td><a href="#borrarTienda+${i.index +1}" class="button-danger">Borrar</a></td>
					</tr>	
					
				</c:forEach>
					
            </tbody>
            
            
            <tfoot>
				<tr>
					<th> Id </th> 
					<th> Nombre </th> 
					<th> Capacidad </th>  
				</tr>
			</tfoot>
        
            
        </table>
        -->
	

</body>
</html>