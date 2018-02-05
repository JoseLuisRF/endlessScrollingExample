/*
 * Copyright (C) 2017 Answer Financial Inc.
 * Streetwise Drivers Club for Android
 */
package com.arusoft.joseluisrf.taiwanexampleapp.domain.executor;

import java.util.concurrent.Executor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 *  BaseUseCase out of the UI thread.
 */
public interface ThreadExecutor extends Executor {
}
