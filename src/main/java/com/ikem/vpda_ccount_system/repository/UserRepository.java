package com.ikem.vpda_ccount_system.repository;

import com.ikem.vpda_ccount_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByBvn(Long bvn);
}
