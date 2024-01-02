/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;MY_Form&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Form
 * @generated
 */
public class FormTable extends BaseTable<FormTable> {

	public static final FormTable INSTANCE = new FormTable();

	public final Column<FormTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormTable, Long> formId = createColumn(
		"formId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FormTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> comment = createColumn(
		"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> province = createColumn(
		"province", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, Integer> sum = createColumn(
		"sum", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FormTable, String> surname = createColumn(
		"surname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormTable, Integer> val1 = createColumn(
		"val1", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FormTable, Integer> val2 = createColumn(
		"val2", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private FormTable() {
		super("MY_Form", FormTable::new);
	}

}