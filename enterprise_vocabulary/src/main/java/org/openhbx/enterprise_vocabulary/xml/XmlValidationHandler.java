package org.openhbx.enterprise_vocabulary.xml;

import java.util.ArrayList;
import java.util.List;
import org.openhbx.enterprise_vocabulary.ValidationError;
import org.openhbx.enterprise_vocabulary.ValidationResult;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author tevans
 */
public class XmlValidationHandler extends DefaultHandler implements ValidationResult  {
  private List<ValidationError> errors = new ArrayList<ValidationError>();
  private Boolean validity = true;

  @Override
  public List<ValidationError> getErrors() {
    return errors;
  }

  @Override
  public Boolean isValid() {
    return validity;
  }

  @Override
  public void error(SAXParseException e) throws SAXException {
    validity = false;
    errors.add(new XmlValidationError(e));
  }
}
