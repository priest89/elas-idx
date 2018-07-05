package com.pirest.elas.idx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pirest.elas.idx.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
