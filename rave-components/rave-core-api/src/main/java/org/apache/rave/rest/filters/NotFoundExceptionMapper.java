/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.rave.rest.filters;

import org.apache.rave.rest.exception.ResourceNotFoundException;
import org.apache.rave.rest.model.ErrorWrapperResponse;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created with IntelliJ IDEA.
 * User: erinnp
 * Date: 8/1/13
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Produces(MediaType.APPLICATION_JSON)
public class NotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {

    @Override
    public Response toResponse(ResourceNotFoundException e) {
        String id = e.getMessage();
        return Response.status(Response.Status.NOT_FOUND).entity(new ErrorWrapperResponse(
                "The requested resource could not be found.",
                "The requested resource could not be found."
        )).build();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
