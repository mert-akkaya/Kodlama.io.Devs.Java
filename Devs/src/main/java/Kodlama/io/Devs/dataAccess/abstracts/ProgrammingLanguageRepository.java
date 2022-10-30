package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	List<ProgrammingLanguage> getAll();
	
	ProgrammingLanguage getById(int id);
	
	void create(ProgrammingLanguage programmingLanguage);
	
	void update(ProgrammingLanguage programmingLanguage);
	
	void delete(int id);
}