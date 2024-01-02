/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.training.formExercise.service.FormServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>FormServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormServiceHttp {

	public static com.liferay.training.formExercise.model.Form addForm(
			HttpPrincipal httpPrincipal, long groupId, String address,
			String city, String comment, String email, String name,
			String province, String state, int sum, String surName, int val1,
			int val2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FormServiceUtil.class, "addForm", _addFormParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, address, city, comment, email, name,
				province, state, sum, surName, val1, val2, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.formExercise.model.Form)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.formExercise.model.Form getForm(
			HttpPrincipal httpPrincipal, long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FormServiceUtil.class, "getForm", _getFormParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, formId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.formExercise.model.Form)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.formExercise.model.Form updateForm(
			HttpPrincipal httpPrincipal, long formId, String address,
			String city, String comment, String email, String name,
			String province, String state, int sum, String surName, int val1,
			int val2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.training.formExercise.exception.NoSuchFormException {

		try {
			MethodKey methodKey = new MethodKey(
				FormServiceUtil.class, "updateForm",
				_updateFormParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, formId, address, city, comment, email, name,
				province, state, sum, surName, val1, val2, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.training.formExercise.exception.
							NoSuchFormException) {

					throw (com.liferay.training.formExercise.exception.
						NoSuchFormException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.formExercise.model.Form)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FormServiceHttp.class);

	private static final Class<?>[] _addFormParameterTypes0 = new Class[] {
		long.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, int.class, String.class,
		int.class, int.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getFormParameterTypes1 = new Class[] {
		long.class
	};
	private static final Class<?>[] _updateFormParameterTypes2 = new Class[] {
		long.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, int.class, String.class,
		int.class, int.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};

}