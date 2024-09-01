package com.example.stockverification.controller;

import com.example.stockverification.Util.CommonMsg;
import com.example.stockverification.Util.CommonResponse;
import com.example.stockverification.dto.MainStoreDTO;
import com.example.stockverification.services.MainstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/main-store")
@CrossOrigin
public class MainStoreController {

    @Autowired
    private MainstoreService mainstoreService;

    @Autowired
    private CommonResponse commonResponse;

    @PostMapping(value ="/savemainstore")
    public ResponseEntity saveCategory(@RequestBody MainStoreDTO mainStoreDTO){
        try {
            String res = mainstoreService.SaveMainStore(mainStoreDTO);
            if (res.equals("00")){
                commonResponse.setCode(CommonMsg.RSP_SUCCESS);
                commonResponse.setMessage("Main Store Created");
                commonResponse.setContent(mainStoreDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.ACCEPTED);
            } else if (res.equals("02")) {
                commonResponse.setCode(CommonMsg.RSP_DUPLICATED);
                commonResponse.setMessage("Main Store Already Created");
                commonResponse.setContent(mainStoreDTO);
                return  new ResponseEntity(commonResponse, HttpStatus.BAD_REQUEST);
            }else  if (res.equals("08")) {
                commonResponse.setCode(CommonMsg.RSP_Code_DUPLICATED);
                commonResponse.setMessage("Main Store Code Already Created");
                commonResponse.setContent(mainStoreDTO);
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
}
