package rocha.tacio.bethesdaprogrammingtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rocha.tacio.bethesdaprogrammingtest.domain.Dictionary;
import rocha.tacio.bethesdaprogrammingtest.domain.ClientDictionaryEntry;
import rocha.tacio.bethesdaprogrammingtest.domain.Document;
import rocha.tacio.bethesdaprogrammingtest.domain.ServerDictionaryEntry;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BethesdaProgrammingTestApplicationTests {

    private static ObjectMapper xmlMapper = new XmlMapper();

    private static String inputFile;

    @BeforeClass
    public static void init() {
        inputFile = BethesdaProgrammingTestApplicationTests.class.getClassLoader().getResource("client/files/f001.xml").getFile();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void mapsXmlToDocument() throws IOException {
        Document document = xmlMapper.readValue(new File(inputFile), Document.class);
        Assertions.assertThat(document.getDocumentName()).isEqualTo("Document 001");

        String clientDicPath = BethesdaProgrammingTestApplicationTests.class.getClassLoader().getResource("client/dictionary/client.xml").getFile();
        Dictionary<ClientDictionaryEntry> clientDictionary = xmlMapper.readValue(new File(clientDicPath), Dictionary.class);
        Assertions.assertThat(clientDictionary.getDocuments()).isNotEmpty();

        String serverDicPath = BethesdaProgrammingTestApplicationTests.class.getClassLoader().getResource("fserver/mirax/dictionary/server.xml").getFile();
        Dictionary<ServerDictionaryEntry> serverDictionary = xmlMapper.readValue(new File(serverDicPath), Dictionary.class);
        Assertions.assertThat(serverDictionary.getDocuments()).isNotEmpty();
    }

}
