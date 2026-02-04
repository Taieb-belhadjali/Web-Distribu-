package tn.managementuser.repository;

import org.springframework.data.repository.CrudRepository;
import tn.managementuser.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
