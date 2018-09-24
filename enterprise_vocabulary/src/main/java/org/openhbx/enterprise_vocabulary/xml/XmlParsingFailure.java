package org.openhbx.enterprise_vocabulary.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openhbx.enterprise_vocabulary.ValidationError;
import org.openhbx.enterprise_vocabulary.ValidationResult;
import org.xml.sax.SAXException;

/**
 *
 * @author tevans
 */
public class XmlParsingFailure implements ValidationResult {
  private List<ValidationError> errors = new ArrayList<ValidationError>();

  public XmlParsingFailure(SAXException e) {
    errors.add(new XmlValidationError(e));
  }
  
  public XmlParsingFailure(IOException e) {
    errors.add(new XmlValidationError(e));
  }
  
  @Override
  public List<ValidationError> getErrors() {
    return errors;
  }

  @Override
  public Boolean isValid() {
    return false;
  }
  
}
