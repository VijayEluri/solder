package org.jboss.weld.extensions.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;

public abstract class ForwardingBean<T> implements Bean<T>
{
   
   protected abstract Bean<T> delegate();

   public Class<?> getBeanClass()
   {
      return delegate().getBeanClass();
   }

   public Set<InjectionPoint> getInjectionPoints()
   {
      return delegate().getInjectionPoints();
   }

   public String getName()
   {
      return delegate().getName();
   }

   public Set<Annotation> getQualifiers()
   {
      return delegate().getQualifiers();
   }

   public Class<? extends Annotation> getScope()
   {
      return delegate().getScope();
   }

   public Set<Class<? extends Annotation>> getStereotypes()
   {
      return delegate().getStereotypes();
   }

   public Set<Type> getTypes()
   {
      return delegate().getTypes();
   }

   public boolean isAlternative()
   {
      return delegate().isAlternative();
   }

   public boolean isNullable()
   {
      return delegate().isNullable();
   }

   public T create(CreationalContext<T> creationalContext)
   {
      return delegate().create(creationalContext);
   }

   public void destroy(T instance, CreationalContext<T> creationalContext)
   {
      delegate().destroy(instance, creationalContext);
   }
   
   @Override
   public int hashCode()
   {
      return delegate().hashCode();
   }
   
   @Override
   public boolean equals(Object obj)
   {
      return delegate().equals(obj);
   }
   
   @Override
   public String toString()
   {
      return delegate().toString();
   }

}
