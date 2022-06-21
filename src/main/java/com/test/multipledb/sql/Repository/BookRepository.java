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
            value = "UPDATE book SET user_id=?2 WHERE book_id=?1",
            nativeQuery = true
    )
    User updateBookIssuedByBook_Id(Long bookId,Long userId);
    //UPDATE `table_name` SET `column_name` = `new_value' [WHERE condition];
}
