/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.formExercise.constants.FormControllerPortletKeys;
import com.liferay.training.formExercise.service.FormService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michele Vigilante
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FormControllerPortletKeys.FORMCONTROLLER,
		"mvc.command.name=editForm"
	},
	service = MVCRenderCommand.class
)
public class CreateRenderCommandEditForm implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long formId = ParamUtil.getLong(renderRequest, "formId");

		try {
			renderRequest.setAttribute("form", _formService.getForm(formId));
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}

		return "/edit.jsp";
	}

	@Reference(unbind = "-")
	protected void setFormService(FormService formService) {
		_formService = formService;
	}

	private FormService _formService;

}