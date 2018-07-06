package com.pirest.elas.idx.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pirest.elas.idx.dto.analysis.ShingleAnalyzer;
import com.pirest.elas.idx.dto.annotation.Mapping;

/**
 * Created by jongpark on 1/16/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Channel extends Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	@Mapping.Id
	private String channel_id;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String channel_guid;
	@Mapping(fieldType = Mapping.FieldType.STRING, analyzer = ShingleAnalyzer.class)
	private String title;
	private String short_title;
	private String shorter_title;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String channel_type;
	@Mapping(fieldType = Mapping.FieldType.STRING)
	private String description;
	@Mapping(fieldType = Mapping.FieldType.STRING)
	private String image_url;
	private Boolean recommended;
	private Long update_frequency;
	private Long popularity;
	private Boolean addable;
	private Boolean reorderable;
	private Boolean frequency_sync;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String parental_rating;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String tms_id;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String network;
	@Mapping(fieldType = Mapping.FieldType.DATE)
	private String date_created;
	@Mapping(fieldType = Mapping.FieldType.NESTED)
	private List<Category> categories;
	@Mapping(fieldType = Mapping.FieldType.NESTED)
	private List<App> apps;
	@Mapping(fieldType = Mapping.FieldType.NESTED)
	private List<Image> images;

	public Channel(String channel_id) {
		this.channel_id = channel_id;
	}

	public Channel() {
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShort_title() {
		return short_title;
	}

	public void setShort_title(String short_title) {
		this.short_title = short_title;
	}

	public String getShorter_title() {
		return shorter_title;
	}

	public void setShorter_title(String shorter_title) {
		this.shorter_title = shorter_title;
	}

	public String getChannel_type() {
		return channel_type;
	}

	public void setChannel_type(String channel_type) {
		this.channel_type = channel_type;
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

	public Boolean getRecommended() {
		return recommended;
	}

	public void setRecommended(Boolean recommended) {
		if (recommended == null)
			recommended = false;
		this.recommended = recommended;
	}

	public Long getUpdate_frequency() {
		return update_frequency;
	}

	public void setUpdate_frequency(Long update_frequency) {
		this.update_frequency = update_frequency;
	}

	public Long getPopularity() {
		return popularity;
	}

	public void setPopularity(Long popularity) {
		this.popularity = popularity;
	}

	public Boolean getAddable() {
		return addable;
	}

	public void setAddable(Boolean addable) {
		if (addable == null)
			addable = true;
		this.addable = addable;
	}

	public Boolean getReorderable() {
		return reorderable;
	}

	public void setReorderable(Boolean reorderable) {
		if (reorderable == null)
			reorderable = true;
		this.reorderable = reorderable;
	}

	public Boolean getFrequency_sync() {
		return frequency_sync;
	}

	public void setFrequency_sync(Boolean frequency_sync) {
		this.frequency_sync = frequency_sync;
	}

	public String getChannel_guid() {
		return channel_guid;
	}

	public void setChannel_guid(String channel_guid) {
		this.channel_guid = channel_guid;
	}

	public String getParental_rating() {
		return parental_rating;
	}

	public void setParental_rating(String parental_rating) {
		this.parental_rating = parental_rating;
	}

	public String getTms_id() {
		return tms_id;
	}

	public void setTms_id(String tms_id) {
		this.tms_id = tms_id;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<App> getApps() {
		return apps;
	}

	public void setApps(List<App> apps) {
		this.apps = apps;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Channel))
			return false;

		Channel channel = (Channel) o;

		return channel_id.equals(channel.getChannel_id());

	}

	@Override
	public int hashCode() {
		return channel_id.hashCode();
	}

	@Override
	@JsonIgnore
	public String getId() {
		return channel_id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
