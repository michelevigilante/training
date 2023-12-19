<%--
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
FormViewDisplayContext formViewDisplayContext = new FormViewDisplayContext(request, liferayPortletRequest, liferayPortletResponse);

FormManagementToolbarDisplayContext formManagementToolbarDisplayContext = new FormManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, formViewDisplayContext);

String keywords = ParamUtil.getString(request, "keywords");
%>

<clay:management-toolbar
	displayContext="<%= formManagementToolbarDisplayContext %>"
	searchActionURL="<%= formManagementToolbarDisplayContext.getSearchActionURL() %>"
	selectable="<%= formManagementToolbarDisplayContext.isSelectable() %>"
/>

<liferay-ui:search-container
	searchContainer="<%= formViewDisplayContext.getSearchContainer() %>"
>
	<liferay-ui:search-container-row
		className="com.liferay.training.formExercise.model.Form"
		escapedModel="<%= true %>"
		keyProperty="formId"
		modelVar="form"
	>
		<liferay-ui:search-container-column-text property="address" />
		<liferay-ui:search-container-column-text property="city" />
		<liferay-ui:search-container-column-text property="comment" />
		<liferay-ui:search-container-column-text property="email" />
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text property="state" />
		<liferay-ui:search-container-column-text property="surname" />

		<liferay-ui:search-container-column-text property="val1" />
		<liferay-ui:search-container-column-text property="val2" />
		<liferay-ui:search-container-column-text property="sum" />

		<liferay-ui:search-container-column-text name="Action">
			<portlet:renderURL var="editForm">
				<portlet:param name="mvcRenderCommandName" value="editForm" />
				<portlet:param name="formId" value="${form.formId}" />
			</portlet:renderURL>

			<portlet:actionURL name="deleteForm" var="deleteForm">
				<portlet:param name="formId" value="${form.formId}" />
			</portlet:actionURL>

			<liferay-ui:icon-menu
				direction="left-side"
				markupView="lexicon"
			>
				<liferay-ui:icon
					message="edit"
					url="${editForm}"
				/>

				<liferay-ui:icon
					message="delete"
					url="${deleteForm}"
				/>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>