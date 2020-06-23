package com.demo.integration.exception;

import org.springframework.http.HttpStatus;

import com.demo.integration.domain.enumeration.ErrorEnum;

/**
 * Esta clase define la estructura de las excepciones
 * 
 * @author OmarBarrera
 */
public class ChunkException extends Exception {
	/**
	 * serialVersionUID Variable para serializar la clase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * La Constante MSG_ERROR_PROCESANDO_JSON. Obtiene el mensaje de error
	 * correspodiente
	 */
	public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
	/**
	 * La Constante ERROR_DE_SERVIDOR. Obtiene el mensaje de error correspodiente
	 */
	public static final String MSG_ERROR_EN_SERVIDOR = "ERRORES_DEL_SERVIDOR";
	/**
	 * La Constante ERRORES_DEL_CLIENTE. Obtiene el mensaje de error correspodiente
	 */
	public static final String MSG_ERROR_EN_CLIENTE = "ERRORES_DEL_CLIENTE";
	/**
	 * La Constante MSG_ERROR_DE_CONEXION. Obtiene el mensaje de error
	 * correspodiente
	 */
	public static final String MSG_ERROR_DE_CONEXION = "ERROR_DE_CONEXION";

	/**
	 * La Constante MSG_ERROR_PROCESANDO_EVIDENCIAS. Obtiene el mensaje de error
	 * correspodiente
	 */

	/**
	 * Constructor que recibe el mensaje de error
	 * 
	 * @param msg Mensaje del la excepción
	 */
	public ChunkException(String msg) {
		super(msg);
	}

	/**
	 * Constructor que recibe una causa
	 * 
	 * @param cause excepción lanzable
	 */
	public ChunkException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor que recibe el mensaje de error y causa
	 * 
	 * @param msg   mensaje
	 * @param cause excepción lanzable
	 */
	public ChunkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Método para devolver el código http
	 * 
	 * @return http estatus
	 */
	public HttpStatus getHttpCode() {
		HttpStatus httpstatus;
		switch (getMessage().split("\\:")[0]) {
		case INTERNAL_SERVER_ERROR:
			httpstatus = HttpStatus.INTERNAL_SERVER_ERROR;
			break;
		default:
			httpstatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return httpstatus;
	}

	/**
	 * Método para devolver el mensaje de la excepción
	 * 
	 * @return error mensaje.
	 */
	public ErrorEnum getHttpError() {
		ErrorEnum error;
		switch (getMessage().split("\\:")[0]) {
		case INTERNAL_SERVER_ERROR:
			error = ErrorEnum.EXC_OPER_CON_ERRORES;
			break;
		case MSG_ERROR_DE_CONEXION:
			error = ErrorEnum.EXC_ERROR_DE_CONEXION;
			break;
		default:
			error = ErrorEnum.EXC_GENERICO;
		}
		return error;
	}
}
