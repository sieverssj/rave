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

import org.apache.rave.model.ModelConverter;
import org.apache.rave.portal.model.conversion.JpaConverter;
import org.apache.rave.portal.model.impl.AddressImpl;
import org.apache.rave.portal.model.impl.PersonImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.*;

/**
 * Test for {@link JpaWidget}
 */
@Ignore
public class WidgetTest {
    private JpaWidget widget;
    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;
    private String screenshotUrl;
    private String type;
    private String author;
    private String description;
    private WidgetStatus status;
    private List<WidgetComment> widgetComments;
    private List<WidgetRating> ratings;
    private List<WidgetTag> tags;
    
    @Before
    public void setUp() throws Exception {
        ModelConverter personConverter = createMock(ModelConverter.class);
        expect(personConverter.getSourceType()).andReturn(Person.class).anyTimes();
        expect(personConverter.convert(isA(PersonImpl.class))).andReturn(new JpaPerson());
        replay(personConverter);

        ModelConverter addressConverter = createMock(ModelConverter.class);
        expect(addressConverter.getSourceType()).andReturn(Address.class).anyTimes();
        expect(addressConverter.convert(isA(AddressImpl.class))).andReturn(new JpaAddress());
        replay(addressConverter);

        ModelConverter pageLayoutConverter = createMock(ModelConverter.class);
        expect(pageLayoutConverter.getSourceType()).andReturn(Address.class).anyTimes();
        expect(pageLayoutConverter.convert(isA(PageLayout.class))).andReturn(new JpaPageLayout());
        replay(pageLayoutConverter);
        List<ModelConverter> converters = new ArrayList<ModelConverter>();
        converters.add(personConverter);
        converters.add(addressConverter);
        new JpaConverter(converters);
        widget = new JpaWidget();
        id = 3511L;
        title = "Test Widget";
        url = "http://example.com/widget.xml";
        thumbnailUrl = "http://example.com/widget_thumbnail.png";
        screenshotUrl = "http://example.com/widget_screenshot.png";
        type = "OpenSocial";
        author = "John Doe";
        description = "This is a test widget";
        status = WidgetStatus.PREVIEW;
        widgetComments = new ArrayList<WidgetComment>();

        JpaTag tag=new JpaTag(1L, "test") ;
        JpaTag tag1=new JpaTag(2L, "test1") ;
        
        ratings = new ArrayList<WidgetRating>();
        ratings.add(new JpaWidgetRating(1L, 1L, 1L, 1));
        
        tags = new ArrayList<WidgetTag>();
        tags.add(new JpaWidgetTag(1L, 1L, new JpaUser(), new Date(), tag)) ;
        tags.add(new JpaWidgetTag(2L,1L, new JpaUser(), new Date(), tag1)) ;

        widget.setEntityId(id);
        widget.setTitle(title);
        widget.setUrl(url);
        widget.setThumbnailUrl(thumbnailUrl);
        widget.setScreenshotUrl(screenshotUrl);
        widget.setType(type);
        widget.setAuthor(author);
        widget.setDescription(description);
        widget.setWidgetStatus(status);
        widget.setComments(widgetComments);
        widget.setRatings(ratings);
        widget.setTags(tags);

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
        assertEquals(widgetComments, widget.getComments());
        assertEquals(ratings, widget.getRatings());
        assertEquals(tags, widget.getTags());


    }

    @After
    public void tearDown() throws Exception {
        widget = null;
    }
}
