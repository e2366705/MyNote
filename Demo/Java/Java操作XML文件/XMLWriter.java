package com.example.demo.test;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import com.example.demo.test.pojo.Words;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLWriter {

    private static String xmlPath = "MyXml.xml";


    public static void getFamilyMemebers() {

        // 创建文件工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // 如果创建的解析器在解析XML文档时必须删除元素内容中的空格，则为true，否则为false
        dbf.setIgnoringElementContentWhitespace(true);

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlPath);

            JsonObject jsonObject = new JsonObject();
            JsonArray jArray = new JsonArray();



            jsonObject.add("languages", jArray);
            System.out.println(jsonObject);

            // 历遍列表，进行XML文件的数据提取
            // 根据节点名称来获取所有相关的节点
            NodeList sonlist = doc.getElementsByTagName("data");
            for (int i = 0; i < sonlist.getLength(); i++) {
                Element son = (Element) sonlist.item(i);
                for (Node node = son.getFirstChild(); node != null; node = node.getNextSibling()) {
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        String name = node.getNodeName();
                        String value = node.getFirstChild().getNodeValue();
                        System.out.println(name + " : " + value);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    // 修改
    public static void Modify_status(String id , String status) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmldoc = db.parse(xmlPath);

            // 获取根节点
            Element root = xmldoc.getDocumentElement();
            // 定位id为001的节点
            Element per = (Element) selectSingleNode("/Root/data[@id='"+ id +"']",root);

            if (status == "be_familiar_with" || status == "not_familiar_with"){
                // 将age节点的内容更改为 status
                per.getElementsByTagName("status").item(0).setTextContent(status);
            }

            // 保存
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer former = factory.newTransformer();
            former.transform(new DOMSource(xmldoc), new StreamResult(new File(
                    xmlPath)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 获取目标节点，进行删除，最后保存
    public static void Delete(String id) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmldoc = db.parse(xmlPath);
            // 获取根节点
            Element root = xmldoc.getDocumentElement();
            // 定位根节点中的id=002的节点
            Element son = (Element) selectSingleNode("/Root/data[@id='"+ id +"']",root);
            // 删除该节点
            root.removeChild(son);
            // 保存
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer former = factory.newTransformer();
            former.transform(new DOMSource(xmldoc), new StreamResult(new File(xmlPath)));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void select_by_id(String id){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmldoc = db.parse(xmlPath);

            // 获取根节点
            Element root = xmldoc.getDocumentElement();
            // 定位id为001的节点
            Element per = (Element) selectSingleNode("/Root/data[@id='"+ id +"']",root);


            String word = per.getElementsByTagName("word").item(0).getTextContent();
            System.out.println(word);

            String translation = per.getElementsByTagName("translation").item(0).getTextContent();
            System.out.println(translation);

            String status = per.getElementsByTagName("status").item(0).getTextContent();
            System.out.println(status);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static boolean if_select_by_id(String id){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmldoc = db.parse(xmlPath);

            // 获取根节点
            Element root = xmldoc.getDocumentElement();
            // 定位id为001的节点
            Element per = (Element) selectSingleNode("/Root/data[@id='"+ id +"']",root);

            if (per == null){
                return false;
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }





    // 新增节点
    public static void createDom(Words words) {
        System.out.println(words.toString());

        boolean status_bool = if_select_by_id(words.getWord());
        if (status_bool == true){
            System.err.println("Error: word already existed ! ! ");
        }else {

            if (words.getTranslation() == null){
                words.setTranslation("unknown");
            }
            if (words.getStatus() == null){
                words.setStatus("unknown");
            }

            // 创建文件工厂实例
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringElementContentWhitespace(false);
            try {

                DocumentBuilder db = dbf.newDocumentBuilder();
                // 创建Document对象
                Document xmldoc = db.parse(xmlPath);
                // 获取根节点
                Element root = xmldoc.getDocumentElement();

                // 创建节点son，设置对应的id
                Element son = xmldoc.createElement("data");
                son.setAttribute("id", words.getWord());

                // 创建节点 word
                Element ele_word = xmldoc.createElement("word");
                ele_word.setTextContent(words.getWord());
                son.appendChild(ele_word);

                // 创建节点 translation
                Element ele_translation = xmldoc.createElement("translation");
                ele_translation.setTextContent(words.getTranslation());
                son.appendChild(ele_translation);

                // 创建节点 status
                Element ele_status = xmldoc.createElement("status");
                ele_status.setTextContent(words.getStatus());
                son.appendChild(ele_status);

                // 把son添加到根节点中
                root.appendChild(son);

                // 保存
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer former = factory.newTransformer();
                former.transform(new DOMSource(xmldoc), new StreamResult(new File(xmlPath)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 修改节点信息
    public static Node selectSingleNode(String express, Element source) {
        Node result = null;

        //创建XPath工厂
        XPathFactory xpathFactory = XPathFactory.newInstance();

        //创建XPath对象
        XPath xpath = xpathFactory.newXPath();
        try {
            result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }


    @Test
    public void add() {
        System.out.println("添加数据");
        getFamilyMemebers();

        Words word = new Words();
        word.setWord("didi");

        createDom(word);

    }

    @Test
    public void delete() {
        System.out.println("删除数据");
        getFamilyMemebers();
        Delete("didi");
    }

    @Test
    public void Modify_status_() {
        System.out.println("修改数据");
        getFamilyMemebers();
        Modify_status("baidu2" , "be_familiar_with");
    }

    @Test
    public void select_All() {
        // select
        getFamilyMemebers();
    }

    @Test
    public void select_by_id() {
        // select
        select_by_id("srgfsedrg");
        select_by_id("trehdrghdsrthj");
    }


    @Test
    public void if_select_by_id_1(){
       boolean status = if_select_by_id("apple233");

       if (status == true){
           System.err.println("have...");
       }else {
           System.err.println("not have...");
       }
    }
}
