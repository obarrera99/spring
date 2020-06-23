package com.demo.integration.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

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
	 * Metodo que guarda el registro
	 * 
	 * @param data datos del registro
	 * @return boolean, true= si el guardado fue exitoso
	 */
	public boolean createData(DataDTO data) {
		boolean result = false;
		DataDTO existe = subjectsLoaded.stream().filter(x -> data.getId().equalsIgnoreCase(x.getId())).findFirst()
				.orElse(null);
		if (existe == null) {
			subjectsLoaded.add(data);
			result = true;
		}
		return result;
	}

	/**
	 * Metodo que retorna todos los elementos almacenados
	 * 
	 * @return lista de datos
	 */
	public List<DataDTO> readAllData() {
		return subjectsLoaded.stream().collect(Collectors.toList());
	}

	/**
	 * Metodo que retorna los datos del registro
	 * 
	 * @param id, identificador del registro a obtener
	 * @return datos del registro
	 */
	public DataDTO readData(String id) {
		return subjectsLoaded.stream().filter(x -> id.equalsIgnoreCase(x.getId())).findFirst().orElse(null);
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
		return subjectsLoaded.removeIf(x -> x.getId().equalsIgnoreCase(id));
	}

	/**
	 * Metodo que elimina todos los registros almacenados
	 * 
	 * @return boolean,true si se eliminaron los registros de manera correcta
	 */
	public boolean deleteAllData() {
		return subjectsLoaded.removeAll(subjectsLoaded);
	}

}
