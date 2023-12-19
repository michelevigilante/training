/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.training.formExercise.model.Form;
import com.liferay.training.formExercise.model.FormModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Form service. Represents a row in the &quot;MY_Form&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FormModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormImpl
 * @generated
 */
@JSON(strict = true)
public class FormModelImpl extends BaseModelImpl<Form> implements FormModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form model instance should use the <code>Form</code> interface instead.
	 */
	public static final String TABLE_NAME = "MY_Form";

	public static final Object[][] TABLE_COLUMNS = {
		{"groupId", Types.BIGINT}, {"formId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"address", Types.VARCHAR},
		{"city", Types.VARCHAR}, {"comment_", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"province", Types.VARCHAR}, {"state_", Types.VARCHAR},
		{"sum", Types.INTEGER}, {"surname", Types.VARCHAR},
		{"val1", Types.INTEGER}, {"val2", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("formId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comment_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("province", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sum", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("surname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("val1", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("val2", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table MY_Form (groupId LONG,formId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,address VARCHAR(75) null,city VARCHAR(75) null,comment_ VARCHAR(75) null,email VARCHAR(75) null,name VARCHAR(75) null,province VARCHAR(75) null,state_ VARCHAR(75) null,sum INTEGER,surname VARCHAR(75) null,val1 INTEGER,val2 INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table MY_Form";

	public static final String ORDER_BY_JPQL = " ORDER BY form.formId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY MY_Form.formId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FORMID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public FormModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _formId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Form.class;
	}

	@Override
	public String getModelClassName() {
		return Form.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Form, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Form, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Form, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Form)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Form, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Form, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Form)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Form, Object>> getAttributeGetterFunctions() {
		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Form, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Form, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Form, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Form, Object>>();

			attributeGetterFunctions.put("groupId", Form::getGroupId);
			attributeGetterFunctions.put("formId", Form::getFormId);
			attributeGetterFunctions.put("companyId", Form::getCompanyId);
			attributeGetterFunctions.put("userId", Form::getUserId);
			attributeGetterFunctions.put("userName", Form::getUserName);
			attributeGetterFunctions.put("createDate", Form::getCreateDate);
			attributeGetterFunctions.put("modifiedDate", Form::getModifiedDate);
			attributeGetterFunctions.put("address", Form::getAddress);
			attributeGetterFunctions.put("city", Form::getCity);
			attributeGetterFunctions.put("comment", Form::getComment);
			attributeGetterFunctions.put("email", Form::getEmail);
			attributeGetterFunctions.put("name", Form::getName);
			attributeGetterFunctions.put("province", Form::getProvince);
			attributeGetterFunctions.put("state", Form::getState);
			attributeGetterFunctions.put("sum", Form::getSum);
			attributeGetterFunctions.put("surname", Form::getSurname);
			attributeGetterFunctions.put("val1", Form::getVal1);
			attributeGetterFunctions.put("val2", Form::getVal2);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Form, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Form, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Form, ?>>();

			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Form, Long>)Form::setGroupId);
			attributeSetterBiConsumers.put(
				"formId", (BiConsumer<Form, Long>)Form::setFormId);
			attributeSetterBiConsumers.put(
				"companyId", (BiConsumer<Form, Long>)Form::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Form, Long>)Form::setUserId);
			attributeSetterBiConsumers.put(
				"userName", (BiConsumer<Form, String>)Form::setUserName);
			attributeSetterBiConsumers.put(
				"createDate", (BiConsumer<Form, Date>)Form::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate", (BiConsumer<Form, Date>)Form::setModifiedDate);
			attributeSetterBiConsumers.put(
				"address", (BiConsumer<Form, String>)Form::setAddress);
			attributeSetterBiConsumers.put(
				"city", (BiConsumer<Form, String>)Form::setCity);
			attributeSetterBiConsumers.put(
				"comment", (BiConsumer<Form, String>)Form::setComment);
			attributeSetterBiConsumers.put(
				"email", (BiConsumer<Form, String>)Form::setEmail);
			attributeSetterBiConsumers.put(
				"name", (BiConsumer<Form, String>)Form::setName);
			attributeSetterBiConsumers.put(
				"province", (BiConsumer<Form, String>)Form::setProvince);
			attributeSetterBiConsumers.put(
				"state", (BiConsumer<Form, String>)Form::setState);
			attributeSetterBiConsumers.put(
				"sum", (BiConsumer<Form, Integer>)Form::setSum);
			attributeSetterBiConsumers.put(
				"surname", (BiConsumer<Form, String>)Form::setSurname);
			attributeSetterBiConsumers.put(
				"val1", (BiConsumer<Form, Integer>)Form::setVal1);
			attributeSetterBiConsumers.put(
				"val2", (BiConsumer<Form, Integer>)Form::setVal2);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_formId = formId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address = address;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return "";
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_city = city;
	}

	@JSON
	@Override
	public String getComment() {
		if (_comment == null) {
			return "";
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_comment = comment;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public String getProvince() {
		if (_province == null) {
			return "";
		}
		else {
			return _province;
		}
	}

	@Override
	public void setProvince(String province) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_province = province;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_state = state;
	}

	@JSON
	@Override
	public int getSum() {
		return _sum;
	}

	@Override
	public void setSum(int sum) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sum = sum;
	}

	@JSON
	@Override
	public String getSurname() {
		if (_surname == null) {
			return "";
		}
		else {
			return _surname;
		}
	}

	@Override
	public void setSurname(String surname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_surname = surname;
	}

	@JSON
	@Override
	public int getVal1() {
		return _val1;
	}

	@Override
	public void setVal1(int val1) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_val1 = val1;
	}

	@JSON
	@Override
	public int getVal2() {
		return _val2;
	}

	@Override
	public void setVal2(int val2) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_val2 = val2;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Form.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Form toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Form>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FormImpl formImpl = new FormImpl();

		formImpl.setGroupId(getGroupId());
		formImpl.setFormId(getFormId());
		formImpl.setCompanyId(getCompanyId());
		formImpl.setUserId(getUserId());
		formImpl.setUserName(getUserName());
		formImpl.setCreateDate(getCreateDate());
		formImpl.setModifiedDate(getModifiedDate());
		formImpl.setAddress(getAddress());
		formImpl.setCity(getCity());
		formImpl.setComment(getComment());
		formImpl.setEmail(getEmail());
		formImpl.setName(getName());
		formImpl.setProvince(getProvince());
		formImpl.setState(getState());
		formImpl.setSum(getSum());
		formImpl.setSurname(getSurname());
		formImpl.setVal1(getVal1());
		formImpl.setVal2(getVal2());

		formImpl.resetOriginalValues();

		return formImpl;
	}

	@Override
	public Form cloneWithOriginalValues() {
		FormImpl formImpl = new FormImpl();

		formImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		formImpl.setFormId(this.<Long>getColumnOriginalValue("formId"));
		formImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		formImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		formImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		formImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		formImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		formImpl.setAddress(this.<String>getColumnOriginalValue("address"));
		formImpl.setCity(this.<String>getColumnOriginalValue("city"));
		formImpl.setComment(this.<String>getColumnOriginalValue("comment_"));
		formImpl.setEmail(this.<String>getColumnOriginalValue("email"));
		formImpl.setName(this.<String>getColumnOriginalValue("name"));
		formImpl.setProvince(this.<String>getColumnOriginalValue("province"));
		formImpl.setState(this.<String>getColumnOriginalValue("state_"));
		formImpl.setSum(this.<Integer>getColumnOriginalValue("sum"));
		formImpl.setSurname(this.<String>getColumnOriginalValue("surname"));
		formImpl.setVal1(this.<Integer>getColumnOriginalValue("val1"));
		formImpl.setVal2(this.<Integer>getColumnOriginalValue("val2"));

		return formImpl;
	}

	@Override
	public int compareTo(Form form) {
		long primaryKey = form.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Form)) {
			return false;
		}

		Form form = (Form)object;

		long primaryKey = form.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Form> toCacheModel() {
		FormCacheModel formCacheModel = new FormCacheModel();

		formCacheModel.groupId = getGroupId();

		formCacheModel.formId = getFormId();

		formCacheModel.companyId = getCompanyId();

		formCacheModel.userId = getUserId();

		formCacheModel.userName = getUserName();

		String userName = formCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			formCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			formCacheModel.createDate = createDate.getTime();
		}
		else {
			formCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			formCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			formCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		formCacheModel.address = getAddress();

		String address = formCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			formCacheModel.address = null;
		}

		formCacheModel.city = getCity();

		String city = formCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			formCacheModel.city = null;
		}

		formCacheModel.comment = getComment();

		String comment = formCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			formCacheModel.comment = null;
		}

		formCacheModel.email = getEmail();

		String email = formCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			formCacheModel.email = null;
		}

		formCacheModel.name = getName();

		String name = formCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			formCacheModel.name = null;
		}

		formCacheModel.province = getProvince();

		String province = formCacheModel.province;

		if ((province != null) && (province.length() == 0)) {
			formCacheModel.province = null;
		}

		formCacheModel.state = getState();

		String state = formCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			formCacheModel.state = null;
		}

		formCacheModel.sum = getSum();

		formCacheModel.surname = getSurname();

		String surname = formCacheModel.surname;

		if ((surname != null) && (surname.length() == 0)) {
			formCacheModel.surname = null;
		}

		formCacheModel.val1 = getVal1();

		formCacheModel.val2 = getVal2();

		return formCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Form, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Form, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Form, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Form)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Form>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Form.class, ModelWrapper.class);

	}

	private long _groupId;
	private long _formId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _address;
	private String _city;
	private String _comment;
	private String _email;
	private String _name;
	private String _province;
	private String _state;
	private int _sum;
	private String _surname;
	private int _val1;
	private int _val2;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Form, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Form)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("formId", _formId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("address", _address);
		_columnOriginalValues.put("city", _city);
		_columnOriginalValues.put("comment_", _comment);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("province", _province);
		_columnOriginalValues.put("state_", _state);
		_columnOriginalValues.put("sum", _sum);
		_columnOriginalValues.put("surname", _surname);
		_columnOriginalValues.put("val1", _val1);
		_columnOriginalValues.put("val2", _val2);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("comment_", "comment");
		attributeNames.put("state_", "state");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("groupId", 1L);

		columnBitmasks.put("formId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("address", 128L);

		columnBitmasks.put("city", 256L);

		columnBitmasks.put("comment_", 512L);

		columnBitmasks.put("email", 1024L);

		columnBitmasks.put("name", 2048L);

		columnBitmasks.put("province", 4096L);

		columnBitmasks.put("state_", 8192L);

		columnBitmasks.put("sum", 16384L);

		columnBitmasks.put("surname", 32768L);

		columnBitmasks.put("val1", 65536L);

		columnBitmasks.put("val2", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Form _escapedModel;

}