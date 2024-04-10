package com.coder.coderschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CoderSchoolInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        Map<String, String> coderMap = new HashMap<>();
        coderMap.put("App name", "Coder School");
        coderMap.put("App Description", "Coder School Web Application for Students and Admin");
        coderMap.put("App Version", "1.0.0");
        coderMap.put("Contact Email", "info@coderschool.com");
        coderMap.put("Contact Mobile", "+1(21) 673 4587");
        builder.withDetail("coderschool-info", coderMap);

    }
}
