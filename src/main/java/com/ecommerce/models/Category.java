package com.ecommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "order_seq", sequenceName = "order_sequence", allocationSize = 1)
    Long categoryID;

    @NotBlank
    @Size(min = 3, message = "Category must contain atleast 3 characters.")
    String categoryName;

}
