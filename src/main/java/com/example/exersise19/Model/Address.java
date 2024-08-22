package com.example.exersise19.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")

    private String area;
    @Column(columnDefinition = "varchar(20) not null")

    private String street;

    @Column(columnDefinition = "int not null")
    private int buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
