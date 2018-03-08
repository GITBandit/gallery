package com.example.gallery;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

public class FileRep {

    String name;

    public FileRep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
