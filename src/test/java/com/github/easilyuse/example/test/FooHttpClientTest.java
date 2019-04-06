package com.github.easilyuse.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.easilyuse.example.EasilyHttpExampleApplication;
import com.github.easilyuse.example.client.FooHttpClient;
import com.github.easilyuse.example.model.Bar;
import com.github.easilyuse.example.model.Foo;

@SpringBootTest(classes = { EasilyHttpExampleApplication.class })
@RunWith(SpringRunner.class)
public class FooHttpClientTest {

	@Autowired
	private FooHttpClient fooHttpClient;

	@Test
	public void testSaveFoos() {
		List<Foo> foos = new ArrayList<>();
		List<Bar> bars = new ArrayList<>();
		Bar bar = Bar.builder().name("barTEST").price(17.0).build();
		Bar bar1 = Bar.builder().name("bar").price(16.0).build();
		bars.add(bar);
		bars.add(bar1);

		List<Bar> bars1 = new ArrayList<>();
		Bar bar2 = Bar.builder().name("bar100").price(17.17).build();
		Bar bar3 = Bar.builder().name("bar99").price(16.16).build();
		bars1.add(bar2);
		bars1.add(bar3);

		Foo foo = Foo.builder().bars(bars).name("fooTEST").build();
		Foo foo1 = Foo.builder().bars(bars1).name("foo").build();
		foos.add(foo);
		foos.add(foo1);

		Long addSize = fooHttpClient.saveFoos(foos);

		Assert.assertEquals(Long.valueOf(foos.size()), addSize);
	}

	@Test
	public void testDeleteUserById() {

		List<Long> ids = Arrays.asList(1L, 2L, 3L);

		boolean deleteFlag = fooHttpClient.deleteFoos(ids);

		Assert.assertTrue(deleteFlag);
	}

	@Test
	public void testStrs() {

		String[] test = fooHttpClient.getStrs();

		Assert.assertNotNull(test);

		System.out.println(Arrays.toString(test));
	}

}
