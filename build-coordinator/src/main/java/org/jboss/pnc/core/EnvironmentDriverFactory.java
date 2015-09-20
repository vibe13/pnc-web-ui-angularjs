/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.pnc.core;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.pnc.core.exception.CoreException;
import org.jboss.pnc.model.BuildEnvironment;
import org.jboss.pnc.spi.environment.EnvironmentDriver;

/**
 * Creates instances of environment drivers
 * 
 * @author Jakub Bartecek &lt;jbartece@redhat.com&gt;
 *
 */
@ApplicationScoped
public class EnvironmentDriverFactory {

    @Inject
    Instance<EnvironmentDriver> availableDrivers;
    
    /**
     * Gets environment driver, which can manage requested environment
     * @param buildSystemImage Requested build system specification
     * @return Available driver for given environment
     * @throws CoreException Throw if no suitable driver for selected environment was found
     */
    public EnvironmentDriver getDriver(BuildEnvironment buildSystemImage) throws CoreException {
        for (EnvironmentDriver driver : availableDrivers) {
            if (driver.canBuildEnvironment(buildSystemImage))
                return driver;
        }

        throw new CoreException("No environment driver available for " + buildSystemImage + " environment type.");
    }
}
