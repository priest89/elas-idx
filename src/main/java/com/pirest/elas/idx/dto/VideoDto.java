package com.pirest.elas.idx.dto;

import java.util.List;

import com.pirest.elas.idx.index.Document;

public class VideoDto extends Document {

	public VideoDto(DocType docType, List<Object> ids) {
		super(docType, ids);
	}

}
