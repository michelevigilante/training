/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.search.spi.model.index.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.training.formExercise.model.Form;
import com.liferay.training.formExercise.service.FormLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michele Vigilante
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.training.formExercise.model.Form",
	service = ModelIndexerWriterContributor.class
)
public class FormModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<Form> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			(Form form) -> batchIndexingActionable.addDocuments(
				modelIndexerWriterDocumentHelper.getDocument(form)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				formLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Form form) {
		return form.getCompanyId();
	}

	public IndexerWriterMode getIndexerWriterMode(Form form) {
		return IndexerWriterMode.UPDATE;
	}

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory
		dynamicQueryBatchIndexingActionableFactory;

	@Reference
	protected FormLocalService formLocalService;

}