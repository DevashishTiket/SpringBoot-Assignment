package com.test.multipledb.sql.Responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class createBookResponse {
    boolean isCreated;
    String message;
}

