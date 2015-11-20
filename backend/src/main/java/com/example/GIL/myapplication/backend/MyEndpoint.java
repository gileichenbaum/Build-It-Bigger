/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.GIL.myapplication.backend;

import com.example.JokeApi;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1.0",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.GIL.example.com",
                ownerName = "backend.myapplication.GIL.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that returns random joke
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        response.setData(JokeApi.getJoke());
        return response;
    }
}
