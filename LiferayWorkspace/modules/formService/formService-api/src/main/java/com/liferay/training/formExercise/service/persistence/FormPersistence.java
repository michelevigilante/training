/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.formExercise.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.formExercise.exception.NoSuchFormException;
import com.liferay.training.formExercise.model.Form;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormUtil
 * @generated
 */
@ProviderType
public interface FormPersistence extends BasePersistence<Form> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormUtil} to access the form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the form in the entity cache if it is enabled.
	 *
	 * @param form the form
	 */
	public void cacheResult(Form form);

	/**
	 * Caches the forms in the entity cache if it is enabled.
	 *
	 * @param forms the forms
	 */
	public void cacheResult(java.util.List<Form> forms);

	/**
	 * Creates a new form with the primary key. Does not add the form to the database.
	 *
	 * @param formId the primary key for the new form
	 * @return the new form
	 */
	public Form create(long formId);

	/**
	 * Removes the form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the form
	 * @return the form that was removed
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public Form remove(long formId) throws NoSuchFormException;

	public Form updateImpl(Form form);

	/**
	 * Returns the form with the primary key or throws a <code>NoSuchFormException</code> if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form
	 * @throws NoSuchFormException if a form with the primary key could not be found
	 */
	public Form findByPrimaryKey(long formId) throws NoSuchFormException;

	/**
	 * Returns the form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form, or <code>null</code> if a form with the primary key could not be found
	 */
	public Form fetchByPrimaryKey(long formId);

	/**
	 * Returns all the forms.
	 *
	 * @return the forms
	 */
	public java.util.List<Form> findAll();

	/**
	 * Returns a range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @return the range of forms
	 */
	public java.util.List<Form> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of forms
	 */
	public java.util.List<Form> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator);

	/**
	 * Returns an ordered range of all the forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of forms
	 * @param end the upper bound of the range of forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of forms
	 */
	public java.util.List<Form> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the forms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of forms.
	 *
	 * @return the number of forms
	 */
	public int countAll();

}