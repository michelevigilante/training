/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.formExercise.model.Form;
import com.liferay.training.formExercise.portlet.util.FormUtil;
import com.liferay.training.formExercise.search.FormSearcher;
import com.liferay.training.formExercise.service.FormLocalServiceUtil;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Michele Vigilante
 */
public class FormViewDisplayContext {

	public FormViewDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		_httpServletRequest = httpServletRequest;
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;

		_themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public String getKeywords() {
		if (_keywords != null) {
			return _keywords;
		}

		_keywords = ParamUtil.getString(_httpServletRequest, "keywords");

		return _keywords;
	}

	public String getNavigation() {
		if (_navigation != null) {
			return _navigation;
		}

		_navigation = ParamUtil.getString(
			_httpServletRequest, "navigation", "all");

		return _navigation;
	}

	public PortletURL getPortletURL() {
		if (_portletURL != null) {
			return _portletURL;
		}

		_portletURL = _liferayPortletResponse.createRenderURL();

		_portletURL.setParameter("mvcRenderCommandName", "/form/view");

		_portletURL.setParameter("navigation", getNavigation());

		return _portletURL;
	}

	public SearchContainer<Form> getSearchContainer() throws PortalException {
		SearchContainer<Form> formSearchContainer = new SearchContainer<>(
			_liferayPortletRequest, null, null,
			SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA,
			getPortletURL(), null, "no-entries-were-found");

		String keywords = getKeywords();

		if (Validator.isNotNull(keywords)) {
			Indexer<?> indexer = FormSearcher.getInstance();

			SearchContext searchContext = SearchContextFactory.getInstance(
				_httpServletRequest);

			searchContext.setAttribute("paginationType", "more");
			searchContext.setEnd(formSearchContainer.getEnd());
			searchContext.setKeywords(keywords);
			searchContext.setStart(formSearchContainer.getStart());

			Hits hits = indexer.search(searchContext);

			formSearchContainer.setResultsAndTotal(
				() -> FormUtil.getEntries(hits), hits.getLength());
		}
		else {
			formSearchContainer.setResultsAndTotal(
				() -> FormLocalServiceUtil.getForms(
					formSearchContainer.getStart(),
					formSearchContainer.getEnd()),
				FormLocalServiceUtil.getFormsCount());
		}

		return formSearchContainer;
	}

	private final HttpServletRequest _httpServletRequest;
	private String _keywords;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private String _navigation;
	private PortletURL _portletURL;
	private final ThemeDisplay _themeDisplay;

}