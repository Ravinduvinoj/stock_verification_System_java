package com.example.stockverification.controller;

import com.example.stockverification.Util.CommonMsg;
import com.example.stockverification.Util.CommonResponse;
import com.example.stockverification.dto.CompanyDTO;
import com.example.stockverification.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CommonResponse commonResponse;

    @PostMapping(value ="/saveCompany")
    public ResponseEntity saveCompany(@RequestBody CompanyDTO companyDTO){
        try {
            String res = companyService.SaveCompany(companyDTO);
            if (res.equals("00")){
                commonResponse.setCode(CommonMsg.RSP_SUCCESS);
                commonResponse.setMessage("Company Registered");
                commonResponse.setContent(companyDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.ACCEPTED);
            } else if (res.equals("02")) {
                commonResponse.setCode(CommonMsg.RSP_DUPLICATED);
                commonResponse.setMessage("Company Already Registered");
                commonResponse.setContent(companyDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.BAD_REQUEST);
            }else  if (res.equals("08")) {
                commonResponse.setCode(CommonMsg.RSP_Code_DUPLICATED);
                commonResponse.setMessage("Company Code Already Registered");
                commonResponse.setContent(companyDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.BAD_REQUEST);
            }else {
                commonResponse.setCode(CommonMsg.RSP_FAILED);
                commonResponse.setMessage("Error");
                commonResponse.setContent(null);
                return  new ResponseEntity(commonResponse, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            commonResponse.setCode(CommonMsg.RSP_ERROR);
            commonResponse.setMessage(ex.getMessage());
            commonResponse.setContent(null);
            return  new ResponseEntity(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PutMapping(value ="/updateCompany")
    public ResponseEntity updateCompany(@RequestBody CompanyDTO companyDTO){
        try {
            String res = companyService.UpdateCompany(companyDTO);
            if (res.equals("00")){
                commonResponse.setCode(CommonMsg.RSP_SUCCESS);
                commonResponse.setMessage("Company Updated");
                commonResponse.setContent(companyDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                commonResponse.setCode(CommonMsg.RSP_DUPLICATED);
                commonResponse.setMessage("No registered company");
                commonResponse.setContent(companyDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.BAD_REQUEST);
            }else {
                commonResponse.setCode(CommonMsg.RSP_FAILED);
                commonResponse.setMessage("Error");
                commonResponse.setContent(null);
                return  new ResponseEntity(commonResponse, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            commonResponse.setCode(CommonMsg.RSP_ERROR);
            commonResponse.setMessage(ex.getMessage());
            commonResponse.setContent(null);
            return  new ResponseEntity(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping(value="/getAllCompany")
    public ResponseEntity getAllCompany(){
        try{
        List<CompanyDTO> companyDTOList = companyService.getAllCompany();
            commonResponse.setCode(CommonMsg.RSP_SUCCESS);
            commonResponse.setMessage("Success");
            commonResponse.setContent(companyDTOList);
            return  new ResponseEntity(commonResponse, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            commonResponse.setCode(CommonMsg.RSP_ERROR);
            commonResponse.setMessage(ex.getMessage());
            commonResponse.setContent(null);
            return  new ResponseEntity(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
