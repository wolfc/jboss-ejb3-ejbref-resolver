/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
  *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.ejb3.common.registrar.spi;

/**
 * Ejb3Registrar
 * 
 * Defines the contract for implementations of
 * the EJB3 Object Store, providing mechanisms
 * to bind, unbind, and lookup generic Objects 
 *
 * @author <a href="mailto:andrew.rubinger@jboss.org">ALR</a>
 * @version $Revision: $
 */
public interface Ejb3Registrar
{
   /**
    * Obtains the value bound at the specified name, 
    * throwing NotBoundException if there is nothing
    * bound at the key
    * 
    * @param name
    * @throws NotBoundException
    * @return
    */
   Object lookup(Object name) throws NotBoundException;

   /**
    * Binds the specified value to the key of specified name, 
    * throwing a DuplicateBindException in the case the
    * name is not unique
    * 
    * @param name
    * @param value
    * @throws DuplicateBindException
    */
   void bind(Object name, Object value) throws DuplicateBindException;

   /**
    * Binds the specified value to the key of specified name, 
    * optionally unbinding the current value if one exists
    * 
    * @param name
    * @param value
    */
   void rebind(Object name, Object value);

   /**
    * Unbinds the object at the specified name, throwing
    * NotBoundException if no object exists at that name
    * 
    * @param name
    * @throws NotBoundException
    */
   void unbind(Object name) throws NotBoundException;

   /**
    * Returns a provider implementation-specific class
    * to break contract and invoke upon vendor-specific
    * features.
    * 
    * @return
    */
   Object getProvider();
}