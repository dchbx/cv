package org.openhbx.enterprise_vocabulary.xml;

import java.io.IOError;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author tevans
 */
public class SchemaLoader {
  private static SchemaLoader theInstance;
  private Schema theSchema;
  
  static {
    try {
      theInstance = new SchemaLoader();
    } catch (SAXException ex) {
      throw new IOError(ex);
    }
  }
  
  public SchemaLoader() throws SAXException {
    URL orgXsd = getClass().getClassLoader().getResource("org/openhbx/enterprise_vocabulary/xsds/vocabulary.xsd");    
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    theSchema = factory.newSchema(orgXsd);
  }
  
  public Schema getSchema() {
    return theSchema;
  }
  
  public static SchemaLoader getInstance() {
    return theInstance;
  }
}
