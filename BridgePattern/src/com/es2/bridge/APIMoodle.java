package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.Map;

public class APIMoodle implements APIServiceInterface {

    private Map<String, String> content;

    public APIMoodle() {
        this.content = new LinkedHashMap<>();
    }

    @Override
    public String getContent(String contentId) {
        if (contentId.equals("0")) {
            // Concatenate all contents if contentId is "0"
            StringBuilder concatenatedContent = new StringBuilder();
            for (String c : content.values()) {
                concatenatedContent.append(c);
            }
            return concatenatedContent.toString();
        } else {
            // Otherwise, return the content associated with the contentId
            return content.get(contentId);
        }
    }

    @Override
    public String setContent(String content) {
        // Generate a unique contentId
        String contentId = generateContentId();
        this.content.put(contentId, content);
        return contentId;
    }

    // Helper method to generate a unique contentId
    private String generateContentId() {


        return java.util.UUID.randomUUID().toString();
    }
}
