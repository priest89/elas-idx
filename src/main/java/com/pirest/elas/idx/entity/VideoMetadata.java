package com.pirest.elas.idx.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jongpark on 8/19/16.
 */
@Entity
@Table(name = "video_metadata")
public class VideoMetadata {

    @Id
    @Column(name = "video_id")
    private Long videoId;

    @ManyToOne
    @JoinColumn(name = "network_id")
    private Network network;

    @ManyToOne
    @JoinColumn(name = "content_type_id")
    private ContentType contentType;

    @ManyToOne
    @JoinColumn(name = "content_format_id")
    private ContentFormat contentFormat;

    @ManyToOne
    @JoinColumn(name = "periodicity_id")
    private Periodicity periodicity;

    @ManyToOne
    @JoinColumn(name = "cut_id")
    private Cut cut;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "video_to_sub_genre",
            joinColumns = {
                    @JoinColumn(name = "video_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "sub_genre_id")
            },
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {
                            "video_id", "sub_genre_id"
                    })
            }
    )
    private Set<SubGenre> subGenres;

    @ManyToOne
    @JoinColumn(name = "parental_rating_id")
    private ParentalRating parentalRating;

    @Column(name = "cuepoints")
    private String cuepoints;
    
    @ManyToOne
    @JoinColumn(name = "country_origin_id")
    private Region countryOrigin;
    
    @ManyToOne
    @JoinColumn(name = "audio_language_id")
    private Language audioLanguage;
    
    @Column(name = "keywords")
    private String keywords;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "tms_id")
    private String tms_id;

   public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }


    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }


    public ContentFormat getContentFormat() {
        return contentFormat;
    }

    public void setContentFormat(ContentFormat contentFormat) {
        this.contentFormat = contentFormat;
    }


    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }


    public Cut getCut() {
        return cut;
    }

    public void setCut(Cut cut) {
        this.cut = cut;
    }


    public Set<SubGenre> getSubGenres() {
        return subGenres;
    }

    public void setSubGenres(Set<SubGenre> subGenres) {
        this.subGenres = subGenres;
    }

    public void addSubGenre(SubGenre subGenre) {
        if (this.subGenres == null) {
            this.subGenres = new HashSet<>();
        }
        this.subGenres.add(subGenre);
    }

    public String getCuepoints() {
        return cuepoints;
    }

    public void setCuepoints(String cuepoints) {
        this.cuepoints = cuepoints;
    }

    public ParentalRating getParentalRating() {
        return parentalRating;
    }

    public void setParentalRating(ParentalRating parentalRating) {
        this.parentalRating = parentalRating;
    }

    public Region getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(Region countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public Language getAudioLanguage() {
        return audioLanguage;
    }

    public void setAudioLanguage(Language audioLanguage) {
        this.audioLanguage = audioLanguage;
    }
    
    public String getKeywords() {
        return keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getTms_id() {
        return tms_id;
    }

    public void setTms_id(String tms_id) {
        this.tms_id = tms_id;
    }

//    public Video getVideo() {
//        return video;
//    }
//
//    public void setVideo(Video video) {
//        this.video = video;
//    }
}
