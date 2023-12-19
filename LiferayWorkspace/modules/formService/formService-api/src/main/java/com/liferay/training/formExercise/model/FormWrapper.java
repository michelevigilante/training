/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Form}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Form
 * @generated
 */
public class FormWrapper
	extends BaseModelWrapper<Form> implements Form, ModelWrapper<Form> {

	public FormWrapper(Form form) {
		super(form);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("formId", getFormId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("comment", getComment());
		attributes.put("email", getEmail());
		attributes.put("name", getName());
		attributes.put("province", getProvince());
		attributes.put("state", getState());
		attributes.put("sum", getSum());
		attributes.put("surname", getSurname());
		attributes.put("val1", getVal1());
		attributes.put("val2", getVal2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String province = (String)attributes.get("province");

		if (province != null) {
			setProvince(province);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Integer sum = (Integer)attributes.get("sum");

		if (sum != null) {
			setSum(sum);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		Integer val1 = (Integer)attributes.get("val1");

		if (val1 != null) {
			setVal1(val1);
		}

		Integer val2 = (Integer)attributes.get("val2");

		if (val2 != null) {
			setVal2(val2);
		}
	}

	@Override
	public Form cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this form.
	 *
	 * @return the address of this form
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the city of this form.
	 *
	 * @return the city of this form
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the comment of this form.
	 *
	 * @return the comment of this form
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the company ID of this form.
	 *
	 * @return the company ID of this form
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this form.
	 *
	 * @return the create date of this form
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this form.
	 *
	 * @return the email of this form
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the form ID of this form.
	 *
	 * @return the form ID of this form
	 */
	@Override
	public long getFormId() {
		return model.getFormId();
	}

	/**
	 * Returns the group ID of this form.
	 *
	 * @return the group ID of this form
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this form.
	 *
	 * @return the modified date of this form
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this form.
	 *
	 * @return the name of this form
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this form.
	 *
	 * @return the primary key of this form
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the province of this form.
	 *
	 * @return the province of this form
	 */
	@Override
	public String getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the state of this form.
	 *
	 * @return the state of this form
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the sum of this form.
	 *
	 * @return the sum of this form
	 */
	@Override
	public int getSum() {
		return model.getSum();
	}

	/**
	 * Returns the surname of this form.
	 *
	 * @return the surname of this form
	 */
	@Override
	public String getSurname() {
		return model.getSurname();
	}

	/**
	 * Returns the user ID of this form.
	 *
	 * @return the user ID of this form
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this form.
	 *
	 * @return the user name of this form
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this form.
	 *
	 * @return the user uuid of this form
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the val1 of this form.
	 *
	 * @return the val1 of this form
	 */
	@Override
	public int getVal1() {
		return model.getVal1();
	}

	/**
	 * Returns the val2 of this form.
	 *
	 * @return the val2 of this form
	 */
	@Override
	public int getVal2() {
		return model.getVal2();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this form.
	 *
	 * @param address the address of this form
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the city of this form.
	 *
	 * @param city the city of this form
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the comment of this form.
	 *
	 * @param comment the comment of this form
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the company ID of this form.
	 *
	 * @param companyId the company ID of this form
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this form.
	 *
	 * @param createDate the create date of this form
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this form.
	 *
	 * @param email the email of this form
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the form ID of this form.
	 *
	 * @param formId the form ID of this form
	 */
	@Override
	public void setFormId(long formId) {
		model.setFormId(formId);
	}

	/**
	 * Sets the group ID of this form.
	 *
	 * @param groupId the group ID of this form
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this form.
	 *
	 * @param modifiedDate the modified date of this form
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this form.
	 *
	 * @param name the name of this form
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this form.
	 *
	 * @param primaryKey the primary key of this form
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the province of this form.
	 *
	 * @param province the province of this form
	 */
	@Override
	public void setProvince(String province) {
		model.setProvince(province);
	}

	/**
	 * Sets the state of this form.
	 *
	 * @param state the state of this form
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the sum of this form.
	 *
	 * @param sum the sum of this form
	 */
	@Override
	public void setSum(int sum) {
		model.setSum(sum);
	}

	/**
	 * Sets the surname of this form.
	 *
	 * @param surname the surname of this form
	 */
	@Override
	public void setSurname(String surname) {
		model.setSurname(surname);
	}

	/**
	 * Sets the user ID of this form.
	 *
	 * @param userId the user ID of this form
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this form.
	 *
	 * @param userName the user name of this form
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this form.
	 *
	 * @param userUuid the user uuid of this form
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the val1 of this form.
	 *
	 * @param val1 the val1 of this form
	 */
	@Override
	public void setVal1(int val1) {
		model.setVal1(val1);
	}

	/**
	 * Sets the val2 of this form.
	 *
	 * @param val2 the val2 of this form
	 */
	@Override
	public void setVal2(int val2) {
		model.setVal2(val2);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FormWrapper wrap(Form form) {
		return new FormWrapper(form);
	}

}