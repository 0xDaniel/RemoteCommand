package com.daniel.project.repository;

import java.util.Optional;

import com.daniel.project.models.ERole;
import com.daniel.project.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

	Optional<Role> findByName(ERole name);
}
