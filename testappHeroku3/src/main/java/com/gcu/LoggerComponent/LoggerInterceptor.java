package com.gcu.LoggerComponent;

import org.slf4j.event.Level;

public interface LoggerInterceptor {
    void log(Level level, String className, String methodName, String message);
    
}
