package com.pirest.elas.idx.service.indexer;

import java.util.Collection;
import java.util.List;

import com.pirest.elas.idx.entity.Video;
import com.pirest.elas.idx.index.IndexRequest;
import com.pirest.elas.idx.index.IndexResult;

public class ChannelIndexer extends AbstractIndexer<Video> {

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
	protected void index(List<Video> dtos) throws Exception {

	}

	@Override
	protected void delete(String id) {

	}

	@Override
	protected void delete(Collection<String> ids) {

	}

	@Override
	protected Video get(String id) {

		return null;
	}

	@Override
	protected List<Video> get(Collection<String> ids) {

		return null;
	}

	@Override
	protected Video load(String id) {

		return null;
	}

	@Override
	protected List<Video> load(Collection<String> ids) {

		return null;
	}

	@Override
	protected Video lookup(String id) {

		return null;
	}

	@Override
	protected List<Video> lookup(Collection<String> ids) {

		return null;
	}

}
