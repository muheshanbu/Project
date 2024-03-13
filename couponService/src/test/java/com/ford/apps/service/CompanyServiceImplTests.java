package com.ford.apps.service;

import com.ford.apps.dto.CompanyDTO;
import com.ford.apps.entity.Company;
import com.ford.apps.repository.ICompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyServiceImplTests {

    @Mock
    private ICompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCompany() {
// Given
        CompanyDTO companyDTO = new CompanyDTO("Test Company");
        Company company = new Company();
        company.setCompanyName(companyDTO.getName());
        given(companyRepository.save(any(Company.class))).willReturn(company);

// When
        Company savedCompany = companyService.addCompany(companyDTO);

// Then
        assertNotNull(savedCompany);
        assertEquals("Test Company", savedCompany.getCompanyName());
        then(companyRepository).should().save(any(Company.class));
    }

    @Test
    public void testDeleteCompany() {
// Given
        Long companyId = 1L;
        willDoNothing().given(companyRepository).deleteById(companyId);

// When
        companyService.deleteCompany(companyId);

// Then
        then(companyRepository).should().deleteById(companyId);
    }

    @Test
    public void testGetAllCompanies() {
// Given
        List<Company> companies = List.of(new Company(), new Company());
        given(companyRepository.findAll()).willReturn(companies);

// When
        List<Company> foundCompanies = companyService.getAllCompanies();

// Then
        assertNotNull(foundCompanies);
        assertEquals(2, foundCompanies.size());
        then(companyRepository).should().findAll();
    }

    @Test
    public void testGetCompanyByIdFound() {
// Given
        Long companyId = 1L;
        Optional<Company> company = Optional.of(new Company());
        given(companyRepository.findById(companyId)).willReturn(company);

// When
        Company foundCompany = companyService.getCompanyById(companyId);

// Then
        assertNotNull(foundCompany);
        then(companyRepository).should().findById(companyId);
    }


    @Test
    public void testGetCompanyByIdNotFound() {
// Given
        Long companyId = 1L;
        given(companyRepository.findById(companyId)).willReturn(Optional.empty());

// When
        Company foundCompany = companyService.getCompanyById(companyId);

// Then
        assertNull(foundCompany);
        then(companyRepository).should().findById(companyId);
    }


    @Test
    public void testGetCompanyByName() {
// Given
        String companyName = "Test Company";
        Company company = new Company();
        company.setCompanyName(companyName);
        given(companyRepository.findByCompanyName(companyName)).willReturn(company);

// When
        Company foundCompany = companyService.getCompanyByName(companyName);

// Then
        assertNotNull(foundCompany);
        assertEquals(companyName, foundCompany.getCompanyName());
        then(companyRepository).should().findByCompanyName(companyName);


    }
}

