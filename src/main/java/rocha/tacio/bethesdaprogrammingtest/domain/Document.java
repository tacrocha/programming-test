package rocha.tacio.bethesdaprogrammingtest.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "DOCUMENT")
public class Document implements Serializable {

    private static final long serialVersionUID = -1604212771391846434L;

    @JacksonXmlProperty(localName = "DOCUMENT_NAME")
    private String documentName;

    @JacksonXmlProperty(localName = "VERSION")
    private String version;

    @JacksonXmlProperty(localName = "DATA")
    private String data;

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (documentName != null ? !documentName.equals(document.documentName) : document.documentName != null)
            return false;
        if (version != null ? !version.equals(document.version) : document.version != null) return false;
        return data != null ? data.equals(document.data) : document.data == null;
    }

    @Override
    public int hashCode() {
        int result = documentName != null ? documentName.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
