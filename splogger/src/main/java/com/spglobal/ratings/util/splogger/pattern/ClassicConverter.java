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


import com.spglobal.ratings.util.splogger.spi.ILoggingEvent;

import ch.qos.logback.core.pattern.DynamicConverter;

/**
 * This class serves the super-class of all converters in logback. It extends
 * {@link DynamicConverter}.
 *
 * @author Ceki Gulcu
 */
abstract public class ClassicConverter extends DynamicConverter<ILoggingEvent> {

}
