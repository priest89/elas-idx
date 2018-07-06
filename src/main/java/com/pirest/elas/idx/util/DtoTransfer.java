package com.pirest.elas.idx.util;

import org.springframework.stereotype.Component;

import com.pirest.elas.idx.entity.Video;

@Component
public class DtoTransfer {
	public com.pirest.elas.idx.dto.Video toVideoDto(Video video) {
		com.pirest.elas.idx.dto.Video videoDto = new com.pirest.elas.idx.dto.Video();

		return videoDto;
	}
}
