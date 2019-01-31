package org.apereo.cas.authentication;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.core.io.ClassPathResource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This is {@link GroovyAuthenticationPostProcessorTests}.
 *
 * @author Misagh Moayyed
 * @since 6.1.0
 */
@SpringBootTest(classes = RefreshAutoConfiguration.class)
public class GroovyAuthenticationPostProcessorTests {
    @Test
    public void verifyAction() {
        val g = new GroovyAuthenticationPostProcessor(new ClassPathResource("GroovyPostProcessor.groovy"));
        val transaction = mock(AuthenticationTransaction.class);
        val creds = CoreAuthenticationTestUtils.getCredentialsWithSameUsernameAndPassword();
        when(transaction.getPrimaryCredential()).thenReturn(Optional.of(creds));
        assertTrue(g.supports(creds));
        val authenticationBuilder = CoreAuthenticationTestUtils.getAuthenticationBuilder();
        g.process(authenticationBuilder, transaction);
        assertFalse(authenticationBuilder.getSuccesses().isEmpty());
        assertFalse(authenticationBuilder.getSuccesses().get("test").getWarnings().isEmpty());
    }
}
