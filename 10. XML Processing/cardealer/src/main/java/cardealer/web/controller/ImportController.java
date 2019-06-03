package cardealer.web.controller;

import cardealer.domain.dtos.PartImportRootDto;
import cardealer.domain.dtos.SupplierImportRootDto;
import cardealer.service.PartService;
import cardealer.service.SupplierService;
import cardealer.util.XmlParse;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Controller
public class ImportController {
    private final static String SUPPLIERS_FILE_PATH = "/Users/kristiyan/IdeaProjects/Databases Frameworks - Hibernate & Spring Data - 2019/10. XML Processing/cardealer/src/main/resources/files/suppliers.xml";
    private final static String PARTS_FILE_PATH = "/Users/kristiyan/IdeaProjects/Databases Frameworks - Hibernate & Spring Data - 2019/10. XML Processing/cardealer/src/main/resources/files/parts.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final XmlParse xmlParse;

    public ImportController(SupplierService supplierService, PartService partService, XmlParse xmlParse) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.xmlParse = xmlParse;
    }

    public String importSuppliers() throws JAXBException, FileNotFoundException {
        SupplierImportRootDto supplierImportRootDto = this.xmlParse
                .parseXml(SupplierImportRootDto.class, SUPPLIERS_FILE_PATH);

        this.supplierService.importSuppliers(supplierImportRootDto);

        return "Imported suppliers";
    }

    public String importParts() throws JAXBException, FileNotFoundException {
        PartImportRootDto partImportRootDto = this.xmlParse
                .parseXml(PartImportRootDto.class, PARTS_FILE_PATH);

        this.partService.importParts(partImportRootDto);

        return "Imported suppliers";
    }
}
