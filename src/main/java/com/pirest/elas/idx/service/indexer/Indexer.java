package com.pirest.elas.idx.service.indexer;

import java.util.concurrent.Future;

import com.pirest.elas.idx.index.IndexRequest;
import com.pirest.elas.idx.index.IndexResult;

public interface Indexer {
	Future<IndexResult> execute(IndexRequest indexRequest);
}
