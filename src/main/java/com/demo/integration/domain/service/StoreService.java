package com.demo.integration.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.demo.integration.model.CreateAccountDTO;
import com.demo.integration.model.CreateDTO;
import com.demo.integration.model.DataDTO;

/**
 * Clase que implementa los metodos CRUD de IStorageService
 * 
 * @author OmarBarrera
 */
@Service
public class StoreService implements IStorageService {

	/**
	 * Constructor por default de la clase
	 */
	public StoreService() {
		super();
	}

	/**
	 * Variable con los datos almacenados
	 */
	private static List<DataDTO> subjectsLoaded = new ArrayList<>();
	
	
	/**
	 * Variable con las cuentas almacenadas
	 */
	private static List<CreateAccountDTO> cuentasRegistradas = new ArrayList<>();

	/**
	 * Metodo que guarda el registro
	 * 
	 * @param data datos del registro
	 * @return boolean, true= si el guardado fue exitoso
	 */
	public boolean createData(CreateDTO data) {
		boolean result = false;
		String generatedString = RandomStringUtils.randomAlphanumeric(16);
		DataDTO dd = new DataDTO(generatedString, data.getUser(),data.getCategoria(), data.getData());
		DataDTO existe = subjectsLoaded.stream().filter(x -> dd.getUser().equalsIgnoreCase(x.getUser()))
				.filter(x -> dd.getId().equalsIgnoreCase(x.getId())).findFirst().orElse(null);
		if (existe == null) {
			subjectsLoaded.add(dd);
			result = true;
		}
		return result;
	}
	
	/**
	 * Metodo que guarda el registro
	 * 
	 * @param data datos del registro
	 * @return boolean, true= si el guardado fue exitoso
	 */
	public boolean createAccount(CreateAccountDTO data) {
		boolean result = false;
		CreateAccountDTO existe = cuentasRegistradas.stream().
				filter(x -> data.getEmail().equalsIgnoreCase(x.getEmail()))
				.findFirst().orElse(null);
		if (existe == null) {
			cuentasRegistradas.add(data);
			result = true;
		}
		return result;
	}
	
	/**
	 * Metodo que guarda el registro
	 * 
	 * @param data datos del registro
	 * @return boolean, true= si el guardado fue exitoso
	 */
	public boolean validaAccount(CreateAccountDTO data) {
		boolean result = false;
		CreateAccountDTO existe = cuentasRegistradas.stream()
				.filter(x -> data.getEmail().equalsIgnoreCase(x.getEmail()))
				.filter(x -> data.getPassword().equals(x.getPassword()))
				.findFirst().orElse(null);
		if (existe != null) {
			result = true;
		}
		return result;
	}

	/**
	 * Metodo que retorna todos los elementos almacenados
	 * 
	 * @return lista de datos
	 */
	public List<DataDTO> readAllData(String user,String categoria) {
		if(categoria==null || categoria.isEmpty()) {
			return subjectsLoaded.stream()
					.filter(x -> user.equalsIgnoreCase(x.getUser()))
					.collect(Collectors.toList());
		}else {
			return subjectsLoaded.stream()
					.filter(x -> user.equalsIgnoreCase(x.getUser()))
					.filter(x -> categoria.equalsIgnoreCase(x.getCategoria()))
					.collect(Collectors.toList());
		}
		
	}

	/**
	 * Metodo que retorna los datos del registro
	 * 
	 * @param id, identificador del registro a obtener
	 * @return datos del registro
	 */
	public DataDTO readData(String id,String user) {
		return subjectsLoaded.stream()
				.filter(x -> user.equalsIgnoreCase(x.getUser()))
				.filter(x -> id.equalsIgnoreCase(x.getId()))
				.findFirst().orElse(null);
	}

	/**
	 * Metodo que actualiza el registro
	 * 
	 * @param data registro a actualizar
	 * @return boolean, true si la actualizacion fue exitosa
	 */
	public boolean updateData(DataDTO data) {
		boolean result = false;
		OptionalInt indexOpt = IntStream.range(0, subjectsLoaded.size())
				.filter(i -> data.getId().equalsIgnoreCase(subjectsLoaded.get(i).getId())).findFirst();
		if (indexOpt.isPresent()) {
			result = true;
			subjectsLoaded.set(indexOpt.getAsInt(), data);
		}
		return result;
	}

	/**
	 * Metodo que elimina el registro con identificador id
	 * 
	 * @param id, identificador a eliminar
	 * @return boolean, true si el registro se elimino correctamente
	 */
	public boolean deleteData(String id) {
		return subjectsLoaded.removeIf(x -> id.equalsIgnoreCase(x.getId()));
	}

	/**
	 * Metodo que elimina todos los registros almacenados
	 * 
	 * @return boolean,true si se eliminaron los registros de manera correcta
	 */
	public boolean deleteAllData(String user,String categoria) {
		if(categoria==null || categoria.isEmpty()) {
			return subjectsLoaded.removeIf(x -> x.getUser().equalsIgnoreCase(user));
		}else {
			return subjectsLoaded.removeAll(
					subjectsLoaded.stream()
					.filter(x -> user.equalsIgnoreCase(x.getUser()))
					.filter(x -> categoria.equalsIgnoreCase(x.getCategoria()))
					.collect(Collectors.toList()));
		}
		
	}

}
