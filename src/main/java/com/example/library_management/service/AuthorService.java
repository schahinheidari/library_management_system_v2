package com.example.library_management.service;

import com.example.library_management.model.dto.author.AuthorDto;
import com.example.library_management.model.dto.author.AuthorSaveDto;
import com.example.library_management.model.dto.author.AuthorUpdateDto;

import java.util.List;

public interface AuthorService {
    String addAuthor(AuthorSaveDto authorSaveDto);
    List<AuthorDto> getAllAuthors();
    String updateAuthor(AuthorUpdateDto authorUpdateDto);
    String deleteAuthor(int id);

}
