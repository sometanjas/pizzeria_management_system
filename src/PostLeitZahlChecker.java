package src;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PostLeitZahlChecker {

    private List<String> berlinPLZ;

    public boolean testPLZ(String input) {
        return istBerlin(input);
    }

    private boolean istBerlin(String input) {
        for (String element : berlinPLZ) {
            if (element.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public PostLeitZahlChecker() {
        this.berlinPLZ = Arrays.asList(
                "10115",
                "10117",
                "10119",
                "10178",
                "10179",
                "10243",
                "10245",
                "10247",
                "10249",
                "10315",
                "10317",
                "10318",
                "10319",
                "10365",
                "10367",
                "10369",
                "10405",
                "10407",
                "10409",
                "10435",
                "10437",
                "10439",
                "10551",
                "10553",
                "10555",
                "10557",
                "10559",
                "10585",
                "10587",
                "10589",
                "10623",
                "10625",
                "10627",
                "10629",
                "10707",
                "10709",
                "10711",
                "10713",
                "10715",
                "10717",
                "10719",
                "10777",
                "10779",
                "10781",
                "10783",
                "10785",
                "10787",
                "10789",
                "10823",
                "10825",
                "10827",
                "10829",
                "10961",
                "10963",
                "10965",
                "10967",
                "10969",
                "10997",
                "10999",
                "12043",
                "12045",
                "12047",
                "12049",
                "12051",
                "12053",
                "12055",
                "12057",
                "12059",
                "12099",
                "12101",
                "12103",
                "21205",
                "12107",
                "12109",
                "12157",
                "12159",
                "12161",
                "12163",
                "12165",
                "12167",
                "12169",
                "12203",
                "12205",
                "12207",
                "12209",
                "12247",
                "12249",
                "12277",
                "12279",
                "12305",
                "12307",
                "12309",
                "12347",
                "12349",
                "12351",
                "12353",
                "12355",
                "12357",
                "12359",
                "12435",
                "12437",
                "12439",
                "12459",
                "12487",
                "12489",
                "12524",
                "12526",
                "12527",
                "12555",
                "12557",
                "12559",
                "12587",
                "12589",
                "12619",
                "12621",
                "12623",
                "12627",
                "12629",
                "12679",
                "12681",
                "12683",
                "12685",
                "12687",
                "12689",
                "13051",
                "13053",
                "13055",
                "13057",
                "13059",
                "13086",
                "13088",
                "13089",
                "13125",
                "13127",
                "13129",
                "13156",
                "13158",
                "13159",
                "13187",
                "13189",
                "13347",
                "13349",
                "13351",
                "13353",
                "13355",
                "13357",
                "13359",
                "13403",
                "13405",
                "13407",
                "13409",
                "13435",
                "13437",
                "13439",
                "13465",
                "13467",
                "13469",
                "13503",
                "13505",
                "13507",
                "13509",
                "13581",
                "13583",
                "13585",
                "13587",
                "13589",
                "13591",
                "13593",
                "13595",
                "13597",
                "13599",
                "13627",
                "13629",
                "14050",
                "14052",
                "14053",
                "14055",
                "14057",
                "14059",
                "14089",
                "14109",
                "14129",
                "14163",
                "14165",
                "14167",
                "14169",
                "14193",
                "14195",
                "14197",
                "14199"
        );
    }

}
