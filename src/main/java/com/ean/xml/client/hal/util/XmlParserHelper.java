package com.ean.xml.client.hal.util;

import com.ean.xml.client.hal.base.room.Room;
import com.ean.xml.client.hal.base.room.RoomGroup;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlParserHelper {
    private XmlParserHelper() {
        //Do Nothing
    }

    public static void addElementString(Element container, String targetName, String targetValue) {
        if (StringUtils.isNotBlank(targetValue)) {
            container.addElement(targetName).setText(targetValue);
        }
    }

    public static void addElementInteger(Element container, String targetName, Integer targetValue) {
        if (targetValue != null) {
            container.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    public static void addElementLong(Element container, String targetName, Long targetValue) {
        if (targetValue != null) {
            container.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    public static void addElementFloat(Element container, String targetName, Float targetValue) {
        if (targetValue != null) {
            container.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    public static void addElement(Element container, Element targetValue){
        if (targetValue != null) {
            container.add(targetValue);
        }
    }

    public static void addRoomGroup(Element base, RoomGroup roomGroup) {
        Element container = DocumentHelper.createElement("RoomGroup");

        for (Room room : roomGroup.getRoom()) {
            Element element = container.addElement("Room");
            addElementInteger(element, "numberOfAdults", room.getNumberOfAdults());
            addElementInteger(element, "numberOfChildren", room.getNumberOfChildren());
            addElementString(element, "childAges", StringUtils.join(room.getChildAges(), ","));
        }

        base.add(container);
    }


    public static Element getElement(Element container, String elementName) {
        return (Element) container.selectSingleNode(elementName);
    }

    public static Integer getElementIntegerValue(Element element) {
        return (element != null) ? Integer.valueOf(element.getText()) : null;
    }

    public static Float getElementFloatValue(Element element) {
        return (element != null) ? Float.valueOf(element.getText()) : null;
    }

    public static Long getElementLongValue(Element element) {
        return (element != null) ? Long.valueOf(element.getText()) : null;
    }

    public static Boolean getElementBooleanValue(Element element) {
        return (element != null) ? Boolean.valueOf(element.getText()): null;
    }

    public static Integer getAttributeIntegerValue(Element element, String attributeName) {
        return (element != null) ? Integer.valueOf(element.attributeValue(attributeName)) : null;
    }

    public static Boolean getAttributeBooleanValue(Element element, String attributeName) {
        return (element != null) ? Boolean.valueOf(element.attributeValue(attributeName)) : null;
    }

    public static Float getAttributeFloatValue(Element element, String attributeName) {
        return (element != null) ? Float.valueOf(element.attributeValue(attributeName)) : null;
    }

    public static Float getAttributeFloatValue(Attribute att) {
        return Float.valueOf(att.getValue());
    }
}
