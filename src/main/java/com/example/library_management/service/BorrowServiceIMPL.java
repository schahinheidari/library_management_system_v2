package com.example.library_management.service;

import com.example.library_management.model.dto.borrow.BorrowDto;
import com.example.library_management.model.dto.borrow.BorrowSaveDto;
import com.example.library_management.model.dto.borrow.BorrowUpdateDto;
import com.example.library_management.model.entity.Borrow;
import com.example.library_management.repository.BookDao;
import com.example.library_management.repository.BorrowDao;
import com.example.library_management.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {

    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;


    @Override
    public String addBorrow(BorrowSaveDto borrowSaveDto) {
        Borrow borrow = new Borrow(
                bookDao.getById(borrowSaveDto.getBook_id()),
                userDao.getById(borrowSaveDto.getUser_id()),
                borrowSaveDto.getBorrowDate(),
                borrowSaveDto.getReturnDate()

        );
        borrowDao.save(borrow);
        return null;
    }

    @Override
    public List<BorrowDto> getAllBorrows() {
        List<Borrow> getBorrows = borrowDao.findAll();
        List<BorrowDto> borrowDtoList = new ArrayList<>();
        for (Borrow borrow : getBorrows) {
            BorrowDto borrowDto = new BorrowDto(
                    borrow.getId(),
                    borrow.getBook(),
                    borrow.getUser(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()
            );
            borrowDtoList.add(borrowDto);
        }
        return borrowDtoList;
    }

    @Override
    public String updateBorrow(BorrowUpdateDto borrowUpdateDto) {
        if(borrowDao.existsById(borrowUpdateDto.getId())){
            Borrow borrow = borrowDao.findById(borrowUpdateDto.getId()).get();
            borrow.setBook(bookDao.getById(borrowUpdateDto.getBook_id()));
            borrow.setUser(userDao.getById(borrowUpdateDto.getUser_id()));
            borrow.getBorrowDate();
            borrow.getReturnDate();
            borrowDao.save(borrow);
        }
        else {
            System.out.println("Borrow does not exist");
        }
        return null;
    }

    @Override
    public String deleteBorrow(int id) {
        if (borrowDao.existsById(id)) {
            borrowDao.deleteById(id);
        } else {
            System.out.println("Borrow ID does not exist");
        }
        return null;
    }
}
