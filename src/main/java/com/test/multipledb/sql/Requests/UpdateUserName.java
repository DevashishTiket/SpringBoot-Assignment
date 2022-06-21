package com.test.multipledb.sql.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateUserName {
    String currentUserName;
    String newUserName;
}
