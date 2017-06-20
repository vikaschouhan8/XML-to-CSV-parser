package com.geminidsystems.xmltocsv;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

import static com.geminidsystems.xmltocsv.Translator.translateData;

/**
 * Created by VikasChouhan on 3/31/2017.
 */
public class XML {
    public static void main(String args[]){

        try{
            final String INPUT_ZIP_FILE = "C:\\ObjectDefinition.zip";
            final String OUTPUT_FOLDER = "../XMLtoCSV/objects";

            Unzip unzip = new Unzip();
            unzip.unZipIt(INPUT_ZIP_FILE,OUTPUT_FOLDER);

            File[] files = new File("../XMLtoCSV/objects/unpackaged/objects/").listFiles();
            String language = selectLanguage();
            showFiles(files,language);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static String selectLanguage(){
        Scanner toLangs = new Scanner(System.in);
        System.out.println("Choose your Language code : \n\n"
                + "af    Afrikaans || " +
                "ak    Akan    || " + "sq    Albanian   || " + "am    Amharic       " + "\n" +
                "bn    Bengali || " + "bh    Bihari    || " + "bg    Bulgarian  || " + "km    Cambodian\n" +
                "zh-CN Chinese || " + "en    English   || " + "fr    French     || " + "ur    Urdu\n" +
                "de    German  || " + "el    Greek     || " + "gu    Gujarati   || " + "haw   Hawaiian\n" +
                "hi    Hindi   || " + "hu    Hungarian || " + "id    Indonesian || " + "ga    Irish\n" +
                "it    Italian || " + "ja    Japanese  || " + "kn    Kannada    || " + "ko    Korean\n" +
                "la    Latin   || " + "mg    Malagasy  || " + "ms    Malay      || " + "ml    Malayalam\n" +
                "mr    Marathi || " + "ne    Nepali    || " + "ru    Russian    || " + "sd    Sindhi\n" +
                "es    Spanish || " + "ta    Tamil     || " + "te    Telugu     || " + "th    Thai\n" +

                "\nEnter here your langauge code in which you wants to Translate =>  ");

        String desiredLanguage = toLangs.next();
        return desiredLanguage;
    }

    public static void showFiles(File[] files, String desiredLanguage) {
        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.println("=======================================================");
                System.out.println("File Name : " + file.getName());
                System.out.println("=======================================================");
                processFiles(file, desiredLanguage);
            }
        }
    }

    private static void processFiles(File file, String desiredLanguage) {
        try{
            String sourceLanguage = "en";
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("fields");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String labelName = eElement.getElementsByTagName("label").item(0).getTextContent();
                    translateData(sourceLanguage,desiredLanguage,labelName);
                    System.out.println("Label is : " + eElement.getElementsByTagName("label").item(0).getTextContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
