
package com.spglobal.ratings.util.splogger.core;

import java.util.HashMap;
import java.util.Map;

import com.spglobal.ratings.util.splogger.pattern.CallerDataConverter;
import com.spglobal.ratings.util.splogger.pattern.ClassOfCallerConverter;
import com.spglobal.ratings.util.splogger.pattern.ContextNameConverter;
import com.spglobal.ratings.util.splogger.pattern.DateConverter;
import com.spglobal.ratings.util.splogger.pattern.EnsureExceptionHandling;
import com.spglobal.ratings.util.splogger.pattern.ExtendedThrowableProxyConverter;
import com.spglobal.ratings.util.splogger.pattern.FileOfCallerConverter;
import com.spglobal.ratings.util.splogger.pattern.LevelConverter;
import com.spglobal.ratings.util.splogger.pattern.LineOfCallerConverter;
import com.spglobal.ratings.util.splogger.pattern.LineSeparatorConverter;
import com.spglobal.ratings.util.splogger.pattern.LocalSequenceNumberConverter;
import com.spglobal.ratings.util.splogger.pattern.LoggerConverter;
import com.spglobal.ratings.util.splogger.pattern.MDCConverter;
import com.spglobal.ratings.util.splogger.pattern.MarkerConverter;
import com.spglobal.ratings.util.splogger.pattern.MessageConverter;
import com.spglobal.ratings.util.splogger.pattern.MethodOfCallerConverter;
import com.spglobal.ratings.util.splogger.pattern.NopThrowableInformationConverter;
import com.spglobal.ratings.util.splogger.pattern.PropertyConverter;
import com.spglobal.ratings.util.splogger.pattern.RelativeTimeConverter;
import com.spglobal.ratings.util.splogger.pattern.RootCauseFirstThrowableProxyConverter;
import com.spglobal.ratings.util.splogger.pattern.ThreadConverter;
import com.spglobal.ratings.util.splogger.pattern.ThrowableProxyConverter;
import com.spglobal.ratings.util.splogger.pattern.color.HighlightingCompositeConverter;
import com.spglobal.ratings.util.splogger.spi.ILoggingEvent;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.pattern.PatternLayoutBase;
import ch.qos.logback.core.pattern.color.*;
import ch.qos.logback.core.pattern.parser.Parser;

/**
 * <p>
 * A flexible layout configurable with pattern string. The goal of this class is
 * to {@link #format format} a {@link ILoggingEvent} and return the results in a
 * {#link String}. The format of the result depends on the
 * <em>conversion pattern</em>.
 * <p>
 * 
 */

public class PatternLayout extends PatternLayoutBase<ILoggingEvent> {

    public static final Map<String, String> defaultConverterMap = new HashMap<String, String>();
    public static final String HEADER_PREFIX = "#logback.classic pattern: ";

