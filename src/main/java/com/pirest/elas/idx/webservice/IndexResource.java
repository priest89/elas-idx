package com.pirest.elas.idx.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pirest.elas.idx.service.ChannelService;

@RestController
public class IndexResource {

	@Autowired
	private ChannelService channelService;

	@PostMapping("/index/channels/{channelIds}")
	public String indexChannels(@PathVariable String channelIds) {
		return channelService.indexChannel(channelIds);
	}
}
