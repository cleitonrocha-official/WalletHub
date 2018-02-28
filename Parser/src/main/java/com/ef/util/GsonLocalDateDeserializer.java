package com.ef.util;



import java.lang.reflect.Type;
import java.time.LocalDateTime;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GsonLocalDateDeserializer implements JsonDeserializer<LocalDateTime> {

	  @Override
	    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String dataCadastro = json.getAsJsonPrimitive().getAsString();
		
		return LocalDateTime.parse(dataCadastro,DateFormatterUtil.forReadLog());
	    }
	
}
