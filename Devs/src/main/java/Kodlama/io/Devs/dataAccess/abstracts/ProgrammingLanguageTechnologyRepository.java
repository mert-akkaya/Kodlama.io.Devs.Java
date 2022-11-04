package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguageTechnology;

public interface ProgrammingLanguageTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology, Integer> {

}
