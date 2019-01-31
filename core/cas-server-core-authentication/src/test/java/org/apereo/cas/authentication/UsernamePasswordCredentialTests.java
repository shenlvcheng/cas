package org.apereo.cas.authentication;

import org.apereo.cas.authentication.credential.UsernamePasswordCredential;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Scott Battaglia
 * @since 3.0.0
 */
public class UsernamePasswordCredentialTests {

    @Test
    public void verifySetGetUsername() {
        val c = new UsernamePasswordCredential();
        val userName = "test";

        c.setUsername(userName);

        assertEquals(userName, c.getUsername());
    }

    @Test
    public void verifySetGetPassword() {
        val c = new UsernamePasswordCredential();
        val password = "test";

        c.setPassword(password);

        assertEquals(password, c.getPassword());
    }

    @Test
    public void verifyEquals() {
        assertNotEquals(CoreAuthenticationTestUtils.getCredentialsWithDifferentUsernameAndPassword(), null);
        assertNotEquals(CoreAuthenticationTestUtils.getCredentialsWithDifferentUsernameAndPassword(),
            CoreAuthenticationTestUtils.getCredentialsWithSameUsernameAndPassword());
        assertEquals(CoreAuthenticationTestUtils.getCredentialsWithDifferentUsernameAndPassword(),
            CoreAuthenticationTestUtils.getCredentialsWithDifferentUsernameAndPassword());
    }
}
