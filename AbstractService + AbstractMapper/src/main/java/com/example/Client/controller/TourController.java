package com.example.Client.controller;

import com.example.Client.consts.ApiPath;
import com.example.Client.dto.TourDTO;
import com.example.Client.response.TourResponseDTO;
import com.example.Client.service.Impl.TourServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Client.consts.ApiPath.*;

@RestController("")
@AllArgsConstructor
public class TourController {
    private TourServiceImpl service;
    @PostMapping(ApiPath.API + TOUR_CREATE)
    public ResponseEntity<TourDTO> create(@RequestBody TourDTO entity){
        TourDTO tourDTO = service.create(entity);
        return new ResponseEntity<>(tourDTO, HttpStatus.CREATED);
    }
    @GetMapping(ApiPath.API + TOUR_FIND_ALL)
    public ResponseEntity<?> findAll(){
        TourResponseDTO response = new TourResponseDTO();
        try{
            List<TourDTO> tourDTOS = service.getAll();
            response.setMessage("Successfully retrieved All Tour");
            response.setErrorCode(200);
            response.setList(tourDTOS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            response.setMessage("Error when get all Tour list , Please try again");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(ApiPath.API + TOUR_FIND_BY_ID + "/{idTour}")
    public ResponseEntity<TourDTO> findById(@PathVariable("idTour") int idTour){
        TourDTO tourDTO = service.getByID(idTour);
        return new ResponseEntity<>(tourDTO, HttpStatus.OK);
    }
    @PutMapping(ApiPath.API + TOUR_UPDATE + "/{idTour}")
    public ResponseEntity<TourDTO> update(@PathVariable("idTour") int idTour, @RequestBody TourDTO entity){
        entity.setIdTour(idTour);
        TourDTO tourDTO = service.update(entity);
        return new ResponseEntity<>(tourDTO, HttpStatus.OK);
    }
    @DeleteMapping(ApiPath.API + TOUR_DELETE + "/{idTour}")
    public ResponseEntity<String> delete(@PathVariable("idTour") int idTour){
        service.delete(idTour);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
