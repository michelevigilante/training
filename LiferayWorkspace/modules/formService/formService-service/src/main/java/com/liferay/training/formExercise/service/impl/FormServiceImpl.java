/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.formExercise.exception.NoSuchFormException;
import com.liferay.training.formExercise.model.Form;
import com.liferay.training.formExercise.service.FormLocalServiceUtil;
import com.liferay.training.formExercise.service.base.FormServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=my", "json.web.service.context.path=Form"
	},
	service = AopService.class
)
public class FormServiceImpl extends FormServiceBaseImpl {

	public Form addForm(
			long groupId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2, ServiceContext serviceContext)
		throws PortalException {

		return FormLocalServiceUtil.addForm(
			getUserId(), groupId, address, city, comment, email, name, province,
			state, sum, surName, val1, val2, serviceContext);
	}

	public Form getForm(long formId) throws PortalException {
		return FormLocalServiceUtil.getForm(formId);
	}

	public Form updateForm(
			long formId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2, ServiceContext serviceContext)
		throws NoSuchFormException {

		return FormLocalServiceUtil.updateForm(
			formId, address, city, comment, email, name, province, state, sum,
			surName, val1, val2, serviceContext);
	}

}