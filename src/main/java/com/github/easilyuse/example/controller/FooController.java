package com.github.easilyuse.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.easilyuse.example.model.Foo;
import com.github.easilyuse.example.service.FooService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/foo")
@Slf4j
public class FooController {

	@Autowired
	private FooService fooService;

	@RequestMapping(value = "/saveFoos")
	Long saveFoos(@RequestBody List<Foo> foos) {
		log.info("{}", foos);
		return fooService.saveFoos(foos);
	}

	@RequestMapping(value = "/deleteFoos")
	boolean deleteFoos(@RequestBody List<Long> ids) {
		log.info("{}", ids);

		return fooService.deleteFoos(ids);
	}

	@RequestMapping(value = "/getStrs")
	public String[] getStrs() {
		String[] test = { "a", "b", "c" };
		return test;
	}
}
