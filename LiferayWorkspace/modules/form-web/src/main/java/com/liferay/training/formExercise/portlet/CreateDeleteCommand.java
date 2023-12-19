/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.formExercise.constants.FormControllerPortletKeys;
import com.liferay.training.formExercise.service.FormLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michele Vigilante
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FormControllerPortletKeys.FORMCONTROLLER,
		"mvc.command.name=deleteForm"
	},
	service = MVCActionCommand.class
)
public class CreateDeleteCommand implements MVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		long formId = ParamUtil.getLong(actionRequest, "formId");

		try {
			_formLocalService.deleteForm(formId);
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}

		return true;
	}

	@Reference
	private FormLocalService _formLocalService;

}