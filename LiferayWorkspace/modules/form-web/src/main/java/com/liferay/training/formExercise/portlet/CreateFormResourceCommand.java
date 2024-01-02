/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.formExercise.constants.FormControllerPortletKeys;
import com.liferay.training.formExercise.service.FormLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michele Vigilante
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FormControllerPortletKeys.FORMCONTROLLER,
		"mvc.command.name=/formSubmitURL"
	},
	service = MVCResourceCommand.class
)
public class CreateFormResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = new ServiceContext();
		long userId = themeDisplay.getUserId();

		long groupId = themeDisplay.getScopeGroupId();

		String address = ParamUtil.getString(resourceRequest, "address");
		String city = ParamUtil.getString(resourceRequest, "city");
		String comment = ParamUtil.getString(resourceRequest, "comment");
		String email = ParamUtil.getString(resourceRequest, "email");
		String name = ParamUtil.getString(resourceRequest, "name");
		String province = ParamUtil.getString(resourceRequest, "province");
		String state = ParamUtil.getString(resourceRequest, "state");
		String surname = ParamUtil.getString(resourceRequest, "surname");

		int val1 = ParamUtil.getInteger(resourceRequest, "val1");
		int val2 = ParamUtil.getInteger(resourceRequest, "val2");

		int sum = val1 + val2;

		try {
			FormLocalServiceUtil.addForm(
				userId, groupId, address, city, comment, email, name, province,
				state, sum, surname, val1, val2, serviceContext);
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}

		JSONObject jsonResponse = JSONUtil.put("sum", String.valueOf(sum));

		PrintWriter writer;

		try {
			writer = resourceResponse.getWriter();
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}

		writer.println(jsonResponse);

		return false;
	}

}