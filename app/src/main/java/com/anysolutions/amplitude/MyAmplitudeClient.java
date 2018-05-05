package com.anysolutions.amplitude;

import com.amplitude.api.AmplitudeClient;

public class MyAmplitudeClient extends AmplitudeClient {
    private static MyAmplitudeClient instance;

    private MyAmplitudeClient() {

    }

    private MyAmplitudeClient(String apiKey) {
        super(apiKey);
    }

    public static MyAmplitudeClient getInstance(String apiKey) {
        if(instance == null) {
            return new MyAmplitudeClient(apiKey);
        } else { return instance; }
    }
}
