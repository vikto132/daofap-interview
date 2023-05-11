package com.backend.repositories;

import com.backend.dto.ResourceJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class BaseRepository<T> {
    private final String resourcePath;

    public BaseRepository(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     * common function for reading json file resource then map to respective entity
     *
     * @return list model from resource json
     */
    protected List<T> getAllFromResources() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = TypeReference.class.getClassLoader().getResourceAsStream(this.resourcePath);
        try {
            return mapper.readValue(inputStream, this.getTypeReference()).getData();
        } catch (IOException e) {
            System.out.println("Unable to read file: " + this.resourcePath);
            System.out.println("Error: " + e.getMessage());
        }
        return List.of();
    }

    protected abstract TypeReference<ResourceJson<T>> getTypeReference();
}
