/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.search.spi;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchConfigurator;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.training.formExercise.model.Form;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michele Vigilante
 */
@Component(service = ModelSearchConfigurator.class)
public class FormModelSearchConfigurator
	implements ModelSearchConfigurator<Form> {

	@Override
	public String getClassName() {
		return Form.class.getName();
	}

	@Override
	public String[] getDefaultSelectedFieldNames() {
		return new String[] {
			Field.COMPANY_ID, Field.GROUP_ID, Field.NAME, Field.COMMENTS,
			Field.DESCRIPTION
		};
	}

	@Override
	public ModelIndexerWriterContributor<Form>
		getModelIndexerWriterContributor() {

		return _modelIndexWriterContributor;
	}

	@Override
	public ModelSummaryContributor getModelSummaryContributor() {
		return _modelSummaryContributor;
	}

	@Reference(
		target = "(indexer.class.name=com.liferay.training.formExercise.model.Form)"
	)
	private ModelIndexerWriterContributor<Form> _modelIndexWriterContributor;

	@Reference(
		target = "(indexer.class.name=com.liferay.training.formExercise.model.Form)"
	)
	private ModelSummaryContributor _modelSummaryContributor;

}