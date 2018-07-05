package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the USER_TOKEN database table.
 *
 * <p>
 *     <b>Notes</b>
 *     <p>
 *         Regarding the field {@link com.frequency.dataservice.entity.UserToken#tokenType}
 *         <ul>
 *             <li>
 *                 The column {@code token_type_id} is represented by the {@link com.frequency.dataservice.entity.UserToken.TokenType}
 *                 enum and not an entity to reduce the table join that is unnecessary.<br/>
 *             </li>
 *             <li>
 *                 To force the {@link com.frequency.dataservice.entity.UserToken.TokenType} ordinal to start from 1, the 0th
 *                 ordinal is taken by {@link com.frequency.dataservice.entity.UserToken.TokenType#PLACEHOLDER}. It has been
 *                 annotated as deprecated. DO NOT USE.
 *             </li>
 *             <li>
 *                 To add more {@link com.frequency.dataservice.entity.UserToken.TokenType}s, add them to the {@code frequency.token_type}
 *                 table and update the {@link com.frequency.dataservice.entity.UserToken.TokenType} enum accordingly.
 *             </li>
 *         </ul>
 *     </p>
 * </p>
 */
@Entity
@Table(name = "user_token")
public class UserToken implements Serializable {
	private static final long serialVersionUID = 1L;

    /*public enum TokenType {
        @Deprecated
        PLACEHOLDER(0),     // placeholder to make ordinal start from '1'. do NOT use.
        ACCESS_TOKEN(1),    // access tokens
        REFRESH_TOKEN(2);   // refresh tokens

        private int tokenTypeId;

        private TokenType(int tokenTypeId) {
            this.tokenTypeId = tokenTypeId;
        }

        public int getTokenTypeId() {
            return tokenTypeId;
        }

        public static TokenType fromTokenTypeId(int tokenTypeId) {
            for (TokenType type : TokenType.values()) {
                if (type.getTokenTypeId() == tokenTypeId) {
                    return type;
                }
            }
            return null;
        }
    }*/

	@Id
	@Column(name = "user_token_id")
	private long userTokenId;

    @Column(length = 255, nullable = false)
	private String token;

//    @Enumerated(EnumType.ORDINAL)
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
	@JoinColumn(name = "token_type_id", nullable = false)
    private TokenType tokenType;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="expiration_date", columnDefinition = "DATETIME")
    private Date expirationDate;
    
    public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@PrePersist
    protected void onCreate() {
        Date date = new Date();
        createDate = date;
        lastmodified = date;
    }

    @PreUpdate
    protected void onUpdate() {
        lastmodified = new Date();
    }

    public UserToken() {
	}

	public long getUserTokenId() {
		return this.userTokenId;
	}

	public void setUserTokenId(long userTokenId) {
		this.userTokenId = userTokenId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public User getUser() {
        return this.user;
    }

	public void setUser(User user) {
		this.user = user;
        if (user != null && !user.getUserTokens().contains(this)) {
            user.addUserToken(this);
        }
	}

}