/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormService
 * @generated
 */
public class FormServiceWrapper
	implements FormService, ServiceWrapper<FormService> {

	public FormServiceWrapper() {
		this(null);
	}

	public FormServiceWrapper(FormService formService) {
		_formService = formService;
	}

	@Override
	public com.liferay.training.formExercise.model.Form addForm(
			long groupId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formService.addForm(
			groupId, address, city, comment, email, name, province, state, sum,
			surName, val1, val2, serviceContext);
	}

	@Override
	public com.liferay.training.formExercise.model.Form getForm(long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formService.getForm(formId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.training.formExercise.model.Form updateForm(
			long formId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.training.formExercise.exception.NoSuchFormException {

		return _formService.updateForm(
			formId, address, city, comment, email, name, province, state, sum,
			surName, val1, val2, serviceContext);
	}

	@Override
	public FormService getWrappedService() {
		return _formService;
	}

	@Override
	public void setWrappedService(FormService formService) {
		_formService = formService;
	}

	private FormService _formService;

}