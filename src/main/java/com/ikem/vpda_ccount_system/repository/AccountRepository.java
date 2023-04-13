package com.ikem.vpda_ccount_system.repository;

import com.ikem.vpda_ccount_system.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(nativeQuery = true, value = "SELECT IFNULL(MAX(account_number), '0') FROM account")
    String findLastAccountNumber();

}
