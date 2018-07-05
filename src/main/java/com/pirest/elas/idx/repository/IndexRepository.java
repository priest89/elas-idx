package com.pirest.elas.idx.repository;

import java.util.Collection;
import java.util.List;

import com.pirest.elas.idx.index.Document;

public interface IndexRepository {
	void switchIndex(String newIndex);

	<T extends Document> void index(T dto) throws Exception;

	<T extends Document> void index(Collection<T> dots) throws Exception;

	<T extends Document> void delete(Class<T> dtoClass, String id);

	<T extends Document> void delete(Class<T> dtoClass, Collection<String> ids);

	<T extends Document> void getOne(Class<T> dtoClass, String id);

	<T extends Document> List<T> getAll(Class<T> dtoClass, Collection<String> ids);

	void close();
}
