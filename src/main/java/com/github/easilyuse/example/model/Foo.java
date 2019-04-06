package com.github.easilyuse.example.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Foo {

    private Long id;

    private String name;

    private List<Bar> bars;



}
