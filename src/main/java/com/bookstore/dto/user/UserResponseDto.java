package com.bookstore.dto.user;

import lombok.Data;

@Data
public class UserResponseDto {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String shippingAddress;
}
