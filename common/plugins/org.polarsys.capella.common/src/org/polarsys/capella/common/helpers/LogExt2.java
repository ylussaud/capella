package org.polarsys.capella.common.helpers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.statushandlers.StatusManager;

public class LogExt2 {
  
  public static void log(IStatus status) {
    StatusManager.getManager().handle(status);
  }
  
}
