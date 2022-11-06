package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageTechnologyService;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.response.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologyResponse;
import Kodlama.io.Devs.business.response.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService {

    private ProgrammingLanguageTechnologyRepository _programmingLanguageTechnologyRepository;
    private ProgrammingLanguageRepository _programmingLanguageRepository;
 
    
	@Autowired
	public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository,ProgrammingLanguageRepository programmingLanguageRepository) {
		this._programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
		this._programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
		List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = _programmingLanguageTechnologyRepository.findAll();
		List<GetAllProgrammingLanguageTechnologyResponse> programmingLanguageTechnologyResponses = new ArrayList<>();
		
		for (ProgrammingLanguageTechnology programmingLanguageTechnology : programmingLanguageTechnologies) {
			GetAllProgrammingLanguageTechnologyResponse response = new GetAllProgrammingLanguageTechnologyResponse();
			response.setId(programmingLanguageTechnology.getId());
			response.setName(programmingLanguageTechnology.getName());
			response.setProgrammingLanguageName(programmingLanguageTechnology.getProgrammingLanguage().getName());
			programmingLanguageTechnologyResponses.add(response);
		}
	
		return programmingLanguageTechnologyResponses;
	}

	@Override
	public GetByIdProgrammingLanguageTechnologyResponse getById(int id) {
		
		ProgrammingLanguageTechnology programmingLanguageTechnology = _programmingLanguageTechnologyRepository.findById(id).get();
		GetByIdProgrammingLanguageTechnologyResponse response = new GetByIdProgrammingLanguageTechnologyResponse();
		response.setId(programmingLanguageTechnology.getId());
		response.setName(programmingLanguageTechnology.getName());
		return response;
	}

	@Override
	public void create(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
		if(!isLanguageTechnologyExit(createProgrammingLanguageTechnologyRequest)) throw new Exception("Technology Language name already exist");
		if(isLanguageTechnologyEmpty(createProgrammingLanguageTechnologyRequest)) throw new Exception("Technology Language name is not empty");
		
		 ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
		 
		ProgrammingLanguage programmingLanguage = _programmingLanguageRepository.findById(createProgrammingLanguageTechnologyRequest.getProgrammingLanguageId()).get();
		
		 programmingLanguageTechnology.setName(createProgrammingLanguageTechnologyRequest.getName());
		 programmingLanguageTechnology.setProgrammingLanguage(programmingLanguage);
         
		 _programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
		 
	}

	@Override
	public void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) {
		
		ProgrammingLanguageTechnology programmingLanguageTechnology = _programmingLanguageTechnologyRepository.findById(updateProgrammingLanguageTechnologyRequest.getId()).get();

		programmingLanguageTechnology.setName(updateProgrammingLanguageTechnologyRequest.getName());

		_programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
		
		
	}

	@Override
	public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {
		_programmingLanguageTechnologyRepository.deleteById(deleteProgrammingLanguageTechnologyRequest.getId());
		
	}
	
	
	public boolean isLanguageTechnologyExit (CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest){
		var result = _programmingLanguageTechnologyRepository.findAll();
		for (ProgrammingLanguageTechnology languageTechnology : result) {
			if(languageTechnology.getName().equals(createProgrammingLanguageTechnologyRequest.getName()) ) 
				return false;
		}
		return true;
	}
	
	public boolean isLanguageTechnologyEmpty (CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest){
		return createProgrammingLanguageTechnologyRequest.getName().isEmpty() || createProgrammingLanguageTechnologyRequest.getName().isBlank();
	}
}
