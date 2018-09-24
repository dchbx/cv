package org.openhbx.enterprise_vocabulary.xml;

import java.io.IOException;
import org.openhbx.enterprise_vocabulary.ValidationError;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author tevans
 */
public class XmlValidationError implements ValidationError {
  private Integer line;
  private Integer column;
  private String message;
  
  public XmlValidationError(SAXParseException e) {
    this(e.getLineNumber(), e.getColumnNumber(), e.getMessage());
  }
  
  public XmlValidationError(IOException e) {
    this(1, 0, e.getMessage());
  }
  
  public XmlValidationError(SAXException e) {
    this(1, 0, e.getMessage());
  }
  
  public XmlValidationError(Integer lineNo, Integer colNo, String msg) {
    line = lineNo;
    column = colNo;
    message = msg;
  }
  
  @Override
  public Integer getLineNumber() {
    return line;
  }

  @Override
  public Integer getColumnNumber() {
    return column;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public String getFullErrorMessage() {
    return String.format("%d, %d: %s", getLineNumber(), getColumnNumber(),getMessage());
  }
}
