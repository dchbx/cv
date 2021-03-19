package org.openhbx.schema_consistency;

import org.openhbx.schema_consistency.SchemaChecker;
import org.openhbx.schema_consistency.test_utilities.xml.ErrorHandler;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author tevans
 */
public class SchemaCheckerTest {
  
  public SchemaCheckerTest() {
  }
  
  @Test
  public void CheckCommonTest() throws Exception {
    checkSchema("common.xsd");
  }
  
  @Test
  public void CheckConfigTest() throws Exception {
    checkSchema("config.xsd");
  }
  
  @Test
  public void CheckDocumentStorageTest() throws Exception {
    checkSchema("document_storage.xsd");
  }
  
  @Test
  public void CheckIndividualTest() throws Exception {
    checkSchema("individual.xsd");
  }
  
  @Test
  public void CheckOrganizationTest() throws Exception {
    checkSchema("organization.xsd");
  }
  
  @Test
  public void CheckPlanTest() throws Exception {
    checkSchema("plan.xsd");
  }
  
  @Test
  public void CheckPolicyTest() throws Exception {
    checkSchema("policy.xsd");
  }

  @Test
  public void CheckVerificationServicesSchemaTest() throws Exception {
    checkSchema("verification_services.xsd");
  }

  @Test
  public void CheckTradingPartnerServicesTest() throws Exception {
    checkSchema("trading_partner_services.xsd");
  }

  @Test
  public void CheckVocabularyTest() throws Exception {
    checkSchema("vocabulary.xsd");
  }

  @Test
  public void CheckFinancialAssistanceTest() throws Exception {
    checkSchema("financial_assistance.xsd");
  }
/*  
  @Test
  public void CheckPremiumPaymentTest() throws Exception {
    checkSchema("premium_payment.xsd");
  }
  
  @Test
  public void CheckPremiumStatementTest() throws Exception {
    checkSchema("premium_statement.xsd");
  }
  @Test
  public void CheckProcessTest() throws Exception {
    checkSchema("process.xsd");
  }
*/
  
  private void checkSchema(String schemaName) throws Exception {
    SchemaChecker sc = new SchemaChecker();
    ErrorHandler er = sc.validateSchema(schemaName);
    Assert.assertTrue(er.getErrors().isEmpty());
  }
}
