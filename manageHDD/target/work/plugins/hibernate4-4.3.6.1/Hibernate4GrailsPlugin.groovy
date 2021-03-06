/*
 * Copyright 2013 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import grails.plugin.hibernate4.HibernatePluginSupport
import org.codehaus.groovy.grails.commons.AnnotationDomainClassArtefactHandler

/**
 * Handles the configuration of Hibernate 4 within Grails.
 */
class Hibernate4GrailsPlugin {

    def version = '4.3.6.1'
    def grailsVersion = '2.3.5 > *'
    def author = 'Burt Beckwith'
    def title = 'Hibernate 4 for Grails'
    def description = 'Provides integration between Grails and Hibernate 4 through GORM'
    def documentation = 'http://grails.org/plugin/hibernate4'

    def observe = ['domainClass']
    def loadAfter = ['controllers', 'domainClass']
    def watchedResources = ['file:./grails-app/conf/hibernate/**.xml']
    def artefacts = [AnnotationDomainClassArtefactHandler]
    def pluginExcludes = ['src/templates/**']

    def license = 'APACHE'
    def organization = [name: 'SpringSource', url: 'http://www.springsource.org/']
    def issueManagement = [system: 'JIRA', url: 'http://jira.grails.org/browse/GPHIB']
    def scm = [url: 'https://github.com/grails-plugins/grails-hibernate4-plugin']

    def doWithSpring = HibernatePluginSupport.doWithSpring

    def doWithDynamicMethods = HibernatePluginSupport.doWithDynamicMethods

    def onChange = HibernatePluginSupport.onChange
}
