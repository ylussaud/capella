/*******************************************************************************
 * Copyright (c) 2019, 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.diagram.filters.ju.oab;

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.core.sirius.analysis.constants.IFilterNameConstants;

public class HideOperationalActivitiesForOAB extends FiltersForOAB {

  @Override
  protected String getFilterName() {
    return IFilterNameConstants.FILTER_OAB_HIDE_OPERATIONAL_ACTIVITIES;
  }

  @Override
  protected List<String> getFilteredObjetIDs() {
    return Arrays.asList(new String[] { OPERATIONAL_ACTIVITY_3_ID, OPERATIONAL_ACTIVITY_4_ID, OPERATIONAL_ACTIVITY_5_ID,
        OPERATIONAL_ACTIVITY_6_ID, OPERATIONAL_ACTIVITY_7_ID });
  }

}
