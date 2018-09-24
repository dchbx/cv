package org.openhbx.enterprise_vocabulary.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import org.openhbx.enterprise_vocabulary.ValidationError;
import org.openhbx.enterprise_vocabulary.ValidationResult;

/**
 *
 * @author tevans
 */
public class ValidationResultSerializer extends StdSerializer<ValidationResult>{

    public ValidationResultSerializer() {
        this(null);
    }
   
    public ValidationResultSerializer(Class<ValidationResult> t) {
        super(t);
    }
  
  @Override
  public void serialize(ValidationResult t, JsonGenerator jg, SerializerProvider sp) throws IOException {
    jg.writeStartObject();
    jg.writeStringField("result", "error");
    jg.writeArrayFieldStart("errors");
    for (ValidationError ve : t.getErrors()) {
      jg.writeObject(ve);
    }
    jg.writeEndArray();
    jg.writeEndObject();
  }
  
}
