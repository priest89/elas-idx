package com.pirest.elas.idx.service;

import org.assertj.core.util.Arrays;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.pirest.elas.idx.index.Document;
import com.pirest.elas.idx.index.Document.DocType;
import com.pirest.elas.idx.index.IndexRequest;
import com.pirest.elas.idx.index.IndexRequest.IndexType;
import com.pirest.elas.idx.util.MapperUtil;

@Service
public class ChannelService {

	private RabbitTemplate rabbitTemplate;

	public String indexChannel(String channelIds) {
		String[] ids = channelIds.trim().split("\\s*,\\s*");
		if (ids.length > 0) {
			IndexRequest indexRequest = new IndexRequest(new Document(DocType.CHANNEL, Arrays.asList(ids)),
					IndexType.INDEX);
			rabbitTemplate.convertAndSend("channel.exchange", MapperUtil.toJson(indexRequest));
		}
		return String.format("Index request sent for channel: %s", channelIds);
	}
}
