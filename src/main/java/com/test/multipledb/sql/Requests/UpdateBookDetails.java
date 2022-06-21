package com.test.multipledb.sql.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UpdateBookDetails {
    String updatedBookName;
    String currentBookName;
}
