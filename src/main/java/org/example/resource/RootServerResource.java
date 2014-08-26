/**
 *
 * Copyright (c) 2014 Kerby Martino and others. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.example.resource;

import org.restlet.ext.servlet.ServletUtils;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.servlet.http.HttpServletRequest;

/**
 * Resource which has only one representation.
 */
public class RootServerResource extends ServerResource {
    @Get("json")
    public String represent() {
        String client = getRequest().getClientInfo().getAddress();
        org.restlet.Request restletRequest = getRequest();
        HttpServletRequest servletRequest = ServletUtils.getRequest(restletRequest);
        String localName = servletRequest.getLocalName();
        String path = getRequest().getResourceRef().getHostIdentifier() +
                getRequest().getResourceRef().getPath();
        return "hello, world (from the cloud!), your client IP: " + client + " and domain is: " + localName + " path is: " + path;
    }
}