package APIS;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api")
public class Api {

    @GetMapping(value = "/getCertificate")
    public Map<String, Object> getCertificate() {
        Map<String, Object> certificate = new LinkedHashMap<>();

        Map<String, Object> address = new LinkedHashMap<>();
        address.put("@type", "");
        address.put("@line1", "");
        address.put("@line2", "");
        address.put("@house", "");
        address.put("@landmark", "");
        address.put("@locality", "");
        address.put("@vtc", "");
        address.put("@district", "");
        address.put("@pin", "");
        address.put("@state", "");
        address.put("@county", "IN");

        Map<String, Object> organization = new LinkedHashMap<>();
        organization.put("@name", "Board of Intermediate Education");
        organization.put("@code", "");
        organization.put("@tin", "");
        organization.put("@uid", "");
        organization.put("@type", "");
        organization.put("Address", address);

        Map<String, Object> issuedBy = new LinkedHashMap<>();
        issuedBy.put("Organization", organization);

        Map<String, Object> issuedTo = new LinkedHashMap<>();
        Map<String, Object> person = new LinkedHashMap<>();
        person.put("@category", "");
        person.put("@disabilityStatus", "");
        person.put("@dob", "");
        person.put("@email", "");
        person.put("@gender", "Male");
        person.put("@maritalStatus", "");
        person.put("@motherName", "PARVATHAM VARA LAKSHMI");
        person.put("@fatherName", "PARVATHAM SAMBASIVA RAO");
        person.put("@name", "PARVATHAM SAI RAVI TEJA");
        person.put("@phone", "");
        person.put("@religion", "");
        person.put("@swd", "");
        person.put("@swdIndicator", "");
        person.put("@uid", "");
        person.put("@title", "");
        person.put("Address", address);

        Map<String, Object> photo = new HashMap<>();
        photo.put("@format", "");
        photo.put("@CurrentNodeValue", "");

        person.put("Photo", photo);
        issuedTo.put("Person", person);

        Map<String, Object> school = new LinkedHashMap<>();
        school.put("@name", "SRI CHAITANYA COED JR COLLEGE");
        school.put("", "");

        Map<String, Object> examination = new LinkedHashMap<>();
        examination.put("@month", "MARCH");
        examination.put("@name", "");
        examination.put("@year", "2015");

        Map<String, Object> performance = new LinkedHashMap<>();
        performance.put("@cgpa", "");
        performance.put("@cgpaMax", "");
        performance.put("@grade", "A");
        performance.put("@marksMax", "");
        performance.put("@marksTotal", "865");
        performance.put("@percentage", "");
        performance.put("@result", "");
        performance.put("@resultDate", "");
        performance.put("@updateDate", "");

        Map<String, Object> subjects = new LinkedHashMap<>();
        subjects.put("Subjects", new Map[]{
                createSubject("01", "ENGLISH", "100", "084"),
                createSubject("17", "SANSKRIT", "100", "098"),
                createSubject("37", "BOTANY", "060", "053"),
                createSubject("38", "ZOOLOGY", "060", "053"),
                createSubject("41", "PHYSICS", "060", "054"),
                createSubject("42", "CHEMISTRY", "060", "036"),
                createSubject("02", "ENGLISH", "100", "086"),
                createSubject("18", "SANSKRIT", "100", "093"),
                createSubject("37", "BOTANY", "060", "051"),
                createSubject("38", "ZOOLOGY", "060", "049"),
                createSubject("41", "PHYSICS", "060", "042"),
                createSubject("42", "CHEMISTRY", "060", "046"),
                createSubject("39", "", "030", "029"),
        });

        performance.put("Subjects", subjects);

        Map<String, Object> singedInfo = new LinkedHashMap<>();

        Map<String, Object> signature = new LinkedHashMap<>();


        Map<String, Object> certificateDate = new LinkedHashMap<>();
        certificateDate.put("School", school);
        certificateDate.put("Examination", examination);
        certificateDate.put("Performance", performance);

        Map<String, Object> certificateMap = new LinkedHashMap<>();
        certificateMap.put("@language", "99");
        certificateMap.put("@name", "Class XII Marksheet");
        certificateMap.put("@type", "HSCER");
        certificateMap.put("@number", "");
        certificateMap.put("@issuedAt", "");
        certificateMap.put("@issueDate", "");
        certificateMap.put("@validFromDate", "28/04/2015");
        certificateMap.put("@status", "A");
        certificateMap.put("IssuedBy", issuedBy);
        certificateMap.put("IssuedTo", issuedTo);
        certificateMap.put("CertificateDate", certificateDate);
        certificate.put("Certificate", certificateMap);
        return certificate;
    }

