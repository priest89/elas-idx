package com.pirest.elas.idx.service.indexer;

import java.util.Collection;
import java.util.List;

import com.pirest.elas.idx.dto.VideoDto;
import com.pirest.elas.idx.index.IndexRequest;
import com.pirest.elas.idx.index.IndexResult;

public class ChannelIndexer extends AbstractIndexer<VideoDto> {

	@Override
	protected IndexResult process(IndexRequest indexRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void index(String id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void index(Collection<String> ids) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void index(List<VideoDto> dtos) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void delete(Collection<String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	protected VideoDto get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<VideoDto> get(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected VideoDto load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<VideoDto> load(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected VideoDto lookup(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<VideoDto> lookup(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
