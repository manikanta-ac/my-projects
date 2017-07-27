package com.mani.proj.message;

import java.util.Map;
import org.apache.camel.Converter;
import org.springframework.stereotype.Component;

@Component
public final class MessageConverter {
    private static final String PAYLOAD = "message.payload";

    @Converter
    public static String convertToInwardMessage(Object messageDetail) {

        @SuppressWarnings("unchecked")
        Map<String, Object> messageDetailMap = (Map<String, Object>) messageDetail;
        String payload = (String) messageDetailMap.get(PAYLOAD);
		/*
			Business Logic
		*/
        return payload;
    }
}
