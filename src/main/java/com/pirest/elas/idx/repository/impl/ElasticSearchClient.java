package com.pirest.elas.idx.repository.impl;

import java.util.Collection;
import java.util.List;

import org.elasticsearch.client.Client;

import com.pirest.elas.idx.index.Document;
import com.pirest.elas.idx.repository.IndexRepository;

public class ElasticSearchClient implements IndexRepository {

	public static final int MAX_RECONNECT_ATTEMPT = 1;

	private Client client;
	private String host;
	private int port;
	private String index;
	private Integer shards;
	private Integer replicas;
	private String clusterName;
	private boolean isConnected = true;

	public ElasticSearchClient(Client client, String index) {
		super();
		this.client = client;
		this.index = index;
	}

	public ElasticSearchClient(String clusterName, String host, int port, String index) {
		super();
		this.clusterName = clusterName;
		this.host = host;
		this.port = port;
		this.index = index;
	}

	private synchronized void tryReconnect() {
		if (isConnected)
			return;
	}

	@Override
	public void switchIndex(String newIndex) {
		
	}

	@Override
	public <T extends Document> void index(T dto) throws Exception {

	}

	@Override
	public <T extends Document> void index(Collection<T> dots) throws Exception {

	}

	@Override
	public <T extends Document> void delete(Class<T> dtoClass, String id) {

	}

	@Override
	public <T extends Document> void delete(Class<T> dtoClass, Collection<String> ids) {

	}

	@Override
	public <T extends Document> void getOne(Class<T> dtoClass, String id) {

	}

	@Override
	public <T extends Document> List<T> getAll(Class<T> dtoClass, Collection<String> ids) {

		return null;
	}

	@Override
	public void close() {

	}

}
