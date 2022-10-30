package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	
	
	public InMemoryProgrammingLanguage() {
		programmingLanguages = new ArrayList<>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Python"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId()== id) return programmingLanguage;
		}
		return null;
	}

	@Override
	public void create(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		var result = getById(programmingLanguage.getId());
		result.setName(programmingLanguage.getName());
		
	}

	@Override
	public void delete(int id) {
		
		var result = getById(id);
		programmingLanguages.remove(result);
		
		
	}

}
