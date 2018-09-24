package org.openhbx.schema_consistency.test_utilities.xml;

import java.io.InputStream;
import java.io.Reader;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

/**
 *
 * @author tevans
 */
public class Resolver implements LSResourceResolver {

    @Override
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
      String lookupLocation = "org/openhbx/enterprise_vocabulary/xsds/" + systemId;
      InputStream fileStream = this.getClass().
            getClassLoader().
            getResourceAsStream(lookupLocation);
      return new ResolvedSchemaInput(publicId, systemId, baseURI, fileStream);
    }
  
  public class ResolvedSchemaInput implements LSInput {

    private String systemId;
    private String baseUri;
    private String publicId;
    private InputStream byteStream;
    
    public ResolvedSchemaInput(String pId, String sId, String bUri, InputStream iStream) {
      publicId = pId;
      systemId = sId;
      baseUri = bUri;
      byteStream = iStream;
    }
    
    @Override
    public Reader getCharacterStream() {
      return null;
    }

    @Override
    public void setCharacterStream(Reader characterStream) {
    }

    @Override
    public InputStream getByteStream() {
      return byteStream;
    }

    @Override
    public void setByteStream(InputStream byteStream) {
    }

    @Override
    public String getStringData() {
      return null;
    }

    @Override
    public void setStringData(String stringData) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSystemId() {
      return systemId;
    }

    @Override
    public void setSystemId(String systemId) {
    }

    @Override
    public String getPublicId() {
      return publicId;
    }

    @Override
    public void setPublicId(String publicId) {
    }

    @Override
    public String getBaseURI() {
      return baseUri;
    }

    @Override
    public void setBaseURI(String baseURI) {
    }

    @Override
    public String getEncoding() {
      return null;
    }

    @Override
    public void setEncoding(String encoding) {
    }

    @Override
    public boolean getCertifiedText() {
      return false;
    }

    @Override
    public void setCertifiedText(boolean certifiedText) {
    }
    
  }
}