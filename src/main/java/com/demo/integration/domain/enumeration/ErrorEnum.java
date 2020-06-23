package com.demo.integration.domain.enumeration;

import com.demo.integration.domain.utils.LevelsConstantes;

/**
 * @author OmarBarrera
 * The Enum ErrorEnum.
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio 
 */
public enum ErrorEnum {

	EXC_GENERICO("EXC.000", "Error generico", "Error generico de servidor", LevelsConstantes.ERROR, ""),
	EXC_ERROR_PARAMS("EXC.001", "Parametros invalidos", "Parametros invalidos de consumo", LevelsConstantes.WARNING,
			""),
	EXC_DUPLICADO("EXC.100", "Account duplicado", "Account ya existe, no puede ser sobrescrita",
			LevelsConstantes.WARNING, ""),
	EXC_INEXISTENTE("EXC.101", "Account inexistente", "Account no existe, intente con otro valor",
			LevelsConstantes.WARNING, ""),
	EXC_OPER_NO_EXITOSA("EXC.102", "Operacion no exitosa", "Operacion no exitosa", LevelsConstantes.ERROR, ""),
	EXC_ERROR_DE_CONEXION("EXC.122", "Error de conexión", LevelsConstantes.ERROR, "Erro de conexión", ""),
	EXC_OPER_CON_ERRORES("EXC.103", "Operacion con errores", "Operacion con errores", LevelsConstantes.ERROR, "");

	/**
	 * variable que encapsula el codigo del error
	 */
	private final String code;

	/**
	 *  variable que encapsula el mensaje del error
	 */
	private final String message;

	/**
	 * variable que encapsula la descripcion del error
	 */
	private final String description;

	/**
	 * variable que encapsula el nivel del error
	 */
	private final String level;

	/**
	 * variable que encapsula la informacion del error
	 */
	private final String moreInfo;

	/**
	 * Constructor que define el enum del error
	 * @param code codigo del error
	 * @param message mensaje del error
	 * @param description descripcion del error
	 * @param level nivel de error
	 * @param moreInfo informacion del error
	 */
	ErrorEnum(final String code, final String message, final String description, final String level,
			final String moreInfo) {
		this.code = code;
		this.message = message;
		this.description = description;
		this.level = level;
		this.moreInfo = moreInfo;
	}

	/**
	 * Metodo que retorna el codigo de error
	 * @return el codigo de error
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Metodo que retorna el mensaje de error
	 * @return el mensaje de error
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Metodo que retorna la descripcion del error
	 * @return al descripcion del error
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo que retorna el nivel de error
	 * @return el nivel de error
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Metodo que retorna la informacion de error
	 * @return la informacion  del error
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

}
