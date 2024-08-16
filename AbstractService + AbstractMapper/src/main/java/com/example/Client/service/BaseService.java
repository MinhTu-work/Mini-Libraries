package com.example.Client.service;

import java.util.List;

public interface BaseService<T>{
    T create(T dto);
    <ID> T getByID(ID idDto);
    List<T> getAll();
    T update(T dto);
    <ID> void delete(ID dto);
}
