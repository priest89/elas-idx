package com.pirest.elas.idx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pirest.elas.idx.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	
}
