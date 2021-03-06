/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.plugins.cloudbees.tasks.app

import org.gradle.api.plugins.cloudbees.client.CloudBeesClient
import org.gradle.api.plugins.cloudbees.tasks.CloudBeesTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

/**
 * Establishes a persistent connection to the application logs.
 *
 * @author Benjamin Muschko
 */
class CloudBeesAppTail extends CloudBeesTask {
    /**
     * Application identifier.
     */
    @Input
    String appId

    /**
     * Log to tail. Defaults to "server" if not set.
     */
    @Input
    @Optional
    String log

    CloudBeesAppTail() {
        super('Establishes a persistent connection to the application logs.')
    }

    @Override
    void executeAction(CloudBeesClient client) {
        log = log ?: 'server'
        client.tailLog(getAppId(), log, System.out)
    }
}
