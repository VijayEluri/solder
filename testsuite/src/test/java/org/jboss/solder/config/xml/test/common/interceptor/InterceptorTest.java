/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.solder.config.xml.test.common.interceptor;

import static org.jboss.solder.config.xml.test.common.util.Deployments.baseDeployment;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class InterceptorTest {
    
    @Deployment(name = "InterceptorTest")
    public static Archive<?> deployment() {
        return baseDeployment(InterceptorTest.class, "interceptor-beans.xml")
            .addAsWebInfResource("META-INF/config-beans.xml", "beans.xml")
            .addClasses(InterceptedBean.class, InterceptorBean.class, Binding.class);
    }
    
    @Inject
    InterceptedBean x;

    @Test
    public void testInterceptors() {

        String res = x.method();
        Assert.assertEquals("hello world", res);

    }
}
