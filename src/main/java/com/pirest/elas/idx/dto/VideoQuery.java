package com.pirest.elas.idx.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pirest.elas.idx.dto.query.Query;
import com.pirest.elas.idx.util.DateUtil;

/**
 * Created by jongpark on 3/1/17.
 */
public class VideoQuery {

	@JsonProperty("video_query_id")
	private Long videoQueryId;
	@JsonProperty("account_id")
	private Long accountId;
	private String name;
	private String description;
	private Query query;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.DATE_FORMAT)
	@JsonProperty("date_created")
	private Date createDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.DATE_FORMAT)
	@JsonProperty("last_updated")
	private Date lastUpdated;

	public Long getVideoQueryId() {
		return videoQueryId;
	}

	public void setVideoQueryId(Long videoQueryId) {
		this.videoQueryId = videoQueryId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
