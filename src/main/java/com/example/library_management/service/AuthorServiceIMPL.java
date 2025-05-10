package com.example.library_management.service;

import com.example.library_management.model.dto.author.AuthorDto;
import com.example.library_management.model.dto.author.AuthorSaveDto;
import com.example.library_management.model.dto.author.AuthorUpdateDto;
import com.example.library_management.model.entity.Author;
import com.example.library_management.repository.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public String addAuthor(AuthorSaveDto authorSaveDto) {

        Author author = new Author(
                authorSaveDto.getName()
        );

        authorDao.save(author);
        return author.getName();
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> getAuthors = authorDao.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : getAuthors) {
            AuthorDto authorDto = new AuthorDto(
                    author.getId(),
                    author.getName()
            );
            authorDtos.add(authorDto);
        }
        return authorDtos;

    }

    @Override
    public String updateAuthor(AuthorUpdateDto authorUpdateDto) {
        if(authorDao.existsById(authorUpdateDto.getId())){
            Author author = authorDao.findById(authorUpdateDto.getId()).get();
            author.setName(authorUpdateDto.getName());
            authorDao.save(author);
            return author.getName();
        }
        else {
            System.out.println("Author does not exist");
        }
        return null;

    }

    @Override
    public String deleteAuthor(int id) {
        if (authorDao.existsById(id)) {
            authorDao.deleteById(id);
        } else {
            System.out.println("Author ID does not exist");
        }
        return null;
    }

}
