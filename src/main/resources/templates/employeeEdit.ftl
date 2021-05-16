<#import "parts/common.ftl" as c>

<@c.page>

<div class="col-12 my-4">
	<div class="mb-3"><h3>Edit Employee</h3></div>
		<form method="post" enctype="multipart/form-data">
			<div class="row mb-1">	
				<label class="col-sm-3 col-form-label">Surname</label>
					<div class="form-group col-sm-8">
						<input type="text" class="form-control ${(surnameError??)?string('is-invalid', '')} mt-2" value="<#if employee??>${employee.surname}</#if>" name="surname" placeholder="Enter surname">
						<#if surnameError??>
							<div class="invalid-feedback">
								${surnameError}
							</div>
						</#if>
					</div>
			</div>
					
			<div class="row mb-1">	
				<label class="col-sm-3 col-form-label">Name</label>
					<div class="form-group col-sm-8">
						<input type="text" class="form-control ${(nameError??)?string('is-invalid', '')} mt-2" value="<#if employee??>${employee.name}</#if>" name="name" placeholder="Enter name">
						<#if nameError??>
							<div class="invalid-feedback">
								${nameError}
							</div>
						</#if>
					</div>	
			</div>
			
			<div class="row mb-1">	
				<label class="col-sm-3 col-form-label">Last name</label>
					<div class="form-group col-sm-8">
						<input type="text" class="form-control ${(lastNameError??)?string('is-invalid', '')} mt-2" value="<#if employee??>${employee.lastName}</#if>" name="lastName" placeholder="Enter last name">
						<#if lastNameError??>
							<div class="invalid-feedback">
								${lastNameError}
							</div>
						</#if>
					</div>
			</div>
					
			<div class="row mb-1">	
				<label class="col-sm-3 col-form-label">Position</label>
					<div class="form-group col-sm-8">
						<input type="text" class="form-control ${(positionError??)?string('is-invalid', '')} mt-2" value="<#if employee??>${employee.position}</#if>" name="position" placeholder="Enter position">
						<#if positionError??>
							<div class="invalid-feedback">
								${positionError}
							</div>
						</#if>
					</div>	
			</div>
			
			<div class="row mb-1">	
				<label class="col-sm-3 col-form-label">Date of birth</label>
					<div class="form-group col-sm-8">
						<input type="text" class="form-control ${(dateOfBirthError??)?string('is-invalid', '')} mt-2" value="<#if employee??>${employee.dateOfBirth}</#if>" name="dateOfBirth" placeholder="Enter date of birth">
						<#if dateOfBirthError??>
							<div class="invalid-feedback">
								${dateOfBirthError}
							</div>
						</#if>
					</div>	
			</div>
			
			<div class="row mb-1">	
				<label class="col-sm-3 col-form-label">Mobile phone</label>
					<div class="form-group col-sm-8">
						<input type="text" class="form-control ${(mobilePhoneError??)?string('is-invalid', '')} mt-2" value="<#if employee??>${employee.mobilePhone}</#if>" name="mobilePhone" placeholder="Enter mobile phone">
						<#if mobilePhoneError??>
							<div class="invalid-feedback">
								${mobilePhoneError}
							</div>
						</#if>
					</div>
			</div>
					
			<div class="row mb-1">	
				<label class="col-sm-3 col-form-label">Email</label>
					<div class="form-group col-sm-8">
						<input type="text" class="form-control ${(emailError??)?string('is-invalid', '')} mt-2" value="<#if employee??>${employee.email}</#if>" name="email" placeholder="Enter eMail">
						<#if emailError??>
							<div class="invalid-feedback">
								${emailError}
							</div>
						</#if>
					</div>	
			</div>	
			
			<div class="form-group col-sm-11">
				<div class="custom-file">
					<input type="file" name="file" id="customFile" multiple accept="image/*,image/jpeg">
					<label class="custom-file-label" for="customFile">Choose file</label>
				</div>
			</div>
				<input type="hidden" name="id" value="<#if employee??>${employee.id}</#if>" />				
			<div class="d-flex justify-content-between">
				<div>
					<button type="submit" class="btn btn-primary mb-4">Save changes</button>
				</div>
				<div>
					<form action="/employee/${employee.id}/remove" method="post" enctype="multipart/form-data">
						<button type="submit" class="btn btn-danger mb-4">Delete</button>
					</form>
				</div>
			</div>      	   	
		</form>									
</div>	

</@c.page>