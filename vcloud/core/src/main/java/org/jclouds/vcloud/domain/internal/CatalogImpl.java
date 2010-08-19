/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
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
 * ====================================================================
 */

package org.jclouds.vcloud.domain.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jclouds.vcloud.VCloudExpressMediaType;
import org.jclouds.vcloud.domain.Catalog;
import org.jclouds.vcloud.domain.NamedResource;

import com.google.inject.internal.Nullable;

/**
 * Locations of resources in vCloud
 * 
 * @author Adrian Cole
 * 
 */
public class CatalogImpl extends LinkedHashMap<String, NamedResource> implements Catalog {

   /** The serialVersionUID */
   private static final long serialVersionUID = 8464716396538298809L;
   private final String name;
   private final String description;
   private final URI id;

   public CatalogImpl(String name, URI id, @Nullable String description, Map<String, NamedResource> contents) {
      this.name = checkNotNull(name, "name");
      this.description = description;
      this.id = checkNotNull(id, "id");
      putAll(checkNotNull(contents, "contents"));
   }

   @Override
   public URI getId() {
      return id;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((description == null) ? 0 : description.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      CatalogImpl other = (CatalogImpl) obj;
      if (description == null) {
         if (other.description != null)
            return false;
      } else if (!description.equals(other.description))
         return false;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }

   public String getDescription() {
      return description;
   }

   @Override
   public String getType() {
      return VCloudExpressMediaType.CATALOG_XML;
   }

   @Override
   public int compareTo(NamedResource o) {
      return (this == o) ? 0 : getId().compareTo(o.getId());
   }

}