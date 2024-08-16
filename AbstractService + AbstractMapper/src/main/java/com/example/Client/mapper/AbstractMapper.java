package com.example.Client.mapper;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;

/**
 * @author modani
 * @param <T>
 * @param <E>
 */
public class AbstractMapper<T, E> {

    protected final ModelMapper mapper;
    @Getter
    private Class<?> entityClazz;
    @Getter
    private Class<?> dtoClazz;

    /**
     * Constructor AbstractMapper
     */
    public AbstractMapper() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setPreferNestedProperties(false);
        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    /**
     * Constructor AbstractMapper
     * @param entityClazz
     * @param dtoClazz
     */
    public AbstractMapper(Class<?> entityClazz, Class<?> dtoClazz) {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setDeepCopyEnabled(false)
                .setPreferNestedProperties(false)
                .setSkipNullEnabled(true);
        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        this.entityClazz = entityClazz;
        this.dtoClazz = dtoClazz;
    }

    /**
     * Convert DTO to entity
     * @param e
     * @return
     */
    public T convertDTOToEntity(E e) {
        return convertDTOToEntity(e, entityClazz);
    }

    /**
     * Convert DTO to entity
     * @param e
     * @param tClazz
     * @return
     */
    private T convertDTOToEntity(E e, Class<?> tClazz) {
        if (null == e) return null;
        return mapper.map(e, (Type) tClazz);
    };

    /**
     * Convert entity to DTO
     * @param t
     * @return
     */
    public E convertEntityToDTO(T t) {
        return convertEntityToDTO(t, dtoClazz);
    }

    /**
     * Convert entity to DTO
     * @param t
     * @param dtoClazz
     * @return
     */
    private E convertEntityToDTO(T t, Class<?> dtoClazz) {
        if (null == t) return null;
        return mapper.map(t, (Type) dtoClazz);
    }

    /**
     * Update dto against entity.
     * @param e dto
     * @param oldEntity entity
     * @return updated entity
     */
    public T mapDTOToEntity(E e, T oldEntity) {
        if (null == e) return null;
        mapper.map(e, oldEntity);
        return oldEntity;
    };
    //end
}
