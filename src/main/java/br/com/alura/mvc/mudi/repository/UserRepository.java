package br.com.alura.mvc.mudi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.mvc.mudi.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	User findByUsername(String username);
	
}
