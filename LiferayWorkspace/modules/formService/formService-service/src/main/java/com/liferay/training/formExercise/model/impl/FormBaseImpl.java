/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.model.impl;

import com.liferay.training.formExercise.model.Form;
import com.liferay.training.formExercise.service.FormLocalServiceUtil;

/**
 * The extended model base implementation for the Form service. Represents a row in the &quot;MY_Form&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormImpl
 * @see Form
 * @generated
 */
public abstract class FormBaseImpl extends FormModelImpl implements Form {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form model instance should use the <code>Form</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			FormLocalServiceUtil.addForm(this);
		}
		else {
			FormLocalServiceUtil.updateForm(this);
		}
	}

}