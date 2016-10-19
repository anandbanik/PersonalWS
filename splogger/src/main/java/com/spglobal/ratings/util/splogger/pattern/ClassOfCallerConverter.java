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
package com.spglobal.ratings.util.splogger.pattern;

import com.spglobal.ratings.util.splogger.spi.CallerData;
import com.spglobal.ratings.util.splogger.spi.ILoggingEvent;

public class ClassOfCallerConverter extends NamedConverter {

	protected String getFullyQualifiedName(ILoggingEvent event) {

        StackTraceElement[] cda = event.getCallerData();
        if (cda != null && cda.length > 0) {
            return cda[0].getClassName();
        } else {
            return CallerData.NA;
        }
    }

	

	


}
