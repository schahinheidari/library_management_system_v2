package com.example.library_management.controller;

import com.example.library_management.model.dto.borrow.BorrowDto;
import com.example.library_management.model.dto.borrow.BorrowSaveDto;
import com.example.library_management.model.dto.borrow.BorrowUpdateDto;
import com.example.library_management.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping(path = "/save")
    public String saveBorrow(@RequestBody BorrowSaveDto borrowSaveDto){
        String borrowName = borrowService.addBorrow(borrowSaveDto);
        return "Added Successfully";
    }

    @GetMapping(path = "/getAllBorrow")
    public List<BorrowDto> getAllBorrows(){
        List<BorrowDto> borrowList = borrowService.getAllBorrows();
        return borrowList;
    }

    @PutMapping(path = "/update")
    public String updateBorrow(@RequestBody BorrowUpdateDto borrowUpdateDto){
        String borrowName = borrowService.updateBorrow(borrowUpdateDto);
        return "Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBorrow(@PathVariable(value = "id") int id){
        String borrowName = borrowService.deleteBorrow(id);
        return "Deleted Successfully";
    }
}
