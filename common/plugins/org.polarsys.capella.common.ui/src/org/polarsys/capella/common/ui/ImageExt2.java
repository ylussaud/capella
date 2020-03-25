package org.polarsys.capella.common.ui;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.util.BundleUtility;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

public class ImageExt2 {

  static ImageRegistry registry;
  
  private static ImageRegistry getImageRegistry() {
    if (registry == null) {
      registry = createImageRegistry();
    }
    return registry;
  }

  protected static ImageRegistry createImageRegistry() {

    // If we are in the UI Thread use that
    if (Display.getCurrent() != null) {
      return new ImageRegistry(Display.getCurrent());
    }

    if (PlatformUI.isWorkbenchRunning()) {
      return new ImageRegistry(PlatformUI.getWorkbench().getDisplay());
    }

    // Invalid thread access if it is not the UI Thread
    // and the workbench is not created.
    throw new SWTError(SWT.ERROR_THREAD_INVALID_ACCESS);
  }
  
  private static final String ICONS_PATH = "icons/"; //$NON-NLS-1$

  /**
   * Get an image descriptor for given key.<br>
   * Images must be located in 'plug-in folder'/icons
   * @param key the key must be the file name of the related image.
   * @return an {@link ImageDescriptor} or null if not found
   */
  public static ImageDescriptor getImageDescriptor(String pluginId, String key) {
    ImageRegistry imageRegistry = getImageRegistry();
    ImageDescriptor imageDescriptor = imageRegistry.getDescriptor(key);

    if (null == imageDescriptor) {
      imageDescriptor = createImageDescriptor(pluginId, key);
      imageRegistry.put(key, imageDescriptor);
    }
    return imageDescriptor;
  }

  /**
   * Get an image for given key.<br>
   * Images must be located in 'plug-in folder'/icons
   * @param key the key must be the file name of the related image.
   * @return an {@link Image} or null if not found
   */
  public static Image getImage(String pluginId, String key) {
    ImageRegistry imageRegistry = getImageRegistry();

    Image image = imageRegistry.get(key);
    if (null == image) {
      // Create an image descriptor for given id.
      ImageDescriptor imageDescriptor = createImageDescriptor(pluginId, key);
      // Store the (id, imageDescriptor) rather than (id,image)
      // because with storing (id,image) the getDescriptor method will return null in later usage
      // this way, everything is correctly initialized.
      imageRegistry.put(key, imageDescriptor);

      // Everything is all right at this step, let's get the real image
      image = imageRegistry.get(key);
    }
    return image;
  }

  /**
   * Create an image descriptor for given key.<br>
   * Images must be located in 'plug-in folder'/icons
   * @param key the key must be the file name of the related image.
   * @return an {@link ImageDescriptor} or null if error occurred
   */
  protected static ImageDescriptor createImageDescriptor(String pluginId, String key) {
    ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, ICONS_PATH + key);
    return imageDescriptor;
  }

  /**
   * Get icon url for specified image key.<br>
   * Images must be located in 'plug-in folder'/icons
   * @param key the key must be the file name of the related image.
   * @return null if image file not found.
   */
  public URL getImageURL(String pluginId, String key) {
    Bundle bundle = Platform.getBundle(pluginId);
    if (!BundleUtility.isReady(bundle)) {
      return null;
    }
    return BundleUtility.find(bundle, ICONS_PATH + key);
  }
}
