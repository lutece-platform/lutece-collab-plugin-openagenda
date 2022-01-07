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
 * This is the business class for the EventData
 *
 */
public class EventData
{
	
	@JsonProperty("uid")
	private int _nUid;
	
	@JsonProperty("title")
	private Multilingue _title;
	
	@JsonProperty("description")
	private Multilingue _description;

	@JsonProperty("longDescription")
	private Multilingue _longDescription;

	@JsonProperty("conditions")
	private Multilingue _conditions;
	
	@JsonProperty("keywords")
	private Keywords _keywords;
	
	@JsonProperty("image")
	private Image _image;
	
	@JsonProperty("imageCredits")
	private String _strImageCredits;
	
	@JsonProperty("registration")
	private List<Registration> _listRegistration;
	
	@JsonProperty("accessibility")
	private Accessibility _accessibility;
	
	@JsonProperty("timings")
	private List<Timings> _listTimings;
	
	@JsonProperty("age")
	private Age _age;
	
	@JsonProperty("locationUid")
	private int _nLocationUid;
	
	@JsonProperty("attendanceMode")
	private int _nAttendanceMode;
	
	@JsonProperty("onlineAccessLink")
	private String _strOnlineAccessLink;
	
	@JsonProperty("links")
	private List<Links> _listLinks;
	
	@JsonProperty("timezone")
	private String _strTimezone;
	
	@JsonProperty("state")
	private int _nState;
	
	@JsonProperty("createdAt")
	private String _strCreatedAt;
	
	@JsonProperty("updatedAt")
	private String _strUpdatedAt;

	@JsonProperty("location")
	private LocationData _location;
	
	@JsonProperty("slug")
	private String _strSlug;
	
	@JsonProperty("originAgenda")
	private AgendaData _originAgenda;
	
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
	 * @return the title
	 */
	public Multilingue getTitle() {
		return _title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(Multilingue title) {
		this._title = title;
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
	 * @return the longDescription
	 */
	public Multilingue getLongDescription() {
		return _longDescription;
	}

	/**
	 * @param longDescription the longDescription to set
	 */
	public void setLongDescription(Multilingue longDescription) {
		this._longDescription = longDescription;
	}

	/**
	 * @return the conditions
	 */
	public Multilingue getConditions() {
		return _conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(Multilingue conditions) {
		this._conditions = conditions;
	}

	/**
	 * @return the keywords
	 */
	public Keywords getKeywords() {
		return _keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Keywords keywords) {
		this._keywords = keywords;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return _image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this._image = image;
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
	 * @return the registration
	 */
	public List<Registration> getRegistration() {
		return _listRegistration;
	}

	/**
	 * @param listRegistration the registration to set
	 */
	public void setRegistration(List<Registration> listRegistration) {
		this._listRegistration = listRegistration;
	}

	/**
	 * @return the accessibility
	 */
	public Accessibility getAccessibility() {
		return _accessibility;
	}

	/**
	 * @param accessibility the accessibility to set
	 */
	public void setAccessibility(Accessibility accessibility) {
		this._accessibility = accessibility;
	}

	/**
	 * @return the timings
	 */
	public List<Timings> getTimings() {
		return _listTimings;
	}

	/**
	 * @param listTimings the timings to set
	 */
	public void setTimings(List<Timings> listTimings) {
		this._listTimings = listTimings;
	}

	/**
	 * @return the age
	 */
	public Age getAge() {
		return _age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Age age) {
		this._age = age;
	}

	/**
	 * @return the locationUid
	 */
	public int getLocationUid() {
		return _nLocationUid;
	}

	/**
	 * @param nLocationUid the locationUid to set
	 */
	public void setLocationUid(int nLocationUid) {
		this._nLocationUid = nLocationUid;
	}

	/**
	 * @return the attendanceMode
	 */
	public int getAttendanceMode() {
		return _nAttendanceMode;
	}

	/**
	 * @param nAttendanceMode the attendanceMode to set
	 */
	public void setAttendanceMode(int nAttendanceMode) {
		this._nAttendanceMode = nAttendanceMode;
	}

	/**
	 * @return the onlineAccessLink
	 */
	public String getOnlineAccessLink() {
		return _strOnlineAccessLink;
	}

	/**
	 * @param strOnlineAccessLink the onlineAccessLink to set
	 */
	public void setOnlineAccessLink(String strOnlineAccessLink) {
		this._strOnlineAccessLink = strOnlineAccessLink;
	}

	/**
	 * @return the links
	 */
	public List<Links> getLinks() {
		return _listLinks;
	}

	/**
	 * @param listLinks the links to set
	 */
	public void setLinks(List<Links> listLinks) {
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
	 * @return the location
	 */
	public LocationData getLocation() {
		return _location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(LocationData location) {
		this._location = location;
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
	 * @return the originAgenda
	 */
	public AgendaData getOriginAgenda() {
		return _originAgenda;
	}

	/**
	 * @param originAgenda the originAgenda to set
	 */
	public void setOriginAgenda(AgendaData originAgenda) {
		this._originAgenda = originAgenda;
	}

}
