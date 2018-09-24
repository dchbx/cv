package org.openhbx.enterprise_vocabulary.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;
import org.junit.Assert;
import org.openhbx.enterprise_vocabulary.ValidationResult;

/**
 *
 * @author tevans
 */
public class XmlValidatorTest {
  
  @Test
  public void emptyXmlFailsValidationTest() {
    byte[] xml = {};
    XmlValidator validator = new XmlValidator();
    ValidationResult vresult = validator.validateXML(xml);
    Assert.assertFalse(vresult.isValid());
    Assert.assertEquals(vresult.getErrors().get(0).getFullErrorMessage(), "1, 0: Premature end of file.");
  }
  
  private static String INCOMPLETE_XML_EXAMPLE = "<policy xmlns=\"http://openhbx.org/api/terms/1.0\"></policy>";
  
  @Test
  public void incompleteXMLValidationTest() {
    InputStream xml = new ByteArrayInputStream(INCOMPLETE_XML_EXAMPLE.getBytes());
    XmlValidator validator = new XmlValidator();
    ValidationResult vresult = validator.validateXML(xml);
    Assert.assertFalse(vresult.isValid()); 
    Assert.assertEquals(vresult.getErrors().get(0).getFullErrorMessage(), "1, 59: cvc-complex-type.2.4.b: The content of element 'policy' is not complete. One of '{\"http://openhbx.org/api/terms/1.0\":id}' is expected.");
  }
  
  private static String INCOMPLETE_XML_EXAMPLE_WITH_SCHEMA = "<policy xmlns=\"http://openhbx.org/api/terms/1.0\"" +
          " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" +
          " xsi:schemaLocation=\"http://openhbx.org/api/terms/1.0 policy.xsd\"" +
          "></policy>";
  
  @Test
  public void incompleteXMLWithSchemaReferenceValidationTest() {
    InputStream xml = new ByteArrayInputStream(INCOMPLETE_XML_EXAMPLE_WITH_SCHEMA.getBytes());
    XmlValidator validator = new XmlValidator();
    ValidationResult vresult = validator.validateXML(xml);
    Assert.assertFalse(vresult.isValid());
    Assert.assertEquals(vresult.getErrors().get(0).getFullErrorMessage(), "1, 178: cvc-complex-type.2.4.b: The content of element 'policy' is not complete. One of '{\"http://openhbx.org/api/terms/1.0\":id}' is expected.");
  }
  
  @Test
  public void incompleteXMLJsonResultTest() throws JsonProcessingException {
    InputStream xml = new ByteArrayInputStream(INCOMPLETE_XML_EXAMPLE.getBytes());
    XmlValidator validator = new XmlValidator();
    ValidationResult vresult = validator.validateXML(xml);
    ObjectMapper om = new ObjectMapper();
    Assert.assertFalse(vresult.isValid());
    Assert.assertEquals("{\"result\":\"error\",\"errors\":[{\"full_error_message\":\"1, 59: cvc-complex-type.2.4.b: The content of element 'policy' is not complete. One of '{\\\"http://openhbx.org/api/terms/1.0\\\":id}' is expected.\",\"error_message\":\"cvc-complex-type.2.4.b: The content of element 'policy' is not complete. One of '{\\\"http://openhbx.org/api/terms/1.0\\\":id}' is expected.\",\"line_number\":1,\"column_number\":59}]}", om.writeValueAsString(vresult));
  }
}