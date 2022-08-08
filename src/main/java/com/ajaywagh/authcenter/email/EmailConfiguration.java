package com.ajaywagh.authcenter.email;


import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.GmailScopes;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.List;

public class EmailConfiguration {
    @Value("${application_name}")
    private String APPLICATION_NAME;
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    @Value("${google_tokens_path}")
    private String TOKENS_DIRECTORY_PATH;

    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_SEND);

    @Value("${google_credentials_path}")
    private String CREDENTIALS_FILE_PATH;


}
