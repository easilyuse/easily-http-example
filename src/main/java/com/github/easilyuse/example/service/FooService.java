package com.github.easilyuse.example.service;

import java.util.List;

import com.github.easilyuse.example.model.Foo;

public interface FooService {

	Long saveFoos(List<Foo> foos);

	boolean deleteFoos(List<Long> ids);
}
