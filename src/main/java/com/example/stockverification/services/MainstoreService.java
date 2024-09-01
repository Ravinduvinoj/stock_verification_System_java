package com.example.stockverification.services;

import com.example.stockverification.Util.CommonMsg;
import com.example.stockverification.dto.CategoryDTO;
import com.example.stockverification.dto.MainStoreDTO;
import com.example.stockverification.entity.Category;
import com.example.stockverification.entity.Mainstore;
import com.example.stockverification.repository.MainStoreRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class MainstoreService {

    @Autowired
    private MainStoreRepo mainStoreRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String SaveMainStore(MainStoreDTO mainStoreDTO) {
        // Check if LocationId or LocationCode already exists
        if (mainStoreRepo.existsByMainStoreCode(mainStoreDTO.getMainStoreCode())) {
            return CommonMsg.RSP_DUPLICATED;
        }
        mainStoreRepo.save(modelMapper.map(mainStoreDTO, Mainstore.class));
        return CommonMsg.RSP_SUCCESS;

    }
    public String UpdateMainStore(MainStoreDTO mainStoreDTO) {
        // Check if LocationId or LocationCode already exists
        if (!mainStoreRepo.existsById(mainStoreDTO.getMainStoreId())) {
            return CommonMsg.RSP_DATA_NOT_fOUND;
        }
        // Check if the category code is duplicated (excluding the current category)
        Mainstore existingStoreCode = mainStoreRepo.findByMainStoreCode(mainStoreDTO.getMainStoreCode());
        if (existingStoreCode != null && existingStoreCode.getMainStoreId() != mainStoreDTO.getMainStoreId()) {
            return CommonMsg.RSP_DUPLICATED;
        }
        Mainstore mainstore = modelMapper.map(mainStoreDTO, Mainstore.class);
        mainStoreRepo.save(mainstore);
        return CommonMsg.RSP_SUCCESS;
    }
}
