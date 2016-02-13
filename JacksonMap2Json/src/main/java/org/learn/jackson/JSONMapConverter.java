package org.learn.jackson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONMapConverter 
{
    public static void main( String[] args ) throws IOException
    {
    	ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    	//Define map which will be converted to JSON
    	Map<String,Person>mapIdPerson  = new HashMap<>();
    	mapIdPerson.put("10101001", new Person("Mike", "harvey", 34));
    	mapIdPerson.put("20202002", new Person("Nick", "young", 75));
    	mapIdPerson.put("30303003", new Person("gary", "hudson", 21));
    	mapIdPerson.put("40404004", new Person("gary", "hudson", 55));
    	
    	//1. Convert Map to JSON
    	String mapToJson = objectMapper.writeValueAsString(mapIdPerson);
    	System.out.println("1. Convert Map to JSON :");
    	System.out.println(mapToJson);
    	
    	//2. JSON to Map
    	//Define Custom Type reference for map type
    	TypeReference<Map<String, Person>> mapType = new TypeReference<Map<String,Person>>() {};
    	Map<String,Person> jsonToMap = objectMapper.readValue(mapToJson, mapType);
    	System.out.println("\n2. Convert JSON to Map :");
    	
    	//Print map output using Java 8
    	jsonToMap.forEach((k, v) -> 
    						System.out.println(k + "=" + v));
    }
}
