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
package org.polarsys.capella.test.semantic.queries.ju.testcases;

import org.polarsys.capella.test.semantic.queries.ju.model.SemanticQueries;

public class GeneralizedComponents extends SemanticQueries {
  String QUERY = "org.polarsys.capella.core.semantic.queries.GeneralizableElementAllSuperGC";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {

    testQuery(LA__LOGICAL_ACTORS__LA_3, LA__LOGICAL_ACTORS__LA_4, LA__LOGICAL_ACTORS__LA_5);

    testQuery(LA__LOGICAL_ACTORS__LA_4, LA__LOGICAL_ACTORS__LA_5);

    testQuery(LA__LOGICAL_ACTORS__LA_5);
  }

}
