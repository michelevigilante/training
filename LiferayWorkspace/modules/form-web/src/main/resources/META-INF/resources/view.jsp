<%--
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/formSubmitURL" var="formSubmitURL" />

<portlet:resourceURL id="/getAvg" var="calcAvgURL" />

<portlet:renderURL var="readForm">
	<portlet:param name="mvcPath" value="/read.jsp" />
	<portlet:param name="mvcRenderCommandName" value="/form/view" />
	<portlet:param name="delta" value="4" />
	<portlet:param name="deltaConfigurable" value="true" />
</portlet:renderURL>

<aui:form method="post" name="formTraining" onSubmit='<%= "event.preventDefault(); " + liferayPortletResponse.getNamespace() + "sendPost();" %>'>
	<aui:fieldset label="Personal Information">
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

		<div>Sum is: <p id='<%= liferayPortletResponse.getNamespace() + "sum" %>' /></div>
		<div>Avg of all sum is: <p id='<%= liferayPortletResponse.getNamespace() + "avg" %>' /></div>

		<aui:row>
			<aui:col width="5">
				<aui:button name="submitButton" type="submit" value="Submit" />
			</aui:col>

			<aui:col width="5">
				<aui:button name="resetButton" onclick="${viewURL.toString()}" type="reset" value="Reset" />
			</aui:col>

			<aui:col width="10">
				<aui:button name="calcAvg" onclick='<%= liferayPortletResponse.getNamespace() + "getAvg();" %>' value="Avg" />
			</aui:col>

			<aui:col width="10">
				<aui:a href="${readForm}">Read database</aui:a>
			</aui:col>
		</aui:row>
	</aui:fieldset>
</aui:form>

<aui:script>
function <portlet:namespace />sendPost() {
	var form = document.getElementById("<portlet:namespace />formTraining");

	var formData = new FormData(form);

	Liferay.Util.fetch('<%= formSubmitURL.toString() %>', {
		body: formData,
		method: 'POST'
	}).then(function(response) {
	   return response.json();
	}).then(function(response) {
		$('#<portlet:namespace />sum').text(response.sum);
	});
	return;
}

function <portlet:namespace />getAvg() {
	Liferay.Util.fetch('<%= calcAvgURL.toString() %>', {
			method: 'GET'
		}).then(function(response) {
			 return response.json();
		}).then(function(response) {
			$('#<portlet:namespace />avg').text(response.avg);
		});
	return;
}
</aui:script>