package com.pirest.elas.idx.service.indexer;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pirest.elas.idx.dto.Channel;
import com.pirest.elas.idx.index.IndexRequest;
import com.pirest.elas.idx.index.IndexResult;
import com.pirest.elas.idx.repository.IndexRepository;
import com.pirest.elas.idx.repository.VideoRepository;

@Component
public class ChannelIndexer extends AbstractIndexer<com.pirest.elas.idx.dto.Channel> {

	@Autowired
	private VideoRepository videoRepository;

	public ChannelIndexer(IndexRepository indexRepository, ExecutorService executorService) {
		super(executorService, com.pirest.elas.idx.dto.Channel.class);
	}

	@Override
	protected IndexResult process(IndexRequest indexRequest) {
		return null;
	}

	@Override
	protected void index(String id) throws Exception {

	}

	@Override
	protected void index(Collection<String> ids) throws Exception {

	}

	@Override
	protected void index(List<Channel> dtos) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void delete(Collection<Object> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Channel get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Channel> get(Collection<Object> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Channel load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Channel> load(Collection<Object> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Channel lookup(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Channel> lookup(Collection<Object> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
