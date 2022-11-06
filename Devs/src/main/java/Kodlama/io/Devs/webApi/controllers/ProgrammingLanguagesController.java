package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.response.programmingLanguage.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.response.programmingLanguage.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService _programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService _programmingLanguageService) {
		this._programmingLanguageService = _programmingLanguageService;
	}
	
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageResponse> getAll(){
		return _programmingLanguageService.getAll();
		
	}
	
	@GetMapping("/{id}")
	public GetByIdProgrammingLanguageResponse getById(@PathVariable int id) {
		return _programmingLanguageService.getById(id);
		
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		_programmingLanguageService.create(createProgrammingLanguageRequest);
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		_programmingLanguageService.update(updateProgrammingLanguageRequest);
		
	}
	
	@DeleteMapping("/delete")
	public void delete( DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		_programmingLanguageService.delete(deleteProgrammingLanguageRequest);
		
	}
	
	
}
