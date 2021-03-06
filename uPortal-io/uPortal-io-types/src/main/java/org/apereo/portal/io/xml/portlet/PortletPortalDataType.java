/**
 * Licensed to Apereo under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright ownership. Apereo
 * licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at the
 * following location:
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apereo.portal.io.xml.portlet;

import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.QName;
import org.apereo.portal.io.xml.AbstractPortalDataType;
import org.apereo.portal.io.xml.IExportAllPortalDataType;
import org.apereo.portal.io.xml.PortalDataKey;
import org.apereo.portal.portlet.om.IPortletDefinition;
import org.springframework.stereotype.Component;

/** Describes the {@link IPortletDefinition} for import and export. */
@Component("portletPortalDataType")
public class PortletPortalDataType extends AbstractPortalDataType
        implements IExportAllPortalDataType {

    public static final int ORDER = 90;

    public static final QName PORTLET_DEFINITION_QNAME =
            new QName(
                    "https://source.jasig.org/schemas/uportal/io/portlet-definition",
                    "portlet-definition");

    /** @deprecated used for importing old data files */
    @Deprecated
    public static final QName LEGACY_CHANNEL_DEFINITION_QNAME = new QName("channel-definition");

    public static final PortalDataKey IMPORT_50_DATA_KEY =
            new PortalDataKey(PORTLET_DEFINITION_QNAME, null, "5.0");

    /** @deprecated used for importing old data files */
    @Deprecated
    public static final PortalDataKey IMPORT_43_DATA_KEY =
            new PortalDataKey(PORTLET_DEFINITION_QNAME, null, "4.3");

    /** @deprecated used for importing old data files */
    @Deprecated
    public static final PortalDataKey IMPORT_40_DATA_KEY =
            new PortalDataKey(PORTLET_DEFINITION_QNAME, null, "4.0");

    /** @deprecated used for importing old data files */
    @Deprecated
    public static final PortalDataKey IMPORT_26_DATA_KEY =
            new PortalDataKey(
                    LEGACY_CHANNEL_DEFINITION_QNAME,
                    "classpath://org/jasig/portal/io/import-channel_v2-6.crn",
                    null);

    /** @deprecated used for importing old data files */
    @Deprecated
    public static final PortalDataKey IMPORT_30_DATA_KEY =
            new PortalDataKey(
                    LEGACY_CHANNEL_DEFINITION_QNAME,
                    "classpath://org/jasig/portal/io/import-channel_v3-0.crn",
                    null);

    /** @deprecated used for importing old data files */
    @Deprecated
    public static final PortalDataKey IMPORT_31_DATA_KEY =
            new PortalDataKey(
                    LEGACY_CHANNEL_DEFINITION_QNAME,
                    "classpath://org/jasig/portal/io/import-channel_v3-1.crn",
                    null);

    /** @deprecated used for importing old data files */
    @Deprecated
    public static final PortalDataKey IMPORT_32_DATA_KEY =
            new PortalDataKey(
                    LEGACY_CHANNEL_DEFINITION_QNAME,
                    "classpath://org/jasig/portal/io/import-channel_v3-2.crn",
                    null);

    private static final List<PortalDataKey> PORTAL_DATA_KEYS =
            Arrays.asList(
                    IMPORT_26_DATA_KEY,
                    IMPORT_30_DATA_KEY,
                    IMPORT_31_DATA_KEY,
                    IMPORT_32_DATA_KEY,
                    IMPORT_40_DATA_KEY,
                    IMPORT_43_DATA_KEY,
                    IMPORT_50_DATA_KEY);

    public PortletPortalDataType() {
        super(ORDER, PORTLET_DEFINITION_QNAME);
    }

    @Override
    public List<PortalDataKey> getDataKeyImportOrder() {
        return PORTAL_DATA_KEYS;
    }

    @Override
    public String getTitleCode() {
        return "Portlet Definition";
    }

    @Override
    public String getDescriptionCode() {
        return "Portlets published in the portal";
    }
}
