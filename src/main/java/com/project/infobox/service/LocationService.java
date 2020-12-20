package com.project.infobox.service;

import javax.servlet.http.HttpServletRequest;

public interface LocationService {
    Double[] getLatLonFromIP(HttpServletRequest request);
}
