/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.training.formExercise.model.Form;

/**
 * Provides the remote service utility for Form. This utility wraps
 * <code>com.liferay.training.formExercise.service.impl.FormServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FormService
 * @generated
 */
public class FormServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.formExercise.service.impl.FormServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Form addForm(
			long groupId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addForm(
			groupId, address, city, comment, email, name, province, state, sum,
			surName, val1, val2, serviceContext);
	}

	public static Form getForm(long formId) throws PortalException {
		return getService().getForm(formId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Form updateForm(
			long formId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.training.formExercise.exception.NoSuchFormException {

		return getService().updateForm(
			formId, address, city, comment, email, name, province, state, sum,
			surName, val1, val2, serviceContext);
	}

	public static FormService getService() {
		return _service;
	}

	public static void setService(FormService service) {
		_service = service;
	}

	private static volatile FormService _service;

}