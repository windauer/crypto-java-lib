package ro.kuberam.libs.java.crypto.digest;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import org.junit.Test;

import ro.kuberam.tests.junit.BaseTest;

import static org.junit.Assert.assertTrue;

public class HmacStringWithSha384AndDefaultFormat extends BaseTest {

    @Test
    public void hmacStringWithSha384() throws Exception {
        final String input = "Short string for tests.";
        try (final InputStream secretKeyIs = getClass().getResourceAsStream("../rsa-private-key.key")) {

            final String result = Hmac.hmac(input.getBytes(StandardCharsets.UTF_8), IOUtils.toByteArray(secretKeyIs),
                    "HMAC-SHA-384", "");

            assertTrue(result.equals("RRirKZTmx+cG8EXvgrRnpYFPEPYXaZBirY+LFmiUBAK61LCryDsL4clFRG5/BcBr"));
        }
    }
}
