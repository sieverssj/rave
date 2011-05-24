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

package org.apache.rave.portal.web.controller;

import org.apache.rave.portal.model.Widget;
import org.apache.rave.portal.service.WidgetService;
import org.apache.rave.portal.web.util.ModelKeys;
import org.apache.rave.portal.web.util.ViewNames;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class WidgetStoreControllerTest {

    private WidgetStoreController controller;
    private WidgetService widgetService;

    @Before
    public void setup() {
        widgetService = createNiceMock(WidgetService.class);
        controller = new WidgetStoreController(widgetService);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void view() {
        Model model = new ExtendedModelMap();
        List<Widget> widgets = new ArrayList<Widget>();

        expect(widgetService.getAllWidgets()).andReturn(widgets);
        replay(widgetService);

        String view = controller.view(model);

        verify(widgetService);
        assertThat(view, is(equalTo(ViewNames.STORE)));
        assertThat(model.containsAttribute(ModelKeys.WIDGETS), is(true));
        assertThat(widgets, is(sameInstance(widgets)));
    }

    @Test
    public void viewWidget() {
        Model model = new ExtendedModelMap();
        Widget w = new Widget();

        expect(widgetService.getWidget(1L)).andReturn(w);
        replay(widgetService);

        String view = controller.viewWidget(model, 1L);

        verify(widgetService);
        assertThat(view, is(equalTo(ViewNames.WIDGET)));
        assertThat(model.containsAttribute(ModelKeys.WIDGET), is(true));
        assertThat(((Widget)model.asMap().get(ModelKeys.WIDGET)), is(sameInstance(w)));
    }

}
