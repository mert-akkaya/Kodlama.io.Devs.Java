package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService _programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService _programmingLanguageService) {
		this._programmingLanguageService = _programmingLanguageService;
	}
	
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return _programmingLanguageService.getAll();
		
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable int id) {
		return _programmingLanguageService.getById(id);
		
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		_programmingLanguageService.create(programmingLanguage);
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage) {
		_programmingLanguageService.update(programmingLanguage);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		_programmingLanguageService.delete(id);
		
	}
	
	
}
