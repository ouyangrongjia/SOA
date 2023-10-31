package example;

public class Airline
{
    public static void main(String[] argv)
    {
        example.DomesticAirline service = new DomesticAirline();
        //invoke business method
        GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult res = service.getDomesticAirlineSoap().getDomesticAirlinesTime("", "", "2007-07-02", "");
        GetDomesticCityResponse.GetDomesticCityResult res2 = service.getDomesticAirlineSoap().getDomesticCity();
        System.out.println(res.getAny());
        System.out.println(res2.getAny());
    }
}
