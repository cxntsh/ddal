/*
 * Copyright 2016-2017 the original author or authors.
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
package org.hellojavaer.ddal.spring.scan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author <a href="mailto:hellojavaer@gmail.com">Kaiming Zou</a>,created on 21/06/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring.xml" })
public class EnableShardRouteAnnotationTest {

    @Autowired
    private ShardRouteTestComponent shardRouteTestComponent;

    @Test
    public void test01() {
        for (int i = 0; i < 100; i++) {
            shardRouteTestComponent.routeWithId((long) i);
        }
    }

    @Test
    public void test02() {
        for (long i = 0; i < 100; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(i);
            shardRouteTestComponent.routeWithEntity(userEntity);
        }
    }

    @Test
    public void testFormat() {
        for (long i = 0; i < 100; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(i);
            shardRouteTestComponent.testFunction(userEntity);
        }
    }

}