    private Map<String, Object> createSubject(String code, String marksMax, String marksTotal, String name) {
        Map<String, Object> subjects = new LinkedHashMap<>();
        subjects.put("@code", code);
        subjects.put("@gp", "");
        subjects.put("@gpMax", "");
        subjects.put("@grade", "");
        subjects.put("@marksMax", marksMax);
        subjects.put("@marksMaxPractical", "");
        subjects.put("@marksMaxTheory", "");
        subjects.put("@marksPractical", "");
        subjects.put("@marksTheory", "");
        subjects.put("@marksTotal", marksTotal);
        subjects.put("@name", name);
        return subjects;
    }

    @GetMapping(value = "newMethod")
    public Map<String, Object> newMethod() {

        Map<String, Object> algorithm = new LinkedHashMap<>();
        algorithm.put("@Algorithm", "http://www.w3.org/2001/10/xml-exc-c14n#");

        Map<String,Object> algorithm1 = new LinkedHashMap<>();
        algorithm1.put("@Algorithm","http://www.w3.org/2000/09/xmldsig#rsa-sha1");

        Map<String, Object> uri = getStringObjectMap();

        Map<String, Object> canonicalizationMethod = new LinkedHashMap<>();
        canonicalizationMethod.put("CanonicalizationMethod", algorithm);
        canonicalizationMethod.put("SignatureMethod",algorithm1);
        canonicalizationMethod.put("Reference",uri);

        Map<String,Object> xml = new LinkedHashMap<>();
        xml.put("@xmlns", "http://www.w3.org/2000/09/xmldsig#");
        xml.put("SignedInfo", canonicalizationMethod);
        xml.put("SignatureValue","ag4Am1Rcv6WR8LlL6x8DXUld0Lr98yFXH6r50/EJ7noGV1vFC2TlylCS3Yt6K8hDfeTma0qulQAxhbBf8g12xa+rK9OFDYTM7EkRa4KVVxMVBJUmUKRlk1G1nKUUSe+cRKxHdLNGzG3Qu16MmCX5qjdxoztqSXUx/ADGADdeYXI2XoJWABlFtDRcf9sSo9JtdxOVt5zmYKIUaN5089oDdoWpYDcRHeH1MUJweCISXy0LGtbbV5ZeYzHoSbeKM/v5GiJY985IeArCV0q9uJun13zA7oGxSE0zU/XLuURWj6/Xxomxlo/RIs+XrWUk6FCGn99yToou1q+DMPjjpchCLw==");

        Map<String, Object> signature = new LinkedHashMap<>();
        signature.put("Signature",xml);
        return signature;
    }

    private static Map<String, Object> getStringObjectMap() {
        Map<String,Object> algorithm2 = new LinkedHashMap<>();
        algorithm2.put("@Algorithm","http://www.w3.org/2000/09/xmldsig#enveloped-signature");

        Map<String,Object> algorithm3 = new LinkedHashMap<>();
        algorithm3.put("@Algorithm","http://www.w3.org/2001/04/xmlenc#sha256");

        Map<String,Object> transform = new LinkedHashMap<>();
        transform.put("Transform",algorithm2);

        Map<String,Object> uri = new LinkedHashMap<>();
        uri.put("@URI","");
        uri.put("Transforms",transform);
        uri.put("DigestMethod",algorithm3);
        uri.put("DigestValue","zp+Buzdt2uWSgErINnbIhTrU71oMnPFJfIbrCb66CCs=");
        return uri;
    }
}
