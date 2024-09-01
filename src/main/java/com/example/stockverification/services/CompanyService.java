package com.example.stockverification.services;

import com.example.stockverification.Util.CommonMsg;
import com.example.stockverification.dto.CompanyDTO;
import com.example.stockverification.entity.Company;
import com.example.stockverification.repository.CompanyRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String SaveCompany(CompanyDTO companyDTO) {
        // Check if comId or comCode already exists
        if (companyRepo.existsById(companyDTO.getComId())) {
            return CommonMsg.RSP_DUPLICATED;
        } else if (companyRepo.existsByComCode(companyDTO.getComCode())) {
            return CommonMsg.RSP_Code_DUPLICATED;  // Return duplicate code message
        } else {
            companyRepo.save(modelMapper.map(companyDTO, Company.class));
            return CommonMsg.RSP_SUCCESS;
        }
    }

    public String UpdateCompany(CompanyDTO companyDTO) {
        // Check if comId or comCode already exists
        if (companyRepo.existsById(companyDTO.getComId())&&companyRepo.existsByComCode(companyDTO.getComCode())) {
            companyRepo.save(modelMapper.map(companyDTO, Company.class));
            return CommonMsg.RSP_SUCCESS;
        }  else {
            return CommonMsg.RSP_DATA_NOT_fOUND;
        }
    }
    public List<CompanyDTO> getAllCompany(){
        List<Company> companyList = companyRepo.findAll();
        return modelMapper.map(companyList, new TypeToken<ArrayList<CompanyDTO>>(){}.getType());
    }
}
