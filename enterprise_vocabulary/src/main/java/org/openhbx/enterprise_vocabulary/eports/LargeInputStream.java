package org.openhbx.enterprise_vocabulary.eports;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author tevans
 */
public class LargeInputStream extends InputStream {
  private long totalSize;
  private long remaining;
  private InputStream source;
  
  public LargeInputStream(long size, InputStream sourceStream) {
   super(); 
   source = sourceStream;
   totalSize = size;
   remaining = size;
  }

  @Override
  public int read() throws IOException {
    if (remaining <= 0) {
      return -1;
    }
    remaining = remaining - 1;
    return source.read();
  }
}
