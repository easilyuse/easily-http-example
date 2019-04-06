package com.github.easilyuse.example.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.github.easilyuse.example.model.Foo;
import com.github.easilyuse.example.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapDb {

	public static final String TABLE_USER = "t_user";
	public static Map<String, List<User>> userDB = new HashMap<>();

	public static AtomicLong id = new AtomicLong(0);

	public static void refreshDB() {
		userDB.forEach((key, value) -> {
			value.forEach(u -> log.info("{}", u));
		});
	}

	public static final String TABLE_FOO = "t_foo";
	public static Map<String, List<Foo>> fooDB = new HashMap<>();

	public static AtomicLong fooIds = new AtomicLong(0);

	public static void refreshFooDB() {
		fooDB.forEach((key, value) -> {
			value.forEach(f -> log.info("{}", f));
		});
	}
}
