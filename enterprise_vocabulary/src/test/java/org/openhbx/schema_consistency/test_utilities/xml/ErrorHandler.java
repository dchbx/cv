package org.openhbx.schema_consistency.test_utilities.xml;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author tevans
 */
public class ErrorHandler implements org.xml.sax.ErrorHandler {
    private List<SAXParseException> errors;
    
    public List<String> getErrorStrings() {
      List<String> errs = new ArrayList<String>();
      for (SAXParseException spe : errors) {
        errs.add(spe.getLocalizedMessage());
      }
      return errs;
    }
    
    public ErrorHandler() {
      errors = new ArrayList<SAXParseException>();
    }
    
    public List<SAXParseException> getErrors() {
      return errors;
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
      errors.add(exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
      errors.add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
      errors.add(exception);
    }
    
  }
