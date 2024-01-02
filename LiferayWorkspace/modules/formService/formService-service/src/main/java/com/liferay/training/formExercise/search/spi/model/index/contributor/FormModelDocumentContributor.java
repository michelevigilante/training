/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.training.formExercise.model.Form;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michele Vigilante
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.training.formExercise.model.Form",
	service = ModelDocumentContributor.class
)
public class FormModelDocumentContributor
	implements ModelDocumentContributor<Form> {

	@Override
	public void contribute(Document document, Form form) {
		document.addText(Field.DESCRIPTION, form.getSurname());
		document.addText(Field.COMMENTS, form.getComment());
		document.addText(Field.NAME, form.getName());
	}

}