package model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String number;
}
