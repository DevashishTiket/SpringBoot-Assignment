package com.test.multipledb.sql.Repository;

import com.test.multipledb.sql.Entity.Book;
import com.test.multipledb.sql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);

    @Modifying
    @Transactional
    @Query(
            value="UPDATE user SET username = ?1 WHERE username = ?2",
            nativeQuery = true
    )
    int updateNameByUserName(String newName,String userName);

    @Modifying
    @Transactional
    @Query(
            value="UPDATE user SET email = ?1 WHERE username = ?2",
            nativeQuery = true
    )
    int updateEmailByUserName(String email,String userName);

}
