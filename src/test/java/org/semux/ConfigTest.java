/*
 * Copyright (c) 2017 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigTest {

    @Test
    public void testLoad() {
        assertTrue(Config.init());
        assertEquals(1, Config.NETWORK_ID);
    }

    @Test
    public void testNumberOfValidators() {
        long oneDay = 3 * 60 * 24;

        assertEquals(10, Config.getNumberOfValidators(0));
        assertEquals(10, Config.getNumberOfValidators(1));
        assertEquals(11, Config.getNumberOfValidators(oneDay));
        assertEquals(12, Config.getNumberOfValidators(2 * oneDay));
        assertEquals(60, Config.getNumberOfValidators(50 * oneDay));
        assertEquals(99, Config.getNumberOfValidators(90 * oneDay - 1));
        assertEquals(100, Config.getNumberOfValidators(90 * oneDay));
        assertEquals(100, Config.getNumberOfValidators(100 * oneDay));
        assertEquals(100, Config.getNumberOfValidators(Long.MAX_VALUE));
    }
}
