package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.response.programmingLanguage.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.response.programmingLanguage.GetByIdProgrammingLanguageResponse;
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
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = _programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
			response.setId(programmingLanguage.getId());
			response.setName(programmingLanguage.getName());
			programmingLanguageResponses.add(response);
		}
	
		return programmingLanguageResponses;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		
		ProgrammingLanguage programmingLanguage = _programmingLanguageRepository.findById(id).get();
		GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
		response.setId(programmingLanguage.getId());
		response.setName(programmingLanguage.getName());
		return response;
	}

	@Override
	public void create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if(!isLanguageExit(createProgrammingLanguageRequest)) throw new Exception("Language name already exist");
		if(isLanguageEmpty(createProgrammingLanguageRequest)) throw new Exception("Language name is not empty");
		
		 ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

         programmingLanguage.setName(createProgrammingLanguageRequest.getName());
         
		_programmingLanguageRepository.save(programmingLanguage);
		 
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		
		ProgrammingLanguage programmingLanguage = _programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId()).get();

        programmingLanguage.setName(updateProgrammingLanguageRequest.getName());

        _programmingLanguageRepository.save(programmingLanguage);
		
		
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		_programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
		
	}
	
	
	public boolean isLanguageExit (CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
		var result = _programmingLanguageRepository.findAll();
		for (ProgrammingLanguage lang : result) {
			if(lang.getName().equals(createProgrammingLanguageRequest.getName()) ) 
				return false;
		}
		return true;
	}
	
	public boolean isLanguageEmpty (CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
		return createProgrammingLanguageRequest.getName().isEmpty() || createProgrammingLanguageRequest.getName().isBlank();
	}

}
