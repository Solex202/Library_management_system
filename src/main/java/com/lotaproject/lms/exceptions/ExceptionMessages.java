package com.lotaproject.lms.exceptions;

import lombok.Data;

@Data
public class ExceptionMessages {
    public static final String  FOLDER_NOT_FOUND = "Folder not found";
    public static final String  BOOK_NOT_FOUND = "Book with id %s not found";
    public static final String  FOLDER_ALREADY_EXISTS = "A Folder with this name already exists";
    public static final String  BOOK_ALREADY_EXISTS = "A Book with the isbn already exists";
    public static final String  INVALID_ISBN = "Invalid isbn length";

}
