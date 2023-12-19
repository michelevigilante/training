/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.portlet;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
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
		"mvc.command.name=/getAvg"
	},
	service = MVCResourceCommand.class
)
public class FormCalcAvg implements MVCResourceCommand {

	@Override
	public boolean serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		JSONObject jsonResponse = JSONUtil.put(
			"avg", String.valueOf(FormLocalServiceUtil.getAvg()));

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