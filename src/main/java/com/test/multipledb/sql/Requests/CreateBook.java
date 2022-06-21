package com.test.multipledb.sql.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateBook {
    String bookName;
    String bookAuthor;
}
