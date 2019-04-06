package com.github.easilyuse.example.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.easilyuse.example.db.MapDb;
import com.github.easilyuse.example.model.Foo;
import com.github.easilyuse.example.service.FooService;

@Service
public class FooServiceImpl implements FooService {

	private Map<String, List<Foo>> fooMap = MapDb.fooDB;

	@Override
	public Long saveFoos(List<Foo> foos) {
		if (CollectionUtils.isEmpty(foos)) {
			return -1L;
		}
		List<Foo> dbFoos = fooMap.get(MapDb.TABLE_FOO);

		foos.forEach(foo -> {
			foo.setId(MapDb.fooIds.incrementAndGet());
			dbFoos.add(foo);
		});

		MapDb.refreshFooDB();

		return Long.valueOf(foos.size());
	}

	@Override
	public boolean deleteFoos(List<Long> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return false;
		}

		List<Foo> dbFoos = fooMap.get(MapDb.TABLE_FOO);

		List<Foo> deleteFoos = dbFoos.stream().filter(foo -> ids.contains(foo.getId())).collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(deleteFoos)) {
			dbFoos.removeAll(deleteFoos);
			MapDb.refreshFooDB();
			return true;
		}
		return false;
	}
}
