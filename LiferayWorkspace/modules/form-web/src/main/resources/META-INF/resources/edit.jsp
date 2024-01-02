<%--
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:actionURL name="updateForm" var="updateForm" />

<aui:form action="${updateForm}" method="post">
	<aui:model-context bean="${form}" model="<%= Form.class %>" />

	<aui:fieldset label="Personal Information">
		<aui:input name="formId" type="hidden" />

		<aui:row>
			<aui:col width="50">
				<aui:input label="Numero 1" name="val1" type="number">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>

			<aui:col width="50">
				<aui:input label="Numero2" name="val2" type="number">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col width="30">
				<aui:input label="Name" name="name" type="text">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>

			<aui:col width="30">
				<aui:input label="Surname" name="surname" type="text">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>

			<aui:col width="30">
				<aui:input label="Email" name="email" type="email">
					<aui:validator name="email" />
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col width="30">
				<aui:input label="State" name="state" type="text">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>

			<aui:col width="30">
				<aui:input label="Province" name="province" type="text">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>

			<aui:col width="30">
				<aui:input label="City" name="city" type="text">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col width="100">
				<aui:input label="Address" name="address" type="text">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>

		<aui:input label="Comment" name="comment" type="textarea">
			<aui:validator name="required" />
		</aui:input>

		<div>Sum is: <p id="sum" /></div>

		<aui:row>
			<aui:col width="5">
				<aui:button name="submitButton" type="submit" value="Submit" />
			</aui:col>

			<aui:col width="5">
				<aui:button name="resetButton" onclick="${viewURL.toString()}" type="reset" value="Reset" />
			</aui:col>
		</aui:row>
	</aui:fieldset>
</aui:form>