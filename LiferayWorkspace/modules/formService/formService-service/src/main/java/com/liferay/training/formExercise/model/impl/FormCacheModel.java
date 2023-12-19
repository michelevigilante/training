/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.formExercise.model.Form;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Form in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormCacheModel implements CacheModel<Form>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FormCacheModel)) {
			return false;
		}

		FormCacheModel formCacheModel = (FormCacheModel)object;

		if (formId == formCacheModel.formId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, formId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", formId=");
		sb.append(formId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", email=");
		sb.append(email);
		sb.append(", name=");
		sb.append(name);
		sb.append(", province=");
		sb.append(province);
		sb.append(", state=");
		sb.append(state);
		sb.append(", sum=");
		sb.append(sum);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", val1=");
		sb.append(val1);
		sb.append(", val2=");
		sb.append(val2);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Form toEntityModel() {
		FormImpl formImpl = new FormImpl();

		formImpl.setGroupId(groupId);
		formImpl.setFormId(formId);
		formImpl.setCompanyId(companyId);
		formImpl.setUserId(userId);

		if (userName == null) {
			formImpl.setUserName("");
		}
		else {
			formImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			formImpl.setCreateDate(null);
		}
		else {
			formImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			formImpl.setModifiedDate(null);
		}
		else {
			formImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (address == null) {
			formImpl.setAddress("");
		}
		else {
			formImpl.setAddress(address);
		}

		if (city == null) {
			formImpl.setCity("");
		}
		else {
			formImpl.setCity(city);
		}

		if (comment == null) {
			formImpl.setComment("");
		}
		else {
			formImpl.setComment(comment);
		}

		if (email == null) {
			formImpl.setEmail("");
		}
		else {
			formImpl.setEmail(email);
		}

		if (name == null) {
			formImpl.setName("");
		}
		else {
			formImpl.setName(name);
		}

		if (province == null) {
			formImpl.setProvince("");
		}
		else {
			formImpl.setProvince(province);
		}

		if (state == null) {
			formImpl.setState("");
		}
		else {
			formImpl.setState(state);
		}

		formImpl.setSum(sum);

		if (surname == null) {
			formImpl.setSurname("");
		}
		else {
			formImpl.setSurname(surname);
		}

		formImpl.setVal1(val1);
		formImpl.setVal2(val2);

		formImpl.resetOriginalValues();

		return formImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();

		formId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		comment = objectInput.readUTF();
		email = objectInput.readUTF();
		name = objectInput.readUTF();
		province = objectInput.readUTF();
		state = objectInput.readUTF();

		sum = objectInput.readInt();
		surname = objectInput.readUTF();

		val1 = objectInput.readInt();

		val2 = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(groupId);

		objectOutput.writeLong(formId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (province == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(province);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeInt(sum);

		if (surname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surname);
		}

		objectOutput.writeInt(val1);

		objectOutput.writeInt(val2);
	}

	public long groupId;
	public long formId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String address;
	public String city;
	public String comment;
	public String email;
	public String name;
	public String province;
	public String state;
	public int sum;
	public String surname;
	public int val1;
	public int val2;

}