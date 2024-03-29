package org.example.repository;
import org.example.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity,Long> {

    @Query(value = "SELECT MAX(b.id) FROM Book b",nativeQuery = true)
    Long findMaxId();

}
