package org.openhbx.enterprise_vocabulary;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.openhbx.enterprise_vocabulary.json.ValidationResultSerializer;

/**
 *
 * @author tevans
 */
@JsonSerialize(using = ValidationResultSerializer.class)
public interface ValidationResult {
  public List<ValidationError> getErrors();
  public Boolean isValid();
}