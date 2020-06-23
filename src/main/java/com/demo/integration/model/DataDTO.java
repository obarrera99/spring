package com.demo.integration.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

/**
 * Esta clase define la estructura de los datos
 * @author OmarBarrera 
 */

@Data
public class DataDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * identificador del registro
	 */
	@NotNull(message = "id no puede ser nulo o vacio")
	@NotEmpty(message = "id no puede ser nulo o vacio")
	@NotBlank(message = "id no puede ser nulo o vacio")
	private String id;

	/**
	 * data del registro
	 */
	@NotNull(message = "data no puede ser nulo o vacio")
	@NotEmpty(message = "data no puede ser nulo o vacio")
	@NotBlank(message = "data no puede ser nulo o vacio")
	private JsonNode data;

	/**
	 * Constructor que define la información principal de los datos
	 * @param id del dato
	 * @param data del registro
	 */
	public DataDTO(String id,JsonNode data) {
		this.id = id;
		this.data=data;
	}

}
