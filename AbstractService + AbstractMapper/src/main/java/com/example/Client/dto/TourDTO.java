package com.example.Client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TourDTO {
    private int idTour;

    private String tourCode;

    private String tourName;

    private String maximumSize;

    private String description;

    private String imageUrl;

    private String uuid;

    private String Url;


}

