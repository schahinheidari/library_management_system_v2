package com.example.library_management.controller;

import com.example.library_management.model.dto.author.AuthorDto;
import com.example.library_management.model.dto.author.AuthorSaveDto;
import com.example.library_management.model.dto.author.AuthorUpdateDto;
import com.example.library_management.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "save")
    public String saveAuthor(@RequestBody AuthorSaveDto authorSaveDto){
        String authorName = authorService.addAuthor(authorSaveDto);
        return "Added Successfully";
    }

    @GetMapping(path = "getAllAuthor")
    public List<AuthorDto> getAllAuthors(){
        List<AuthorDto> authorDtoList = authorService.getAllAuthors();
        return authorDtoList;
    }

    @PutMapping(path = "update")
    public String updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto){
        String authorName = authorService.updateAuthor(authorUpdateDto);
        return "Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable(value = "id") int id){
        String autherName = authorService.deleteAuthor(id);
        return "Deleted Successfully";
    }
}
