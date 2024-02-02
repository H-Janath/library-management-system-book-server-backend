package org.example.service.impl;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    ModelMapper modelMapper;

    @Bean
    public void setUp(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = modelMapper.map(book,BookEntity.class);
        bookRepository.save(bookEntity);
    }
}
