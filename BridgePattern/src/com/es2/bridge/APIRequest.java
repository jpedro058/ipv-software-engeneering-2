package com.es2.bridge;

import java.util.HashMap;

public class APIRequest {

    protected HashMap<String, APIServiceInterface> services;

    public APIRequest() {
        this.services = new HashMap<>();
    }

    public String addService(APIServiceInterface service) {
        String serviceId = generateServiceId();
        services.put(serviceId, service);
        return serviceId;
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
        if (!services.containsKey(serviceId)) {
            throw new ServiceNotFoundException("Service with ID " + serviceId + " not found.");
        }

        APIServiceInterface service = services.get(serviceId);
        return service.getContent(contentId);
    }

    public String setContent(String serviceId, String content) throws ServiceNotFoundException {
        if (!services.containsKey(serviceId)) {
            throw new ServiceNotFoundException("Service with ID " + serviceId + " not found.");
        }

        APIServiceInterface service = services.get(serviceId);
        return service.setContent(content);
    }

    // Helper method to generate a unique service ID
    private String generateServiceId() {
        // This is a simplistic approach to generate a unique ID.
        // In a real-world scenario, a more robust approach should be used.
        return java.util.UUID.randomUUID().toString();
    }
}
