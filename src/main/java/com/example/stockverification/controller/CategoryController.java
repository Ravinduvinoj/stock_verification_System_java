package com.example.stockverification.controller;

import com.example.stockverification.Util.CommonMsg;
import com.example.stockverification.Util.CommonResponse;
import com.example.stockverification.dto.CategoryDTO;
import com.example.stockverification.dto.CompanyDTO;
import com.example.stockverification.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommonResponse commonResponse;

    @PostMapping(value ="/saveCategory")
    public ResponseEntity saveCategory(@RequestBody CategoryDTO categoryDTO){
        try {
            String res = categoryService.SaveCategory(categoryDTO);
            if (res.equals("00")){
                commonResponse.setCode(CommonMsg.RSP_SUCCESS);
                commonResponse.setMessage("category Added");
                commonResponse.setContent(categoryDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.ACCEPTED);
            } else if (res.equals("02")) {
                commonResponse.setCode(CommonMsg.RSP_DUPLICATED);
                commonResponse.setMessage("category Already Added");
                commonResponse.setContent(categoryDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.BAD_REQUEST);
            }else  if (res.equals("08")) {
                commonResponse.setCode(CommonMsg.RSP_Code_DUPLICATED);
                commonResponse.setMessage("Category Code Already Added");
                commonResponse.setContent(categoryDTO);
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
    @PutMapping(value ="/updateCategory")
    public ResponseEntity updateCategory(@RequestBody CategoryDTO categoryDTO){
        try {
            String res = categoryService.UpdateCategory(categoryDTO);
            if (res.equals("00")){
                commonResponse.setCode(CommonMsg.RSP_SUCCESS);
                commonResponse.setMessage("Category Updated");
                commonResponse.setContent(categoryDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                commonResponse.setCode(CommonMsg.RSP_DUPLICATED);
                commonResponse.setMessage("No Added categories");
                commonResponse.setContent(categoryDTO);
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
    @GetMapping(value="getAllCategory")
    public ResponseEntity getAllCategory(){
        try{
            List<CategoryDTO> categoryDTOList = categoryService.getAllCategory();
            commonResponse.setCode(CommonMsg.RSP_SUCCESS);
            commonResponse.setMessage("Success");
            commonResponse.setContent(categoryDTOList);
            return  new ResponseEntity(commonResponse, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            commonResponse.setCode(CommonMsg.RSP_ERROR);
            commonResponse.setMessage(ex.getMessage());
            commonResponse.setContent(null);
            return  new ResponseEntity(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
