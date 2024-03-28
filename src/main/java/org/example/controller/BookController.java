package org.example.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
    final BookService bookService;
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookService.addBook(book);
        return savedBook.getId()!=null
                ?new ResponseEntity<>(savedBook,HttpStatus.OK)
                :new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("")
    public List<BookEntity> getBooks(){
        return bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "delete";
    }

    @GetMapping("/{id}")
    public Book getBookId(@PathVariable Long id){
        return bookService.getBookById(id);
    }
}
