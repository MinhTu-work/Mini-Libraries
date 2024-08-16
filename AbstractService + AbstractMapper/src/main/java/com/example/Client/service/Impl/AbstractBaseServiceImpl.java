package com.example.Client.service.Impl;

import com.example.Client.mapper.AbstractMapper;
import com.example.Client.service.BaseService;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class AbstractBaseServiceImpl<T> implements BaseService<T> {
    @Setter
    public static Object repository;

    @Setter
    public AbstractMapper mapper;

    public abstract void setRepository();

    public <T, ID> JpaRepository<T, ID> getRepositry() {
        return (JpaRepository<T, ID>) this.repository;
    }


    @Override
    public T create(T dto) {
        setRepository();
        Object existingEntity = mapper.convertDTOToEntity(dto);
        return (T) mapper.convertEntityToDTO(getRepositry().save(existingEntity));
    }

    @Override
    public <ID> T getByID(ID idDto) {
        setRepository();
        return (T) mapper.convertEntityToDTO(getRepositry().findById(idDto));
    }

    @Override
    public List<T> getAll() {
        setRepository();
        List<T> entities = (List<T>) getRepositry().findAll();
        return (List<T>) entities.stream().map((entity) -> mapper.convertEntityToDTO(entity)).toList();
    }

    @Override
    public T update(T dto) {
        setRepository();
        Object entity = mapper.convertDTOToEntity(dto);
        return (T) mapper.convertEntityToDTO(getRepositry().save(entity));
    }

    @Override
    public <ID> void delete(ID dto) {
        setRepository();
        getRepositry().deleteById(dto);
    }
}
