package com.example.bankSystem.parsingFromXML;

import com.example.bankSystem.models.ED807;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class ParsingED807FromXMLTest {

    @Test
    public void parseTest() throws JAXBException {
        ED807 ed807 = ParsingED807FromXML.parse("C:\\Users\\Paul\\Desktop\\Practic\\20220630_ED807_full.xml");
      Assertions.assertFalse(ed807.getBicDirectoryEntries().isEmpty());
    }
}
