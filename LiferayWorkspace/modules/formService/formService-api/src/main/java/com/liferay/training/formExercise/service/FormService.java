/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.training.formExercise.exception.NoSuchFormException;
import com.liferay.training.formExercise.model.Form;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Form. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FormServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FormService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.training.formExercise.service.impl.FormServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the form remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FormServiceUtil} if injection and service tracking are not available.
	 */
	public Form addForm(
			long groupId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Form getForm(long formId) throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Form updateForm(
			long formId, String address, String city, String comment,
			String email, String name, String province, String state, int sum,
			String surName, int val1, int val2, ServiceContext serviceContext)
		throws NoSuchFormException;

}