package supervizor.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("...");

        register(IssueController.class);
        register(ExceptionMapper.class);

        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}
