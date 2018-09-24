package org.openhbx.enterprise_vocabulary;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.openhbx.enterprise_vocabulary.json.ValidationErrorSerializer;

/**
 *
 * @author tevans
 */
@JsonSerialize(using = ValidationErrorSerializer.class)
public interface ValidationError {
  public Integer getLineNumber();
  public Integer getColumnNumber();
  public String getMessage();
  public String getFullErrorMessage();
}
