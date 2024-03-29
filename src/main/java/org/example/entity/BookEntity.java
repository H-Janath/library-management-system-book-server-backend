package org.example.entity;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int quantity;

    public BookEntity(String bookId,String isbn, String title, String author, String category, Integer quantity) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }
}
