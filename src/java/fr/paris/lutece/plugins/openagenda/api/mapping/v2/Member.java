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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This is the business class for the Member
 *
 */
public class Member
{
	@JsonProperty("userUid")
	private int _nUserUid;
	
	@JsonProperty("name")
	private String _strName;
	
	@JsonProperty("phone")
	private String _strPhone;
	
	@JsonProperty("email")
	private String _strEmail;
	
	@JsonProperty("position")
	private String _strPosition;
	
	@JsonProperty("organization")
	private String _strOrganization;
	
	@JsonProperty("role")
	private String _strRole;

	/**
	 * @return the userUid
	 */
	public int getUserUid() {
		return _nUserUid;
	}

	/**
	 * @param nUserUid the userUid to set
	 */
	public void setUserUid(int nUserUid) {
		this._nUserUid = nUserUid;
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
	 * @return the position
	 */
	public String getPosition() {
		return _strPosition;
	}

	/**
	 * @param strPosition the position to set
	 */
	public void setPosition(String strPosition) {
		this._strPosition = strPosition;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return _strOrganization;
	}

	/**
	 * @param strOrganization the organization to set
	 */
	public void setOrganization(String strOrganization) {
		this._strOrganization = strOrganization;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return _strRole;
	}

	/**
	 * @param strRole the role to set
	 */
	public void setRole(String strRole) {
		this._strRole = strRole;
	}
	
}
