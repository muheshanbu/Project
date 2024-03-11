package com.ford.apps.repository;

import com.ford.apps.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICompanyRepository extends JpaRepository<Company,Long> {
    //........xxxxxx
    List<Company> findByCompanyName(String name);

}
