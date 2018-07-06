package com.pirest.elas.idx.service.indexer;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pirest.elas.idx.entity.Video;
import com.pirest.elas.idx.index.Document.DocType;
import com.pirest.elas.idx.index.IndexRequest;
import com.pirest.elas.idx.index.IndexRequest.IndexType;
import com.pirest.elas.idx.index.IndexResult;
import com.pirest.elas.idx.repository.IndexRepository;
import com.pirest.elas.idx.repository.VideoRepository;

@Component
public class VideoIndexer extends AbstractIndexer<com.pirest.elas.idx.dto.Video> {

	@Autowired
	private VideoRepository videoRepository;

	public VideoIndexer(IndexRepository indexRepository, ExecutorService executorService) {
		super(executorService, com.pirest.elas.idx.dto.Video.class);
	}

	@Override
	protected IndexResult process(IndexRequest indexRequest) {
		IndexResult.Status status = IndexResult.Status.SUCCESS;
		String message = "";
		Exception exception = null;
		if (DocType.VIDEO.equals(indexRequest.getDocument().getDocType())) {
			try {
				if (IndexType.INDEX.equals(indexRequest.getIndexType())) {
					List<com.pirest.elas.idx.dto.Video> videoDtos = this.load(indexRequest.getDocument().getIds());
					this.index(videoDtos);
				}
			} catch (Exception e) {
				status = IndexResult.Status.FAIL;
				message = e.getMessage();
				exception = e;
			}
		} else {
			status = IndexResult.Status.FAIL;
			message = "Not a video request";
		}
		return null;
	}

	@Override
	protected void index(String id) throws Exception {

	}

	@Override
	protected void index(Collection<String> ids) throws Exception {

	}

	@Override
	protected void index(List<com.pirest.elas.idx.dto.Video> dtos) throws Exception {

	}

	@Override
	protected void delete(String id) {

	}

	@Override
	protected void delete(Collection<Object> ids) {

	}

	@Override
	protected com.pirest.elas.idx.dto.Video get(String id) {

		return null;
	}

	@Override
	protected List<com.pirest.elas.idx.dto.Video> get(Collection<Object> ids) {

		return null;
	}

	@Override
	protected com.pirest.elas.idx.dto.Video load(String id) {

		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected List<com.pirest.elas.idx.dto.Video> load(Collection<Object> ids) {
		List<Long> idsLong = (List<Long>) ids.stream().map(e -> Long.valueOf((String) (e)));
		List<Video> videos = videoRepository.findAllById(idsLong);

		return null;
	}

	@Override
	protected com.pirest.elas.idx.dto.Video lookup(String id) {

		return null;
	}

	@Override
	protected List<com.pirest.elas.idx.dto.Video> lookup(Collection<Object> ids) {

		return null;
	}

}
