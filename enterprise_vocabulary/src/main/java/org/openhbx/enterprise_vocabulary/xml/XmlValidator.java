package org.openhbx.enterprise_vocabulary.xml;

import java.io.ByteArrayInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import org.openhbx.enterprise_vocabulary.ValidationResult;
import org.openhbx.enterprise_vocabulary.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author tevans
 */
public class XmlValidator implements Validator {
  private Schema schema;
  private SAXParserFactory parserFactory;
  private XmlValidationHandler handler;
  
  public XmlValidator(SAXParserFactory spf) {
    parserFactory = spf;
    schema = SchemaLoader.getInstance().getSchema();
    parserFactory.setNamespaceAware(true);
    parserFactory.setSchema(schema);
    handler = new XmlValidationHandler();
  }
  
  public XmlValidator() {
    this(SAXParserFactory.newInstance());
  }
  
  @Override
  public ValidationResult validateXML(InputStream inXML) {
    SAXParser parser;
    ValidationResult result;
    try {
      parser = parserFactory.newSAXParser();
    } catch (ParserConfigurationException e) {
      throw new IOError(e);
    } catch (SAXException e) {
      throw new IOError(e);
    }
    try {
      parser.parse(inXML, handler);
      result = handler;
    } catch (SAXException e) {
      result = new XmlParsingFailure(e);
    }catch (IOException e) {
      result = new XmlParsingFailure(e);
    }
    return result;
  }

  @Override
  public ValidationResult validateXML(byte[] inXML) {
    return validateXML(new ByteArrayInputStream(inXML));
  }

}
