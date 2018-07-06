package com.pirest.elas.idx.service.indexer;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

import com.pirest.elas.idx.dto.Document;
import com.pirest.elas.idx.index.IndexRequest;
import com.pirest.elas.idx.index.IndexResult;

@Component
public abstract class AbstractIndexer<T extends Document> implements Indexer {

	protected Class<T> dtoClass;

	protected ExecutorService executorService;

	public AbstractIndexer(ExecutorService executorService, Class<T> dtoClass) {
		this.dtoClass = dtoClass;
		this.executorService = executorService; 
	}
	
	public ExecutorService getExecutorService() {
		return executorService;
	}

	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

	@Override
	public Future<IndexResult> execute(IndexRequest indexRequest) {
		return executorService.submit(new Callable<IndexResult>() {

			@Override
			public IndexResult call() throws Exception {
				indexRequest.setTriedCount(indexRequest.getTriedCount() + 1);
				return process(indexRequest);
			}

		});
	}

	protected abstract IndexResult process(IndexRequest indexRequest);

	protected abstract void index(String id) throws Exception;

	protected abstract void index(final Collection<String> ids) throws Exception;

	protected abstract void index(List<T> dtos) throws Exception;

	protected abstract void delete(String id);

	protected abstract void delete(Collection<Object> ids);

	protected abstract T get(String id);

	protected abstract List<T> get(Collection<Object> ids);

	protected abstract T load(String id);

	protected abstract List<T> load(Collection<Object> ids);

	protected abstract T lookup(String id);

	protected abstract List<T> lookup(Collection<Object> ids);
}
