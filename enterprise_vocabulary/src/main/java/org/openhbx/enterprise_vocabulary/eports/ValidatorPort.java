package org.openhbx.enterprise_vocabulary.eports;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.openhbx.enterprise_vocabulary.ValidationResult;
import org.openhbx.enterprise_vocabulary.Validator;
import org.openhbx.enterprise_vocabulary.ValidatorFactory;

/**
 *
 * @author tevans
 */
public class ValidatorPort {
  public static void main(String[] args) throws IOException {
    InputStream in = System.in;
    LargeInputStream lis;
    Validator val = ValidatorFactory.getValidator();
    while ((lis = PortMessage.read(in)) != null) {
      ValidationResult vr = val.validateXML(lis);
      sendResponse(vr, System.out);
    }
  }
  
  private static void sendResponse(ValidationResult vr, PrintStream out) throws IOException {
    if (vr.isValid()) {
      encodeResponse("{\"result\": \"ok\"}", out);
    } else {
      ObjectMapper om = new ObjectMapper();
      encodeResponse(om.writeValueAsString(vr), out);
    }
  }
  
  private static void encodeResponse(String response, PrintStream out) throws IOException {
    byte[] responseBytes = response.getBytes();
    int responseLength = responseBytes.length;
    ByteBuffer bb = ByteBuffer.allocate(4);
    bb.order(ByteOrder.BIG_ENDIAN);
    bb.putInt(responseLength);
    out.write(bb.array());
    out.write(responseBytes);
  }
}
