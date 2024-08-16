package com.example.Client.service.Impl;

import com.example.Client.dto.TourDTO;
import com.example.Client.entity.Tour;
import com.example.Client.mapper.AbstractMapper;
import com.example.Client.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl extends AbstractBaseServiceImpl<TourDTO>{
    @Autowired
    TourRepository repo;

    public TourServiceImpl() {
        AbstractMapper mapper = new AbstractMapper(Tour.class, TourDTO.class);
        super.setMapper(mapper);
    }

    @Override
    public void setRepository() {
        AbstractBaseServiceImpl.setRepository(this.repo);
    }
}

