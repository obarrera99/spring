package com.demo.integration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.integration.domain.service.IStorageService;
import com.demo.integration.model.DataDTO;

/**
 * Clase de tipo RestController
 * @author OmarBarrera
 */
@RestController
public class IntegrationController {

	/**
	 * Constructor de la clase
	 */
	IntegrationController() {
		super();
	}

	/**
	 * Instancia a storageService
	 */
	@Autowired
	private IStorageService storageService;

	/**
	 * EndPoint que guarda el registro
	 * @param data
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping(value = "/createData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createData(@RequestBody(required = true) DataDTO data,
			RedirectAttributes redirectAttributes) {
		String mensaje = "error";
		HttpStatus code = HttpStatus.NOT_ACCEPTABLE;
		if (storageService.createData(data)) {
			code = HttpStatus.OK;
			mensaje = "Correcto";
		}
		return new ResponseEntity<>(mensaje, code);
	}

	/**
	 * EndPoint que obtiene todos los registros
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping(value = "/readAllData", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DataDTO> readAllData(RedirectAttributes redirectAttributes) {
		return storageService.readAllData();
	}

	/**
	 * EndPoint que obtiene un registro con identificador id
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping(value = "/readData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readData(@Valid @RequestParam(value = "id", required = true) String id,
			RedirectAttributes redirectAttributes) {
		HttpStatus code = HttpStatus.NOT_ACCEPTABLE;
		DataDTO data = storageService.readData(id);
		if (data != null) {
			code = HttpStatus.OK;
		}
		return new ResponseEntity<>(data, code);
	}

	/**
	 * EndPoint que actualiza el registro data
	 * @param data
	 * @param redirectAttributes
	 * @return
	 */
	@PutMapping(value = "/updateData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateData(@RequestBody(required = true) DataDTO data,
			RedirectAttributes redirectAttributes) {
		String mensaje = "error";
		HttpStatus code = HttpStatus.NOT_ACCEPTABLE;
		if (storageService.updateData(data)) {
			code = HttpStatus.OK;
			mensaje = "Correcto";
		}
		return new ResponseEntity<>(mensaje, code);
	}

	/**
	 * EndPoint que elimina todos los registros
	 * @param redirectAttributes
	 * @return
	 */
	@DeleteMapping(value = "/deleteAllData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteAllData(RedirectAttributes redirectAttributes) {
		String mensaje = "error";
		HttpStatus code = HttpStatus.NOT_ACCEPTABLE;
		if (storageService.deleteAllData()) {
			code = HttpStatus.OK;
			mensaje = "Correcto";
		}
		return new ResponseEntity<>(mensaje, code);
	}

	/**
	 * EndPoint que elimina el registro con identificador id
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@DeleteMapping(value = "/deleteData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteData(@Valid @RequestParam(value = "id", required = true) String id,
			RedirectAttributes redirectAttributes) {
		String mensaje = "error";
		HttpStatus code = HttpStatus.NOT_ACCEPTABLE;
		if (storageService.deleteData(id)) {
			code = HttpStatus.OK;
			mensaje = "Correcto";
		}
		return new ResponseEntity<>(mensaje, code);
	}

}
