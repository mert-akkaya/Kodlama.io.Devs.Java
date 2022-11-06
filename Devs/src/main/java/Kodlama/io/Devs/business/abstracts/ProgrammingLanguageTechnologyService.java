package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.response.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologyResponse;
import Kodlama.io.Devs.business.response.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologyResponse;

public interface ProgrammingLanguageTechnologyService {
	
    List<GetAllProgrammingLanguageTechnologyResponse> getAll();
	
	GetByIdProgrammingLanguageTechnologyResponse getById(int id);
	
	void create(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception;
	
	void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest);
	
	void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest);
}
