/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.formExercise.constants.FormControllerPortletKeys;
import com.liferay.training.formExercise.service.FormLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michele Vigilante
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FormControllerPortletKeys.FORMCONTROLLER,
		"mvc.command.name=updateForm"
	},
	service = MVCActionCommand.class
)
public class UpdateFormActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		ServiceContext serviceContext = new ServiceContext();

		long formId = ParamUtil.getLong(actionRequest, "formId");

		String address = ParamUtil.getString(actionRequest, "address");

		String city = ParamUtil.getString(actionRequest, "city");
		String comment = ParamUtil.getString(actionRequest, "comment");
		String email = ParamUtil.getString(actionRequest, "email");
		String name = ParamUtil.getString(actionRequest, "name");
		String province = ParamUtil.getString(actionRequest, "province");
		String state = ParamUtil.getString(actionRequest, "state");
		String surname = ParamUtil.getString(actionRequest, "surname");

		int val1 = ParamUtil.getInteger(actionRequest, "val1");
		int val2 = ParamUtil.getInteger(actionRequest, "val2");

		int sum = val1 + val2;

		try {
			FormLocalServiceUtil.updateForm(
				formId, address, city, comment, email, name, province, state,
				sum, surname, val1, val2, serviceContext);
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}

		return true;
	}

}