package com.ford.apps.repository;

import com.ford.apps.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRespository extends JpaRepository<Company,Long> {

}
