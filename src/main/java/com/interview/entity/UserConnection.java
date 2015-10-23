package com.interview.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

class CustomPk implements Serializable{

	private static final long serialVersionUID = -947046936555564886L;
	private String userId;
	private String providerId;
	private String providerUserId;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}
	
	/**
	 * @return the providerUserId
	 */
	public String getProviderUserId() {
		return providerUserId;
	}
	
}

@Entity
@Table(indexes={@Index(columnList="userId, providerId, rank", name="UserConnectionRank", unique=true)})
@JsonInclude(Include.NON_NULL)
@IdClass(CustomPk.class)
public class UserConnection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String userId;
	
	@Id
	private String providerId;
	
	@Id
	private String providerUserId;
	
	private Long rank;

	private String displayName;

	@Column(length = 512)
	private String profileUrl;

	@Column(length = 512)
	private String imageUrl;

	@Column(nullable = false)
	private String accessToken;

	private String secret;

	private String refreshToken;

	private Long expireTime;

	public UserConnection() {

	}

	/**
	 * @param userId
	 * @param providerId
	 * @param providerUserId
	 * @param rank
	 * @param displayName
	 * @param profileUrl
	 * @param imageUrl
	 * @param accessToken
	 * @param secret
	 * @param refreshToken
	 * @param expireTime
	 */
	public UserConnection(String userId, String providerId,
			String providerUserId, Long rank, String displayName,
			String profileUrl, String imageUrl, String accessToken,
			String secret, String refreshToken, Long expireTime) {
		this.userId = userId;
		this.providerId = providerId;
		this.providerUserId = providerUserId;
		this.rank = rank;
		this.displayName = displayName;
		this.profileUrl = profileUrl;
		this.imageUrl = imageUrl;
		this.accessToken = accessToken;
		this.secret = secret;
		this.refreshToken = refreshToken;
		this.expireTime = expireTime;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * @param providerId
	 *            the providerId to set
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	/**
	 * @return the providerUserId
	 */
	public String getProviderUserId() {
		return providerUserId;
	}

	/**
	 * @param providerUserId
	 *            the providerUserId to set
	 */
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	/**
	 * @return the rank
	 */
	public Long getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(Long rank) {
		this.rank = rank;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the profileUrl
	 */
	public String getProfileUrl() {
		return profileUrl;
	}

	/**
	 * @param profileUrl
	 *            the profileUrl to set
	 */
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken
	 *            the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret
	 *            the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * @param refreshToken
	 *            the refreshToken to set
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * @return the expireTime
	 */
	public Long getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime
	 *            the expireTime to set
	 */
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

}
