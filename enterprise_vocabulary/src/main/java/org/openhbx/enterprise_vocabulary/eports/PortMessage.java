package org.openhbx.enterprise_vocabulary.eports;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author tevans
 */
public class PortMessage {
  public static LargeInputStream read(InputStream is) throws IOException {
    byte[] len_buffer = { 0,0,0,0,0,0,0,0 };
    ByteBuffer sizeBuffer = ByteBuffer.allocate(8);
    sizeBuffer.order(ByteOrder.BIG_ENDIAN);
    if (is.read(len_buffer, 4, 4) == 4) {
      sizeBuffer.put(len_buffer);
      long byteCount = sizeBuffer.getLong();
      return new LargeInputStream(byteCount, is);
    }
    return null;
  }
}
