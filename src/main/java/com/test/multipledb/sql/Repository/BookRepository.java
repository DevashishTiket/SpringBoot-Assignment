package com.test.multipledb.sql.Repository;

import com.test.multipledb.sql.Entity.Book;
import com.test.multipledb.sql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByBookName(String bookName);

    @Modifying
    @Transactional
    @Query(
            value="UPDATE book SET book_name = ?1 WHERE book_name = ?2",
            nativeQuery = true
    )
    int updateNameByBookName(String newName,String bookName);
    //UPDATE `table_name` SET `column_name` = `new_value' [WHERE condition];
}
