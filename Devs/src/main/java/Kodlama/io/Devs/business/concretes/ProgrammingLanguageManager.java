package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;


@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	
	private ProgrammingLanguageRepository _programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository _programmingLanguageRepository) {
		this._programmingLanguageRepository = _programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return _programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return _programmingLanguageRepository.getById(id);
	}

	@Override
	public void create(ProgrammingLanguage programmingLanguage) throws Exception {
		if(!isLanguageExit(programmingLanguage)) throw new Exception("Language name already exist");
		if(isLanguageEmpty(programmingLanguage)) throw new Exception("Language name is not empty");
		_programmingLanguageRepository.create(programmingLanguage);
		 
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		_programmingLanguageRepository.update(programmingLanguage);
		
		
	}

	@Override
	public void delete(int id) {
		_programmingLanguageRepository.delete(id);
		
	}
	
	
	public boolean isLanguageExit (ProgrammingLanguage programmingLanguage){
		var result = _programmingLanguageRepository.getAll();
		for (ProgrammingLanguage lang : result) {
			if(lang.getName().equals(programmingLanguage.getName()) ) 
				return false;
		}
		return true;
	}
	
	public boolean isLanguageEmpty (ProgrammingLanguage programmingLanguage){
		return programmingLanguage.getName().isEmpty() || programmingLanguage.getName().isBlank();
	}

}
