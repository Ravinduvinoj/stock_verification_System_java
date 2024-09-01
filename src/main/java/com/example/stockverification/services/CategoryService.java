package com.example.stockverification.services;

import com.example.stockverification.Util.CommonMsg;
import com.example.stockverification.dto.CategoryDTO;
import com.example.stockverification.entity.Category;
import com.example.stockverification.repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    public String SaveCategory(CategoryDTO categoryDTO) {
        // Check if LocationId or LocationCode already exists
        if (categoryRepo.existsByCategoryCode(categoryDTO.getCategoryCode())) {
            return CommonMsg.RSP_DUPLICATED;
        }
            categoryRepo.save(modelMapper.map(categoryDTO, Category.class));
            return CommonMsg.RSP_SUCCESS;

    }
    public String UpdateCategory(CategoryDTO categoryDTO) {
        // Check if LocationId or LocationCode already exists
        if (!categoryRepo.existsById(categoryDTO.getCategoryID())) {
            return CommonMsg.RSP_DATA_NOT_fOUND;
        }
        // Check if the category code is duplicated (excluding the current category)
        Category existingCategory = categoryRepo.findByCategoryCode(categoryDTO.getCategoryCode());
        if (existingCategory != null && existingCategory.getCategoryID() != categoryDTO.getCategoryID()) {
            return CommonMsg.RSP_DUPLICATED;
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepo.save(category);
        return CommonMsg.RSP_SUCCESS;

    }
    public List<CategoryDTO> getAllCategory(){
        List<Category> categories = categoryRepo.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }


}
