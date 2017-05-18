package roboCleaner.rest;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import roboCleaner.resources.CleanRoomServiceResource;

public class DWGettingStartedApplication extends Application<DWGettingStartedConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWGettingStartedApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWGettingStarted";
    }

    @Override
    public void initialize(final Bootstrap<DWGettingStartedConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DWGettingStartedConfiguration configuration,
            final Environment environment) {
        environment.jersey().register(new CleanRoomServiceResource());
    }

}
