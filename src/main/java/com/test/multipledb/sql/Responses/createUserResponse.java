package com.test.multipledb.sql.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class createUserResponse {
    boolean isCreated;
    String message;
}
