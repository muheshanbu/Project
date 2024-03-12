package com.ford.apps.repository;

import com.ford.apps.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
    //........xxxxxx
    Company findByCompanyName(String name);

}
