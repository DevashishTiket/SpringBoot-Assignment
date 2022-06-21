package com.test.multipledb.sql.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class UpdateBookDetailsResponse {
    boolean isUpdated;
    String message;
}
