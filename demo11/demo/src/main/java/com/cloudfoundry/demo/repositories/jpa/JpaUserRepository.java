package com.cloudfoundry.demo.repositories.jpa;


import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudfoundry.demo.bean.User;

@Repository
@Profile({"in-memory", "mysql", "postgres", "oracle", "sqlserver"})
public interface JpaUserRepository extends JpaRepository<User, String> {
}
