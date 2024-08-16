package com.example.Client.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="Tour")
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTour")
public class Tour extends BaseEntity{
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private int idTour;

    @Column
    private String tourCode;

    @Column
    private String tourName;

    @Column
    private String maximumSize;

    @Column
    private String description;

    @Column
    private String imageUrl;

    @Column
    private String uuid;

    @Column
    private String Url;

}