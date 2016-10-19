/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package com.spglobal.ratings.util.splogger.sift;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.spglobal.ratings.util.splogger.spi.ILoggingEvent;
import com.spglobal.ratings.util.splogger.util.DefaultNestedComponentRules;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.joran.action.ActionConst;
import ch.qos.logback.core.joran.action.AppenderAction;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.RuleStore;
import ch.qos.logback.core.sift.SiftingJoranConfiguratorBase;

public class SiftingJoranConfigurator extends SiftingJoranConfiguratorBase<ILoggingEvent> {

    SiftingJoranConfigurator(String key, String value, Map<String, String> parentPropertyMap) {
        super(key, value, parentPropertyMap);
    }

    @Override
    protected ElementPath initialElementPath() {
        return new ElementPath("configuration");
    }

    @Override
    protected void addInstanceRules(RuleStore rs) {
        super.addInstanceRules(rs);
        rs.addRule(new ElementSelector("configuration/appender"), new AppenderAction());
    }

    @Override
    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry registry) {
        DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(registry);
    }

    @Override
    protected void buildInterpreter() {
        super.buildInterpreter();
        Map<String, Object> omap = interpreter.getInterpretationContext().getObjectMap();
        omap.put(ActionConst.APPENDER_BAG, new HashMap());
        omap.put(ActionConst.FILTER_CHAIN_BAG, new HashMap());
        Map<String, String> propertiesMap = new HashMap<String, String>();
        propertiesMap.putAll(parentPropertyMap);
        propertiesMap.put(key, value);
        interpreter.setInterpretationContextPropertiesMap(propertiesMap);
    }

    @SuppressWarnings("unchecked")
    public Appender<ILoggingEvent> getAppender() {
        Map<String, Object> omap = interpreter.getInterpretationContext().getObjectMap();
        HashMap appenderMap = (HashMap) omap.get(ActionConst.APPENDER_BAG);
        oneAndOnlyOneCheck(appenderMap);
        Collection values = appenderMap.values();
        if (values.size() == 0) {
            return null;
        }
        return (Appender<ILoggingEvent>) values.iterator().next();
    }
}
