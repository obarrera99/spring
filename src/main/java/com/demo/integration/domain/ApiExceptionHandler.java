package com.demo.integration.domain;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.demo.integration.domain.enumeration.ErrorEnum;
import com.demo.integration.exception.ChunkException;
import com.demo.integration.model.DefaultErrorDTO;
import com.demo.integration.model.DefaultErrorListDTO;

/**
 * @author OmarBarrera 
 * Esta clase se encarga de servir como apoyo al controller, manejando de manera desacoplada
 */
@ControllerAdvice
public class ApiExceptionHandler {

	/**
	 * Manejo de excepciones de negocio
	 * @param pe Excepcion generica de tipo SelfieException
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
	@ExceptionHandler(ChunkException.class)		
	public ResponseEntity<DefaultErrorListDTO> exception(ChunkException pe) {			
		String[] mesage =  pe.getMessage().split("\\:");
		DefaultErrorDTO d = new DefaultErrorDTO(pe.getHttpError(), mesage[0], pe.getCause().toString());
		return new ResponseEntity<>(new DefaultErrorListDTO(d), pe.getHttpCode());	
		}
	
	/**
	 * Manejo de excepciones de validacion de argumentos de entrada
	 * @param pe Excepcion de tipo MethodArgumentNotValidException
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
	@ExceptionHandler(value = { ApiRequestException.class })
	public ResponseEntity<DefaultErrorListDTO> handleApiRequestException(ApiRequestException pe) {
		return new ResponseEntity<DefaultErrorListDTO>(
				new DefaultErrorListDTO(new DefaultErrorDTO(ErrorEnum.EXC_ERROR_PARAMS, pe.getMessage())),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Manejo de excepciones de validacion de argumentos de entrada
	 * @param pe Excepcion de tipo MethodArgumentNotValidException
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<DefaultErrorListDTO> handleValidationExceptionA(MethodArgumentNotValidException pe) {
		return new ResponseEntity<DefaultErrorListDTO>(new DefaultErrorListDTO(
				new DefaultErrorDTO(ErrorEnum.EXC_ERROR_PARAMS, pe.getBindingResult().getFieldError().toString())),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Manejo de excepciones de validacion de formatos de numeros de entrada
	 * @param pe Excepcion de tipo NumberFormatException
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
	@ExceptionHandler(value = { NumberFormatException.class })
	public ResponseEntity<DefaultErrorListDTO> handleValidationExceptionB(NumberFormatException pe) {
		return new ResponseEntity<DefaultErrorListDTO>(
				new DefaultErrorListDTO(new DefaultErrorDTO(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Manejo de excepciones de validacion de tipo de datos de entrada	 
	 * @param pe Excepcion de tipo MethodArgumentTypeMismatchException
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
	@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class })
	public ResponseEntity<DefaultErrorListDTO> handleValidationExceptionC(MethodArgumentTypeMismatchException pe) {
		return new ResponseEntity<DefaultErrorListDTO>(
				new DefaultErrorListDTO(new DefaultErrorDTO(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Manejo de excepciones de validacion de cantidad de parametros de entrada enviados 
	 * @param pe Excepcion de tipo MissingServletRequestParameterException
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
	@ExceptionHandler(value = { MissingServletRequestParameterException.class })
	public ResponseEntity<DefaultErrorListDTO> handleValidationExceptionD(MissingServletRequestParameterException pe) {
		return new ResponseEntity<DefaultErrorListDTO>(
				new DefaultErrorListDTO(new DefaultErrorDTO(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * Manejo de excepcion generica 
	 * @param ex Excepcion generica de tipo Exception
	 * @return La entidad de respuesta que maneja el error como objeto
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<DefaultErrorListDTO> handleGenericException(Exception ex) {
		return new ResponseEntity<DefaultErrorListDTO>(
				new DefaultErrorListDTO(new DefaultErrorDTO(ErrorEnum.EXC_GENERICO)), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
