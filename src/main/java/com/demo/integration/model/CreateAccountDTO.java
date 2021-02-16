package com.demo.integration.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
public class CreateAccountDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * email del registro
	 */
	@NotNull(message = "email no puede ser nulo o vacio")
	@NotEmpty(message = "email no puede ser nulo o vacio")
	@NotBlank(message = "email no puede ser nulo o vacio")
	private String email;
	
	
	/**
	 * password del registro
	 */
	@NotNull(message = "password no puede ser nulo o vacio")
	@NotEmpty(message = "password no puede ser nulo o vacio")
	@NotBlank(message = "password no puede ser nulo o vacio")
	private String password;
	

	private String nombre;
	
	

	/**
	 * Constructor que define la información principal de los datos
	 * @param id del dato
	 * @param data del registro
	 */
	public CreateAccountDTO(String email,String password,String nombre) {
		this.email = email;
		this.password=password;
		this.nombre=nombre;
	}

}
