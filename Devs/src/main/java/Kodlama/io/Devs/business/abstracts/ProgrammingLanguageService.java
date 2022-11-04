package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.response.programmingLanguage.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.response.programmingLanguage.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {

    List<GetAllProgrammingLanguageResponse> getAll();
	
	GetByIdProgrammingLanguageResponse getById(int id);
	
	void create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
}
