package com.demo.integration.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.demo.integration.model.CreateAccountDTO;
import com.demo.integration.model.CreateDTO;
import com.demo.integration.model.DataDTO;

/**
 * Interfaz con metodos CRUD
 * 
 * @author OmarBarrera
 */
@Service
public interface IStorageService {

	/**
	 * Metodo que guarda el registro
	 * 
	 * @param data datos del registro
	 * @return boolean, true= si el guardado fue exitoso
	 */
	boolean createData(CreateDTO data);
	
	/**
	 * Metodo que guarda el registro
	 * 
	 * @param data datos del registro
	 * @return boolean, true= si el guardado fue exitoso
	 */
	boolean createAccount(CreateAccountDTO data);
	
	/**
	 * Metodo que guarda el registro
	 * 
	 * @param data datos del registro
	 * @return boolean, true= si el guardado fue exitoso
	 */
	boolean validaAccount(CreateAccountDTO data);

	/**
	 * Metodo que retorna todos los elementos almacenados
	 * 
	 * @return lista de datos
	 */
	List<DataDTO> readAllData(String user,String categoria);

	/**
	 * Metodo que retorna los datos del registro
	 * 
	 * @param id, identificador del registro a obtener
	 * @return datos del registro
	 */
	DataDTO readData(String id,String user);

	/**
	 * Metodo que actualiza el registro
	 * 
	 * @param data registro a actualizar
	 * @return boolean, true si la actualizacion fue exitosa
	 */
	boolean updateData(DataDTO data);

	/**
	 * Metodo que elimina el registro con identificador id
	 * 
	 * @param id, identificador a eliminar
	 * @return boolean, true si el registro se elimino correctamente
	 */
	boolean deleteData(String id);

	/**
	 * Metodo que elimina todos los registros almacenados
	 * 
	 * @return boolean,true si se eliminaron los registros de manera correcta
	 */
	boolean deleteAllData(String user,String categoria);

}
