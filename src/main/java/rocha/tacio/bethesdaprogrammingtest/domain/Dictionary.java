package rocha.tacio.bethesdaprogrammingtest.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "DICTIONARY")
public class Dictionary<T extends DictionaryEntry> {

    @JacksonXmlProperty(localName = "DOCUMENTS")
    private List<T> documents;

    public List<T> getDocuments() {
        return documents;
    }

    public void setDocuments(List<T> documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dictionary that = (Dictionary) o;

        return documents != null ? documents.equals(that.documents) : that.documents == null;
    }

    @Override
    public int hashCode() {
        return documents != null ? documents.hashCode() : 0;
    }
}

