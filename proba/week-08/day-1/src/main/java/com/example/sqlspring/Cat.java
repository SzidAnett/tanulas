package com.example.sqlspring;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Cat(){
        name = "micike";
    }

    public Cat(String name) {
       this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
