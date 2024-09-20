package org.negi.auction_backend.repository;

import org.negi.auction_backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
