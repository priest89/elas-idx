package com.pirest.elas.idx.service;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pirest.elas.idx.entity.Channel;
import com.pirest.elas.idx.exception.APIException;
import com.pirest.elas.idx.repository.ChannelRepository;

@Service
public class ChannelService {
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ChannelRepository channelRepository;

	public void indexChannel(Long channelId) {
		Optional<Channel> channel = channelRepository.findById(channelId);
			channel.orElseThrow(() -> new APIException("Not found channel" + channelId, HttpStatus.NOT_FOUND)
		);
		rabbitTemplate.convertAndSend("channel.exchange", "channel", channel.get());
	}
}
