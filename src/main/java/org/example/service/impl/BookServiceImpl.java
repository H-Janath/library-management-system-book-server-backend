package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;
    ModelMapper modelMapper;

    @Bean
    public void setUp(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Book addBook(Book book) {
        BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
        Book returnbook = null;
        if (bookEntity != null) {
            bookEntity.setBookId(generateBookId());
            BookEntity savedBook = bookRepository.save(bookEntity);
            returnbook = modelMapper.map(savedBook, Book.class);
        }
        return returnbook;
    }

    @Override
    public List<BookEntity> getBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Book getBookById(Long id) {
        Optional<BookEntity> byId = bookRepository.findById(id);
        return modelMapper.map(byId,Book.class);
    }

    @Override
    public String generateBookId() {
        Long maxId = bookRepository.findMaxId();
        if(maxId!=null){
            maxId++;
            return "BK"+maxId;
        }
        return "BK1";
    }


}
