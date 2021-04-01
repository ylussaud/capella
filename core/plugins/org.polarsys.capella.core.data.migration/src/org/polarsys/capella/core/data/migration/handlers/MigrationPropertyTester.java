/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.core.data.migration.handlers;

import java.util.Arrays;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;

/**
 * 
 */
public class MigrationPropertyTester extends PropertyTester {

  @Override
  public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
    // check if is project, aird or model migration
    return (receiver instanceof IProject && new ProjectMigrationHandler().isValidSelection(Arrays.asList(receiver))) ||
        new AirdMigrationHandler().isValidSelection(Arrays.asList(receiver)) ||
        new ModelMigrationHandler().isValidSelection(Arrays.asList(receiver));
  }
}