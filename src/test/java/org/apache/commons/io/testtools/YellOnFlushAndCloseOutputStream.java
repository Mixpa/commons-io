/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.testtools;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.output.ProxyOutputStream;

import junit.framework.AssertionFailedError;

/**
 * Helper class for checking behaviour of IO classes.
 */
public class YellOnFlushAndCloseOutputStream extends ProxyOutputStream {

    private boolean yellOnFlush;
    private boolean yellOnClose;

    /**
     * @param proxy OutputStream to delegate to.
     * @param yellOnFlush True if flush() is forbidden
     * @param yellOnClose True if close() is forbidden
     */
    public YellOnFlushAndCloseOutputStream(final OutputStream proxy, final boolean yellOnFlush, final boolean yellOnClose) {
        super(proxy);
        this.yellOnFlush = yellOnFlush;
        this.yellOnClose = yellOnClose;
    }

    /** @see java.io.OutputStream#flush() */
    @Override
    public void flush() throws IOException {
        if (yellOnFlush) {
            throw new AssertionFailedError(getClass().getSimpleName() + ".flush() called.");
        }
        super.flush();
    }

    /** @see java.io.OutputStream#close() */
    @Override
    public void close() throws IOException {
        if (yellOnClose) {
            throw new AssertionFailedError(getClass().getSimpleName() + ".close() called.");
        }
        super.close();
    }

    public void off() {
        yellOnFlush = false;
        yellOnClose = false;
    }

}
