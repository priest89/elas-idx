package com.pirest.elas.idx.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pirest.elas.idx.dto.analysis.LowerCaseAnalyzer;
import com.pirest.elas.idx.dto.analysis.ShingleAnalyzer;
import com.pirest.elas.idx.dto.annotation.Mapping;

/**
 * Created by jongpark on 1/16/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Video extends Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	@Mapping.Id
	private String video_id;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String video_guid;
	@Mapping(fieldType = Mapping.FieldType.STRING, analyzer = ShingleAnalyzer.class)
	private String title;
	@Mapping(fieldType = Mapping.FieldType.STRING)
	private String description;
	@Mapping(fieldType = Mapping.FieldType.STRING)
	private String image_url;
	private String media_url;
	private Long duration;
	private String deep_link;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED, analyzer = LowerCaseAnalyzer.class)
	private String source;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String source_id;
	private String source_url;
	@Mapping(fieldType = Mapping.FieldType.DATE)
	private String date_created;
	@Mapping(fieldType = Mapping.FieldType.DATE)
	private String date_publish;
	@Mapping(fieldType = Mapping.FieldType.DATE)
	private String date_expired;
	private Long score;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED, analyzer = LowerCaseAnalyzer.class)
	private String origin;
	@Mapping(fieldType = Mapping.FieldType.NESTED)
	private List<Channel> channels;
	@Mapping(fieldType = Mapping.FieldType.STRING)
	private String referrer_link;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String parental_rating;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String tms_id;
	@Mapping(fieldType = Mapping.FieldType.NESTED)
	private List<Media> media;
	private List<String> keywords;
	@Mapping(fieldType = Mapping.FieldType.NESTED)
	private List<Image> images;

	public Video(String video_id) {
		this.video_id = video_id;
	}

	public Video() {
	}

	public String getParental_rating() {
		return parental_rating;
	}

	public void setParental_rating(String parental_rating) {
		this.parental_rating = parental_rating;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getMedia_url() {
		return media_url;
	}

	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource_id() {
		return source_id;
	}

	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}

	public String getSource_url() {
		return source_url;
	}

	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public String getReferrer_link() {
		return referrer_link;
	}

	public void setReferrer_link(String referrer_link) {
		this.referrer_link = referrer_link;
	}

	public String getDate_publish() {
		return date_publish;
	}

	public void setDate_publish(String date_publish) {
		this.date_publish = date_publish;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public String getVideo_guid() {
		return video_guid;
	}

	public void setVideo_guid(String video_guid) {
		this.video_guid = video_guid;
	}

	public String getTms_id() {
		return tms_id;
	}

	public void setTms_id(String tms_id) {
		this.tms_id = tms_id;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getDate_expired() {
		return date_expired;
	}

	public void setDate_expired(String date_expired) {
		this.date_expired = date_expired;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Video))
			return false;

		Video video = (Video) o;

		return video_id.equals(video.getVideo_id());

	}

	@Override
	public int hashCode() {
		return video_id.hashCode();
	}

	@Override
	@JsonIgnore
	public String getId() {
		return video_id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
