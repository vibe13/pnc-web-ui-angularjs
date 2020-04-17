/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014-2020 Red Hat, Inc., and individual contributors
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
package org.jboss.pnc.facade.providers.api;

import org.jboss.pnc.dto.ProductMilestoneRelease;
import org.jboss.pnc.dto.ProductMilestoneReleaseRef;
import org.jboss.pnc.dto.response.Page;

/**
 * @author <a href="mailto:matejonnet@gmail.com">Matej Lazar</a>
 */
public interface ProductMilestoneReleaseProvider extends
        Provider<Integer, org.jboss.pnc.model.ProductMilestoneRelease, ProductMilestoneRelease, ProductMilestoneReleaseRef> {

    ProductMilestoneRelease getLatestProductMilestoneRelease(int milestoneId);

    Page<ProductMilestoneRelease> getProductMilestoneReleases(
            int pageIndex,
            int pageSize,
            String sortingRsql,
            String query,
            int milestoneId,
            boolean latest,
            boolean running);
}