    static {
        defaultConverterMap.putAll(Parser.DEFAULT_COMPOSITE_CONVERTER_MAP);

        defaultConverterMap.put("d", DateConverter.class.getName());
        defaultConverterMap.put("date", DateConverter.class.getName());

        defaultConverterMap.put("r", RelativeTimeConverter.class.getName());
        defaultConverterMap.put("relative", RelativeTimeConverter.class.getName());

        defaultConverterMap.put("level", LevelConverter.class.getName());
        defaultConverterMap.put("le", LevelConverter.class.getName());
        defaultConverterMap.put("p", LevelConverter.class.getName());

        defaultConverterMap.put("t", ThreadConverter.class.getName());
        defaultConverterMap.put("thread", ThreadConverter.class.getName());

        defaultConverterMap.put("lo", LoggerConverter.class.getName());
        defaultConverterMap.put("logger", LoggerConverter.class.getName());
        defaultConverterMap.put("c", LoggerConverter.class.getName());

        defaultConverterMap.put("m", MessageConverter.class.getName());
        defaultConverterMap.put("msg", MessageConverter.class.getName());
        defaultConverterMap.put("message", MessageConverter.class.getName());

        defaultConverterMap.put("C", ClassOfCallerConverter.class.getName());
        defaultConverterMap.put("class", ClassOfCallerConverter.class.getName());

        defaultConverterMap.put("M", MethodOfCallerConverter.class.getName());
        defaultConverterMap.put("method", MethodOfCallerConverter.class.getName());

        defaultConverterMap.put("L", LineOfCallerConverter.class.getName());
        defaultConverterMap.put("line", LineOfCallerConverter.class.getName());

        defaultConverterMap.put("F", FileOfCallerConverter.class.getName());
        defaultConverterMap.put("file", FileOfCallerConverter.class.getName());

        defaultConverterMap.put("X", MDCConverter.class.getName());
        defaultConverterMap.put("mdc", MDCConverter.class.getName());

        defaultConverterMap.put("ex", ThrowableProxyConverter.class.getName());
        defaultConverterMap.put("exception", ThrowableProxyConverter.class.getName());
        defaultConverterMap.put("rEx", RootCauseFirstThrowableProxyConverter.class.getName());
        defaultConverterMap.put("rootException", RootCauseFirstThrowableProxyConverter.class.getName());
        defaultConverterMap.put("throwable", ThrowableProxyConverter.class.getName());

        defaultConverterMap.put("xEx", ExtendedThrowableProxyConverter.class.getName());
        defaultConverterMap.put("xException", ExtendedThrowableProxyConverter.class.getName());
        defaultConverterMap.put("xThrowable", ExtendedThrowableProxyConverter.class.getName());

        defaultConverterMap.put("nopex", NopThrowableInformationConverter.class.getName());
        defaultConverterMap.put("nopexception", NopThrowableInformationConverter.class.getName());

        defaultConverterMap.put("cn", ContextNameConverter.class.getName());
        defaultConverterMap.put("contextName", ContextNameConverter.class.getName());

        defaultConverterMap.put("caller", CallerDataConverter.class.getName());

        defaultConverterMap.put("marker", MarkerConverter.class.getName());

        defaultConverterMap.put("property", PropertyConverter.class.getName());

        defaultConverterMap.put("n", LineSeparatorConverter.class.getName());

        defaultConverterMap.put("black", BlackCompositeConverter.class.getName());
        defaultConverterMap.put("red", RedCompositeConverter.class.getName());
        defaultConverterMap.put("green", GreenCompositeConverter.class.getName());
        defaultConverterMap.put("yellow", YellowCompositeConverter.class.getName());
        defaultConverterMap.put("blue", BlueCompositeConverter.class.getName());
        defaultConverterMap.put("magenta", MagentaCompositeConverter.class.getName());
        defaultConverterMap.put("cyan", CyanCompositeConverter.class.getName());
        defaultConverterMap.put("white", WhiteCompositeConverter.class.getName());
        defaultConverterMap.put("gray", GrayCompositeConverter.class.getName());
        defaultConverterMap.put("boldRed", BoldRedCompositeConverter.class.getName());
        defaultConverterMap.put("boldGreen", BoldGreenCompositeConverter.class.getName());
        defaultConverterMap.put("boldYellow", BoldYellowCompositeConverter.class.getName());
        defaultConverterMap.put("boldBlue", BoldBlueCompositeConverter.class.getName());
        defaultConverterMap.put("boldMagenta", BoldMagentaCompositeConverter.class.getName());
        defaultConverterMap.put("boldCyan", BoldCyanCompositeConverter.class.getName());
        defaultConverterMap.put("boldWhite", BoldWhiteCompositeConverter.class.getName());
        defaultConverterMap.put("highlight", HighlightingCompositeConverter.class.getName());

        defaultConverterMap.put("lsn", LocalSequenceNumberConverter.class.getName());

    }

    public PatternLayout() {
        this.postCompileProcessor = new EnsureExceptionHandling();
    }

    public Map<String, String> getDefaultConverterMap() {
        return defaultConverterMap;
    }

    public String doLayout(ILoggingEvent event) {
        if (!isStarted()) {
            return CoreConstants.EMPTY_STRING;
        }
        return writeLoopOnConverters(event);
    }

    @Override
    protected String getPresentationHeaderPrefix() {
        return HEADER_PREFIX;
    }
}
