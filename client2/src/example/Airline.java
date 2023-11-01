package example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Airline {
    public static void main(String[] argv) {
        example.DomesticAirline service = new DomesticAirline();

        // Invoke business method
        GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult res = service.getDomesticAirlineSoap().getDomesticAirlinesTime("", "", "2023-11-02", "");
        GetDomesticCityResponse.GetDomesticCityResult res2 = service.getDomesticAirlineSoap().getDomesticCity();

        try {
            // Create a JAXB context for the classes
            JAXBContext context = JAXBContext.newInstance(GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult.class, GetDomesticCityResponse.GetDomesticCityResult.class);

            // Create a Marshaller
            Marshaller marshaller = context.createMarshaller();

            // Convert res to XML and save it to a file
            File resFile = new File("./res.xml");
            marshaller.marshal(res, resFile);

            // Convert res2 to XML and save it to a file
            File res2File = new File("./res2.xml");
            marshaller.marshal(res2, res2File);

            System.out.println("XML files created successfully: res.xml, res2.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
