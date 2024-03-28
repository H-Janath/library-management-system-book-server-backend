package org.example.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int quantity;

    public BookEntity(String isbn, String title, String author, String category, Integer quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }
}
