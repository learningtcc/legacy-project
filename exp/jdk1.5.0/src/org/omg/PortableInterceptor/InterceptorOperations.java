package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/InterceptorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Wednesday, September 15, 2004 10:28:45 AM GMT
*/


/**
   * All Portable Interceptors implement Interceptor.
   */
public interface InterceptorOperations 
{

  /**
     * Returns the name of the interceptor.
     * <p>
     * Each Interceptor may have a name that may be used administratively 
     * to order the lists of Interceptors. Only one Interceptor of a given 
     * name can be registered with the ORB for each Interceptor type. An 
     * Interceptor may be anonymous, i.e., have an empty string as the name 
     * attribute. Any number of anonymous Interceptors may be registered with 
     * the ORB.
     *
     * @return the name of the interceptor.
     */
  String name ();

  /**
     * Provides an opportunity to destroy this interceptor.
     * The destroy method is called during <code>ORB.destroy</code>. When an 
     * application calls <code>ORB.destroy</code>, the ORB:
     * <ol>
     *   <li>waits for all requests in progress to complete</li>
     *   <li>calls the <code>Interceptor.destroy</code> operation for each 
     *       interceptor</li>
     *   <li>completes destruction of the ORB</li>
     * </ol>
     * Method invocations from within <code>Interceptor.destroy</code> on 
     * object references for objects implemented on the ORB being destroyed 
     * result in undefined behavior. However, method invocations on objects 
     * implemented on an ORB other than the one being destroyed are 
     * permitted. (This means that the ORB being destroyed is still capable 
     * of acting as a client, but not as a server.) 
     */
  void destroy ();
} // interface InterceptorOperations
