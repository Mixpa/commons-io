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
package org.apache.commons.io.output;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.IOExceptionList;
import org.apache.commons.io.IOIndexedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit Test Case for {@link ProxyCollectionWriter}.
 */
public class ProxyCollectionWriterTest {

    @Test
    public void testArrayIOExceptionOnAppendChar1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final char data = 'A';
        try {
            tw.append(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).append(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnAppendChar2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        final char data = 'A';
        try {
            tw.append(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).append(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnAppendCharSequence1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final CharSequence data = "A";
        try {
            tw.append(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).append(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnAppendCharSequence2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        final CharSequence data = "A";
        try {
            tw.append(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).append(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnAppendCharSequenceIntInt1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final CharSequence data = "A";
        try {
            tw.append(data, 0, 0);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).append(data, 0, 0);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnAppendCharSequenceIntInt2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        final CharSequence data = "A";
        try {
            tw.append(data, 0, 0);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).append(data, 0, 0);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnClose1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        try {
            tw.close();
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).close();
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnClose2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        try {
            tw.close();
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).close();
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnFlush1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        try {
            tw.flush();
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).flush();
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnFlush2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        try {
            tw.flush();
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).flush();
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteCharArray1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final char[] data = new char[] { 'a' };
        try {
            tw.write(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteCharArray2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        final char[] data = new char[] { 'a' };
        try {
            tw.write(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteCharArrayIntInt1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final char[] data = new char[] { 'a' };
        try {
            tw.write(data, 0, 0);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data, 0, 0);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteCharArrayIntInt2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        final char[] data = new char[] { 'a' };
        try {
            tw.write(data, 0, 0);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data, 0, 0);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteInt1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final int data = 32;
        try {
            tw.write(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteInt2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        try {
            tw.write(32);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(32);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());

        }
    }

    @Test
    public void testArrayIOExceptionOnWriteString1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final String data = "A";
        try {
            tw.write(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteString2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        final String data = "A";
        try {
            tw.write(data);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());

        }
    }

    @Test
    public void testArrayIOExceptionOnWriteStringIntInt1() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(badW, goodW, null);
        final String data = "A";
        try {
            tw.write(data, 0, 0);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data, 0, 0);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(0, e.getCause(0, IOIndexedException.class).getIndex());
        }
    }

    @Test
    public void testArrayIOExceptionOnWriteStringIntInt2() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(goodW, badW, null);
        final String data = "A";
        try {
            tw.write(data, 0, 0);
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).write(data, 0, 0);
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());

        }
    }

    @Test
    public void testCollectionCloseBranchIOException() throws IOException {
        final Writer badW = new BrokenWriter();
        final StringWriter goodW = mock(StringWriter.class);
        final ProxyCollectionWriter tw = new ProxyCollectionWriter(Arrays.asList(goodW, badW, null));
        try {
            tw.close();
            fail("Expected " + IOException.class.getName());
        } catch (final IOExceptionList e) {
            verify(goodW).close();
            Assert.assertEquals(1, e.getCauseList().size());
            Assert.assertEquals(1, e.getCause(0, IOIndexedException.class).getIndex());

        }
    }

    @Test
    public void testConstructorsNull() throws IOException {
        try (final ProxyCollectionWriter teeWriter = new ProxyCollectionWriter((Writer[]) null)) {
            // Call any method, should not throw
            teeWriter.append('a');
            teeWriter.flush();
        }
        try (final ProxyCollectionWriter teeWriter = new ProxyCollectionWriter((Collection<Writer>) null)) {
            // Call any method, should not throw
            teeWriter.append('a');
            teeWriter.flush();
        }
    }

    @Test
    public void testTee() throws IOException {
        final StringBuilderWriter sbw1 = new StringBuilderWriter();
        final StringBuilderWriter sbw2 = new StringBuilderWriter();
        final StringBuilderWriter expected = new StringBuilderWriter();

        try (final ProxyCollectionWriter tw = new ProxyCollectionWriter(sbw1, sbw2, null)) {
            for (int i = 0; i < 20; i++) {
                tw.write(i);
                expected.write(i);
            }
            assertEquals("ProxyCollectionWriter.write(int)", expected.toString(), sbw1.toString());
            assertEquals("ProxyCollectionWriter.write(int)", expected.toString(), sbw2.toString());

            final char[] array = new char[10];
            for (int i = 20; i < 30; i++) {
                array[i - 20] = (char) i;
            }
            tw.write(array);
            expected.write(array);
            assertEquals("ProxyCollectionWriter.write(char[])", expected.toString(), sbw1.toString());
            assertEquals("ProxyCollectionWriter.write(char[])", expected.toString(), sbw2.toString());

            for (int i = 25; i < 35; i++) {
                array[i - 25] = (char) i;
            }
            tw.write(array, 5, 5);
            expected.write(array, 5, 5);
            assertEquals("TeeOutputStream.write(byte[], int, int)", expected.toString(), sbw1.toString());
            assertEquals("TeeOutputStream.write(byte[], int, int)", expected.toString(), sbw2.toString());

            for (int i = 0; i < 20; i++) {
                tw.append((char) i);
                expected.append((char) i);
            }
            assertEquals("ProxyCollectionWriter.append(char)", expected.toString(), sbw1.toString());
            assertEquals("ProxyCollectionWriter.append(char)", expected.toString(), sbw2.toString());

            for (int i = 20; i < 30; i++) {
                array[i - 20] = (char) i;
            }
            tw.append(new String(array));
            expected.append(new String(array));
            assertEquals("ProxyCollectionWriter.append(CharSequence)", expected.toString(), sbw1.toString());
            assertEquals("ProxyCollectionWriter.write(CharSequence)", expected.toString(), sbw2.toString());

            for (int i = 25; i < 35; i++) {
                array[i - 25] = (char) i;
            }
            tw.append(new String(array), 5, 5);
            expected.append(new String(array), 5, 5);
            assertEquals("ProxyCollectionWriter.append(CharSequence, int, int)", expected.toString(), sbw1.toString());
            assertEquals("ProxyCollectionWriter.append(CharSequence, int, int)", expected.toString(), sbw2.toString());

            expected.flush();
            expected.close();

            tw.flush();
        }
    }

}
