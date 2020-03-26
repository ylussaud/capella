/*******************************************************************************
 * Copyright (c) 2018, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.common.flexibility.wizards.ui.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Label;
import org.osgi.framework.FrameworkUtil;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.common.ui.ImageExt2;

public class StatusLabelHelper {

  /**
   * This method allows to set an image to the given SWT label according to the status
   */
  public static void updateImage(IStatus status, Label label) {
    if (!label.isDisposed() && status != null) {
      if (status.isOK()) {
        label.setImage(ImageExt2.getImage(FrameworkUtil.getBundle(StatusLabelHelper.class).getSymbolicName(), "full/etool16/empty.gif"));

      } else if (status.matches(IStatus.INFO)) {
        label.setImage(ImageExt2.getImage(FrameworkUtil.getBundle(StatusLabelHelper.class).getSymbolicName(), "full/etool16/info_tsk.gif"));

      } else if (status.matches(IStatus.WARNING)) {
        label.setImage(ImageExt2.getImage(FrameworkUtil.getBundle(StatusLabelHelper.class).getSymbolicName(), "full/etool16/warn_tsk.gif"));

      } else if (status.matches(IStatus.ERROR)) {
        label.setImage(ImageExt2.getImage(FrameworkUtil.getBundle(StatusLabelHelper.class).getSymbolicName(), "full/etool16/error_tsk.gif"));
      }
    }
  }

  /**
   * This method allows to set the tooltip to the given SWT label according to the status
   * @param okMessage : if the status is OK, set or not the message of the status
   */
  public static void updateTooltip(IStatus status, Label label, boolean okMessage) {
    if (!label.isDisposed() && status != null) {
      String message = status.getMessage();
      if (status.isOK() && !okMessage) {
        message = ICommonConstants.EMPTY_STRING;
      }
      label.setToolTipText(message);
    }
  }
}
