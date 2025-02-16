/*******************************************************************************
 * Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.common.data.helpers.modellingcore.delegates;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.data.modellingcore.TraceableElement;
import org.polarsys.capella.common.helpers.EObjectExt;

public class TraceableElementHelper {
  private static TraceableElementHelper instance;

  private TraceableElementHelper() {
  }

  public static TraceableElementHelper getInstance() {
    if (instance == null) {
      instance = new TraceableElementHelper();
    }
    return instance;
  }

  public Object doSwitch(TraceableElement element, EStructuralFeature feature) {
    Object ret = null;

    if (feature.equals(ModellingcorePackage.Literals.TRACEABLE_ELEMENT__INCOMING_TRACES)) {
      ret = getIncomingTraces(element);
    } else if (feature.equals(ModellingcorePackage.Literals.TRACEABLE_ELEMENT__OUTGOING_TRACES)) {
      ret = getOutgoingTraces(element);
    }

    // no helper found... searching in super classes...
    if (null == ret) {
      ret = ModelElementHelper.getInstance().doSwitch(element, feature);
    }

    return ret;
  }

  protected List<AbstractTrace> getIncomingTraces(TraceableElement element) {
    return EObjectExt.getReferencers(element, ModellingcorePackage.Literals.ABSTRACT_TRACE__TARGET_ELEMENT);
  }

  protected List<AbstractTrace> getOutgoingTraces(TraceableElement element) {
    return EObjectExt.getReferencers(element, ModellingcorePackage.Literals.ABSTRACT_TRACE__SOURCE_ELEMENT);
  }
}
