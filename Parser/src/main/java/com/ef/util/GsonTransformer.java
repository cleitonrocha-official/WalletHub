package com.ef.util;



import java.time.LocalDateTime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTransformer {

	private static Gson transformer = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.disableHtmlEscaping()
			.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateSerializer())
			.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateDeserializer())
			.setPrettyPrinting()
			.create();

	public static String toJson(Object object) {

		return transformer.toJson(object);

	}

	public static <T> T toObject(String json, Class<T> clazz) {

		return transformer.fromJson(json, clazz);

	}

}
