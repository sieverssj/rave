/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.rave.portal.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
Test for {@link Widget}
 */
public class WidgetTest {
    private Widget widget;
    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;
    private String screenshotUrl;
    private String type;
    private String author;
    private String description;
    private WidgetStatus status;

    @Before
    public void setUp() throws Exception {
        widget= new Widget();
        id = 3511L;
        title = "Test Widget";
        url = "http://example.com/widget.xml";
        thumbnailUrl = "http://example.com/widget_thumbnail.png";
        screenshotUrl = "http://example.com/widget_screenshot.png";
        type = "OpenSocial";
        author = "John Doe";
        description = "This is a test widget";
        status = WidgetStatus.PREVIEW;

        widget.setEntityId(id);
        widget.setTitle(title);
        widget.setUrl(url);
        widget.setThumbnailUrl(thumbnailUrl);
        widget.setScreenshotUrl(screenshotUrl);
        widget.setType(type);
        widget.setAuthor(author);
        widget.setDescription(description);
        widget.setWidgetStatus(status);
    }

    @Test
    public void testAccessorMethods() {
        assertEquals(id, widget.getEntityId());
        assertEquals(title, widget.getTitle());
        assertEquals(url, widget.getUrl());
        assertEquals(thumbnailUrl, widget.getThumbnailUrl());
        assertEquals(screenshotUrl, widget.getScreenshotUrl());
        assertEquals(type, widget.getType());
        assertEquals(author, widget.getAuthor());
        assertEquals(description, widget.getDescription());
        assertEquals(status, widget.getWidgetStatus());
    }

    @After
    public void tearDown() throws Exception {
        widget = null;
    }
}
