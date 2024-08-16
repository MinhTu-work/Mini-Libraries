package com.example.Client.repository;
import com.example.Client.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Override
    <S extends Tour> S save(S entity);
    findAll
}
