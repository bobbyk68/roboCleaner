package roboCleaner.rest;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import roboCleaner.resources.CleanRoomServiceResource;

public class CleanerApplication extends Application<CleanerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CleanerApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWGettingStarted";
    }

    @Override
    public void initialize(final Bootstrap<CleanerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final CleanerConfiguration configuration,
            final Environment environment) {
        environment.jersey().register(new CleanRoomServiceResource());
    }

}
