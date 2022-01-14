/*
 * Copyright (c) 2002-2022, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.openagenda.api.mapping.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This is the business class for the LocationData
 *
 */
public class LocationData
{
	@JsonProperty("uid")
	private int _nUid;
	
	@JsonProperty("name")
	private String _strName;
	
	@JsonProperty("address")
	private String _strAddress;
	
	@JsonProperty("access")
	private Multilingue _access;
	
	@JsonProperty("description")
	private Multilingue _description;
	
	@JsonProperty("image")
	private String _strImage;
	
	@JsonProperty("imageCredits")
	private String _strImageCredits;
	
	@JsonProperty("slug")
	private String _strSlug;
	
	@JsonProperty("setUid")
	private String _strSetUid;
	
	@JsonProperty("city")
	private String _strCity;
	
	@JsonProperty("department")
	private String _strDepartment;
	
	@JsonProperty("region")
	private String _strRegion;
	
	@JsonProperty("postalCode")
	private String _strPostalCode;
	
	@JsonProperty("insee")
	private String _strInsee;
	
	@JsonProperty("countryCode")
	private String _strCountryCode;
	
	@JsonProperty("district")
	private String _strDistrict;
	
	@JsonProperty("latitude")
	private Float _fLatitude;
	
	@JsonProperty("longitude")
	private Float _fLongitude;
	
	@JsonProperty("updatedAt")
	private String _strUpdatedAt;
	
	@JsonProperty("createdAt")
	private String _strCreatedAt;
	
	@JsonProperty("website")
	private String _strWebsite;
	
	@JsonProperty("email")
	private String _strEmail;
	
	@JsonProperty("phone")
	private String _strPhone;
	
	@JsonProperty("links")
	private List<String> _listLinks;
	
	@JsonProperty("timezone")
	private String _strTimezone;
	
	@JsonProperty("extId")
	private String _strExtId;
	
	@JsonProperty("state")
	private int _nState;

	/**
	 * @return the uid
	 */
	public int getUid() {
		return _nUid;
	}

	/**
	 * @param nUid the uid to set
	 */
	public void setUid(int nUid) {
		this._nUid = nUid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return _strName;
	}

	/**
	 * @param strName the name to set
	 */
	public void setName(String strName) {
		this._strName = strName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return _strAddress;
	}

	/**
	 * @param strAddress the address to set
	 */
	public void setAddress(String strAddress) {
		this._strAddress = strAddress;
	}

	/**
	 * @return the access
	 */
	public Multilingue getAccess() {
		return _access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(Multilingue access) {
		this._access = access;
	}

	/**
	 * @return the description
	 */
	public Multilingue getDescription() {
		return _description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(Multilingue description) {
		this._description = description;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return _strImage;
	}

	/**
	 * @param strImage the image to set
	 */
	public void setImage(String strImage) {
		this._strImage = strImage;
	}

	/**
	 * @return the imageCredits
	 */
	public String getImageCredits() {
		return _strImageCredits;
	}

	/**
	 * @param strImageCredits the imageCredits to set
	 */
	public void setImageCredits(String strImageCredits) {
		this._strImageCredits = strImageCredits;
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return _strSlug;
	}

	/**
	 * @param strSlug the slug to set
	 */
	public void setSlug(String strSlug) {
		this._strSlug = strSlug;
	}

	/**
	 * @return the setUid
	 */
	public String getSetUid() {
		return _strSetUid;
	}

	/**
	 * @param strSetUid the setUid to set
	 */
	public void setSetUid(String strSetUid) {
		this._strSetUid = strSetUid;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return _strCity;
	}

	/**
	 * @param strCity the city to set
	 */
	public void setCity(String strCity) {
		this._strCity = strCity;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return _strDepartment;
	}

	/**
	 * @param strDepartment the department to set
	 */
	public void setDepartment(String strDepartment) {
		this._strDepartment = strDepartment;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return _strRegion;
	}

	/**
	 * @param strRegion the region to set
	 */
	public void setRegion(String strRegion) {
		this._strRegion = strRegion;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return _strPostalCode;
	}

	/**
	 * @param strPostalCode the postalCode to set
	 */
	public void setPostalCode(String strPostalCode) {
		this._strPostalCode = strPostalCode;
	}

	/**
	 * @return the insee
	 */
	public String getInsee() {
		return _strInsee;
	}

	/**
	 * @param strInsee the insee to set
	 */
	public void setInsee(String strInsee) {
		this._strInsee = strInsee;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return _strCountryCode;
	}

	/**
	 * @param strCountryCode the countryCode to set
	 */
	public void setCountryCode(String strCountryCode) {
		this._strCountryCode = strCountryCode;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return _strDistrict;
	}

	/**
	 * @param strDistrict the district to set
	 */
	public void setDistrict(String strDistrict) {
		this._strDistrict = strDistrict;
	}

	/**
	 * @return the latitude
	 */
	public Float getLatitude() {
		return _fLatitude;
	}

	/**
	 * @param fLatitude the latitude to set
	 */
	public void setLatitude(Float fLatitude) {
		this._fLatitude = fLatitude;
	}

	/**
	 * @return the longitude
	 */
	public Float getLongitude() {
		return _fLongitude;
	}

	/**
	 * @param fLongitude the longitude to set
	 */
	public void setLongitude(Float fLongitude) {
		this._fLongitude = fLongitude;
	}

	/**
	 * @return the updatedAt
	 */
	public String getUpdatedAt() {
		return _strUpdatedAt;
	}

	/**
	 * @param strUpdatedAt the updatedAt to set
	 */
	public void setUpdatedAt(String strUpdatedAt) {
		this._strUpdatedAt = strUpdatedAt;
	}

	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return _strCreatedAt;
	}

	/**
	 * @param strCreatedAt the createdAt to set
	 */
	public void setCreatedAt(String strCreatedAt) {
		this._strCreatedAt = strCreatedAt;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return _strWebsite;
	}

	/**
	 * @param strWebsite the website to set
	 */
	public void setWebsite(String strWebsite) {
		this._strWebsite = strWebsite;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return _strEmail;
	}

	/**
	 * @param strEmail the email to set
	 */
	public void setEmail(String strEmail) {
		this._strEmail = strEmail;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return _strPhone;
	}

	/**
	 * @param strPhone the phone to set
	 */
	public void setPhone(String strPhone) {
		this._strPhone = strPhone;
	}

	/**
	 * @return the links
	 */
	public List<String> getLinks() {
		return _listLinks;
	}

	/**
	 * @param listLinks the links to set
	 */
	public void setLinks(List<String> listLinks) {
		this._listLinks = listLinks;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return _strTimezone;
	}

	/**
	 * @param strTimezone the timezone to set
	 */
	public void setTimezone(String strTimezone) {
		this._strTimezone = strTimezone;
	}

	/**
	 * @return the extId
	 */
	public String getExtId() {
		return _strExtId;
	}

	/**
	 * @param strExtId the extId to set
	 */
	public void setExtId(String strExtId) {
		this._strExtId = strExtId;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return _nState;
	}

	/**
	 * @param nState the state to set
	 */
	public void setState(int nState) {
		this._nState = nState;
	}
}
