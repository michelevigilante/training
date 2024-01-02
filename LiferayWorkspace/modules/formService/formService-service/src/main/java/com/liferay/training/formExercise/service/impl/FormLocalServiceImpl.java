/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.formExercise.exception.NoSuchFormException;
import com.liferay.training.formExercise.model.Form;
import com.liferay.training.formExercise.service.base.FormLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.training.formExercise.model.Form",
	service = AopService.class
)
public class FormLocalServiceImpl extends FormLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Form addForm(
			long userId, long groupId, String address, String city,
			String comment, String email, String name, String province,
			String state, int sum, String surName, int val1, int val2,
			ServiceContext serviceContext)
		throws PortalException {

		long formId = counterLocalService.increment(Form.class.getName());

		Form form = formPersistence.create(formId);

		User user = _userLocalService.getUser(userId);

		form.setCompanyId(PortalUtil.getDefaultCompanyId());
		form.setGroupId(groupId);
		form.setFormId(formId);

		form.setUserUuid(serviceContext.getUuid());
		form.setUserId(user.getUserId());
		form.setUserName(user.getFullName());
		form.setAddress(address);
		form.setCity(city);
		form.setComment(comment);
		form.setEmail(email);
		form.setName(name);
		form.setProvince(province);
		form.setState(state);
		form.setSum(sum);
		form.setSurname(surName);
		form.setVal1(val1);
		form.setVal2(val2);
		form.setCreateDate(serviceContext.getCreateDate(new Date()));
		form.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		form.setExpandoBridgeAttributes(serviceContext);

		return formLocalService.addForm(form);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Form deleteForm(Form form) {
		formPersistence.remove(form);

		return form;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Form deleteForm(long formId) throws PortalException {
		Form form = formPersistence.findByPrimaryKey(formId);

		return deleteForm(form);
	}

	public float getAvg() {
		List<Form> lstForm = formLocalService.getForms(
			0, formLocalService.getFormsCount());
		int totalSum = 0;

		for (Form formRecord : lstForm) {
			totalSum += formRecord.getSum();
		}

		return (float)totalSum / (formLocalService.getFormsCount() * 2);
	}

	@Override
	public Form getForm(long formId) throws PortalException {
		return formPersistence.fetchByPrimaryKey(formId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Form updateForm(
			long formId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2, ServiceContext serviceContext)
		throws NoSuchFormException {

		Form form = formPersistence.findByPrimaryKey(formId);

		form.setAddress(address);
		form.setCity(city);
		form.setComment(comment);
		form.setEmail(email);
		form.setName(name);
		form.setProvince(province);
		form.setState(state);
		form.setSum(sum);
		form.setSurname(surName);
		form.setVal1(val1);
		form.setVal2(val2);

		form.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		form.setExpandoBridgeAttributes(serviceContext);

		return formPersistence.update(form);
	}

	@Reference
	private UserLocalService _userLocalService;

}