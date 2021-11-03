package com.kove.pcstore.data;

import com.kove.pcstore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String>,UserRepositoryCustom{}

