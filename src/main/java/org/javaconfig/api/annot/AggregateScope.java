/*
 * Copyright (c) 2013, Anatole Tresch.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.javaconfig.api.annot;

 import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 @Retention(RetentionPolicy.RUNTIME)
 @Target(value = { ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
 public @interface AggregateScope {
	 
	 public static final String DEPENDENT = "<DEPENDENT>";
	 public static final String GLOBAL = "GLOBAL";
	 public static final String DOMAIN = "DOMAIN";
	 public static final String APPLICATION = "APPLICATION";
	 public static final String WEB = "WEB";
	 public static final String TENANT = "TENANT";
	 
	 String value() default DEPENDENT;

 }
