package org.openhbx.schema_consistency;

import org.openhbx.schema_consistency.test_utilities.xml.ErrorHandler;
import java.io.InputStream;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.openhbx.schema_consistency.test_utilities.xml.Resolver;

/**
 *
 * @author tevans
 */
public class SchemaChecker {

  public ErrorHandler validateSchema(String schema) throws Exception {
    String lookupLocation = "org/openhbx/enterprise_vocabulary/xsds/" + schema;
    InputStream fileStream = this.getClass().
            getClassLoader().
            getResourceAsStream(lookupLocation);
    ErrorHandler er = new ErrorHandler();
    SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    sf.setResourceResolver(new Resolver());
    sf.setErrorHandler(er);
    sf.newSchema(new StreamSource(fileStream));
    if (!er.getErrorStrings().isEmpty()) {
      System.err.println("=============================================");
      System.err.println("Validation of " + schema + " failed:");
      for (Exception e : er.getErrors()) {
        System.err.println(e.getMessage());
      }
    }
    return er;
  }
}
