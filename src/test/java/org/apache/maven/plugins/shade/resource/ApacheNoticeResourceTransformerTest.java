package org.apache.maven.plugins.shade.resource;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Locale;

import junit.framework.TestCase;

/**
 * Test for {@link ApacheNoticeResourceTransformer}.
 * 
 * @author Benjamin Bentmann
 * @version $Id: ApacheNoticeResourceTransformerTest.java 673906 2008-07-04 05:03:20Z brett $
 */
public class ApacheNoticeResourceTransformerTest
    extends TestCase
{

    private ApacheNoticeResourceTransformer transformer;

    static
    {
        /*
         * NOTE: The Turkish locale has an usual case transformation for the letters "I" and "i", making it a prime
         * choice to test for improper case-less string comparisions.
         */
        Locale.setDefault( new Locale( "tr" ) );
    }

    public void setUp()
    {
        this.transformer = new ApacheNoticeResourceTransformer();
    }

    public void testCanTransformResource()
    {
        assertTrue( this.transformer.canTransformResource( "META-INF/NOTICE" ) );
        assertTrue( this.transformer.canTransformResource( "META-INF/NOTICE.TXT" ) );
        assertTrue( this.transformer.canTransformResource( "META-INF/Notice.txt" ) );
        assertFalse( this.transformer.canTransformResource( "META-INF/MANIFEST.MF" ) );
    }

}
