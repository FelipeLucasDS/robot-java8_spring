package com.felipelucas.commons.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassMapper {

    private ModelMapper innerMapper;

    public ClassMapper() {
        this.innerMapper = new ModelMapper();
    }

    public <D> D map(Object data, Class<D> classTarget) {
        return this.innerMapper.map(data, classTarget);
    }

    public <D> List<D> map(List<?> dataList, Class<D> classTarget) {
        return dataList.stream()
                .map((object) -> map(object, classTarget))
                .collect(Collectors.toList());
    }
}
