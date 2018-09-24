package org.openhbx.enterprise_vocabulary.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import org.openhbx.enterprise_vocabulary.ValidationError;

/**
 *
 * @author tevans
 */
public class ValidationErrorSerializer extends StdSerializer<ValidationError> {

  public ValidationErrorSerializer() {
    this(null);
  }

  public ValidationErrorSerializer(Class<ValidationError> t) {
    super(t);
  }

  @Override
  public void serialize(ValidationError t, JsonGenerator jg, SerializerProvider sp) throws IOException {
    jg.writeStartObject();
    jg.writeStringField("full_error_message", t.getFullErrorMessage());
    jg.writeStringField("error_message", t.getMessage());
    jg.writeNumberField("line_number", t.getLineNumber());
    jg.writeNumberField("column_number", t.getColumnNumber());
    jg.writeEndObject();
  }
}
