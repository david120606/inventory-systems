package com.dsa.services.pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PaginationService<T> {
    protected Map<String, Object> buildResponse(List<T> data, long totalRecords, int totalPages, int size) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("nextCursor", data.isEmpty() ? null : data.get(data.size() - 1));
        response.put("previousCursor", data.isEmpty() ? null : data.get(0));
        response.put("totalRecords", totalRecords);
        response.put("totalPages", totalPages);
        response.put("size", size);
        return response;
    }

    protected int calculateTotalPages(long totalRecords, int size) {
        return (int) Math.ceil((double) totalRecords / size);
    }
}
