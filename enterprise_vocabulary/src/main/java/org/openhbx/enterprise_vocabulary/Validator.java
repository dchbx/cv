package org.openhbx.enterprise_vocabulary;

import java.io.InputStream;

/**
 *
 * @author tevans
 */
public interface Validator {
  public ValidationResult validateXML(InputStream inXML);
  public ValidationResult validateXML(byte[] inXML);
}
