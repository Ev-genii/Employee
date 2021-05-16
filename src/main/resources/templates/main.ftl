<#import "parts/common.ftl" as c>

<@c.page>

<div class="form-row col-md-6">
	<div class="form-group">
		<form method="get" action="/" class="form-inline">
			<input type="text" name="filter" class="form-control" placeholder="Enter surname" value="${filter?ifExists}">
			<button type="submit" class="btn btn-info ml-2">Search</button>
		</form>
	</div>
</div> 

<div class="pl-5"><h3>Employee Directory</h3></div>
	
<#list page.content as employee>
<div class="card my-3" style="width: 30rem;" data-id="${employee.id}">
	<#if employee.filename??>
		<img src="/img/${employee.filename}"  class="card-img-top">
	</#if>
	<div class="card-body m-2">
		<ul class="list-group list-group-flush">
		    <li class="list-group-item"><h5>${employee.surname} ${employee.name} ${employee.lastName}</h5></li>
		    <li class="list-group-item">Position: ${employee.position}</li>
		    <li class="list-group-item">Date of birth: ${employee.dateOfBirth}</li>
		    <li class="list-group-item">Phone: ${employee.mobilePhone}</li>
		    <li class="list-group-item">Email: ${employee.email}</li>	 
		    <a class="btn btn-primary" href="/employee/${employee.id}?employee=${employee.id}">Edit</a>   
	 	</ul>
	</div>
</div>
<#else>
No employee
</#list>
	<#include "parts/footer.ftl">
</@c.page>