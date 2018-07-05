package com.pirest.elas.idx.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sub_genre")
public class SubGenre {
	@Id
	@GeneratedValue
	@Column(name = "sub_genre_id", insertable = false, updatable = false, nullable = false, unique = true)
	private int sub_genre_id;

	@Column(name = "sub_genre")
	private String subGenre;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;

	@OneToMany(mappedBy = "user", cascade = {}, fetch = FetchType.LAZY)
	private List<ChannelToUser> channelToUsers = new ArrayList<>();

	public int getSub_genre_id() {
		return sub_genre_id;
	}

	public String getSubGenre() {
		return subGenre;
	}

	public void setSubGenre(String subGenre) {
		this.subGenre = subGenre;
	}

	public Genre getGenre() {
		return genre;
	}

	public List<ChannelToUser> getChannelToUsers() {
		return channelToUsers;
	}

	public void setChannelToUsers(List<ChannelToUser> channelToUsers) {
		this.channelToUsers = channelToUsers;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SubGenre))
			return false;
		SubGenre subGenre = (SubGenre) o;
		return Objects.equals(sub_genre_id, subGenre.sub_genre_id);
	}

	public int hashCode() {
		return Objects.hash(sub_genre_id);
	}
}