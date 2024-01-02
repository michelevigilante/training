/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.search.spi;

import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;
import com.liferay.training.formExercise.model.Form;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michele Vigilante
 */
@Component(
	property = "model.class.name=com.liferay.training.formExercise.model.Form",
	service = BaseSearcher.class
)
public class FormEntrySearcher extends BaseSearcher {

	public static final String CLASS_NAME = Form.class.getName();

	public FormEntrySearcher() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.GROUP_ID, Field.ENTRY_CLASS_NAME,
			Field.ENTRY_CLASS_PK, Field.NAME, Field.DESCRIPTION, Field.UID,
			Field.COMMENTS);

		setFilterSearch(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}