package com.demo.integration.domain;

/**
 * @author OmarBarrera
 * Clase de exception de negocio
 */
public class ApiRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe el mensaje de error
	 * @param message Mensaje del la excepción
	 */
	public ApiRequestException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe una causa
	 * @param cause excepción lanzable
	 */
	public ApiRequestException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor
	 * @param message Mensaje de error
	 * @param cause   Causa completa del error
	 */
	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
