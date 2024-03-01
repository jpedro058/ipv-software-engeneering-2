package com.es2.bridge;

public class APIRequestContentAggregator extends APIRequest {

    public APIRequestContentAggregator() {
        super();
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
        StringBuilder aggregatedContent = new StringBuilder();

        for (APIServiceInterface service : services.values()) {
            String content = service.getContent(contentId);
            if (content != null) {
                aggregatedContent.append(content);
            }
        }

        if (aggregatedContent.length() == 0) {
            return null; // Return null if no content is found for any service.
        }

        return aggregatedContent.toString();
    }
}
