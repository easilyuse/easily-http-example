package com.github.easilyuse.example.client;

import java.util.List;

import com.github.easilyuse.core.annotation.HttpClient;
import com.github.easilyuse.core.annotation.HttpReqListParam;
import com.github.easilyuse.core.annotation.HttpReqMethod;
import com.github.easilyuse.example.model.Foo;

@HttpClient(url = "http://localhost:8080")
public interface FooHttpClient {

	@HttpReqMethod(path = "/foo/saveFoos")
	Long saveFoos(@HttpReqListParam List<Foo> foos);

	@HttpReqMethod(path = "/foo/deleteFoos")
	boolean deleteFoos(@HttpReqListParam List<Long> ids);

	@HttpReqMethod(path = "/foo/getStrs")
	String[] getStrs();

}
