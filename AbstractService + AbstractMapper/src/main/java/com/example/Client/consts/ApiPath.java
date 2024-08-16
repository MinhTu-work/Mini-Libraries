package com.example.Client.consts;

public interface ApiPath {
    String API = "/api/v1";

    // Tour
    String TOUR_CREATE  = "/tour/create";
    String TOUR_FIND_ALL = "/tour/find-all";
    String  TOUR_FIND_BY_ID = "/tour/find-by-id";
    String TOUR_UPDATE = "/tour/update";
    String TOUR_DELETE = "/tour/delete";

    // Tour Detail
    String TOUR_DETAIL_CREATE = "/tour-detail/create";
    String TOUR_DETAIL_FIND_ALL = "/tour-detail/find-all";
    String TOUR_DETAIL_FIND_BY_ID = "/tour-detail/find-by-id";
    String TOUR_DETAIL_UPDATE = "/tour-detail/update";
    String TOUR_DETAIL_DELETE = "/tour-detail/delete";

}
