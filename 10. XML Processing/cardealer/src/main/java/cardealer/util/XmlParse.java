package cardealer.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParse {

    <O> O parseXml(Class<O> objectClass, String path) throws JAXBException, FileNotFoundException;

}
