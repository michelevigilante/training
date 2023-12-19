/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.search.spi;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.OpenSearch;
import com.liferay.training.formExercise.model.Form;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michele Vigilante
 */
@Component(service = OpenSearch.class)
public class FormOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String TITLE = "Liferay Form Search: ";

	@Override
	public String getClassName() {
		return Form.class.getName();
	}

	@Override
	public Indexer<Form> getIndexer() {
		return IndexerRegistryUtil.getIndexer(Form.class);
	}

	@Override
	public String getSearchPath() {
		return StringPool.BLANK;
	}

	@Override
	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

}