/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.tools.crepecake.registry;

import com.google.api.client.http.HttpMethods;
import com.google.cloud.tools.crepecake.http.Request;
import com.google.cloud.tools.crepecake.http.Response;
import java.net.MalformedURLException;
import java.net.URL;

/** Retrieves the {@code WWW-Authenticate} header from the registry API. */
class AuthenticationMethodRetriever implements RegistryEndpointProvider<String> {

  private final RegistryEndpointProperties registryEndpointProperties;

  @Override
  public void buildRequest(Request.Builder builder) {}

  @Override
  public String handleResponse(Response response) {
    return response.getAuthenticate();
  }

  @Override
  public URL getApiRoute(String apiRouteBase) throws MalformedURLException {
    return new URL(apiRouteBase);
  }

  @Override
  public String getHttpMethod() {
    return HttpMethods.GET;
  }

  @Override
  public String getActionDescription() {
    return "retrieve authentication method for " + registryEndpointProperties.getServerUrl();
  }

  AuthenticationMethodRetriever(RegistryEndpointProperties registryEndpointProperties) {
    this.registryEndpointProperties = registryEndpointProperties;
  }
}
