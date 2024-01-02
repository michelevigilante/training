/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.training.formExercise.model.Form;
import com.liferay.training.formExercise.service.FormLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michele Vigilante
 */
public class FormUtil {

	public static List<Form> getEntries(Hits hits) throws PortalException {
		List<Form> entries = new ArrayList<>();

		for (Document document : hits.getDocs()) {
			long formClassPK = GetterUtil.getLong(
				document.get(Field.ENTRY_CLASS_PK));

			Form formObject = FormLocalServiceUtil.getForm(formClassPK);

			entries.add(formObject);
		}

		return entries;
	}

}