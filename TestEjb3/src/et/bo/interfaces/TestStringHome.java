/*
 * Generated by XDoclet - Do not edit!
 */
package et.bo.interfaces;

/**
 * Home interface for TestString.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface TestStringHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/TestString";
   public static final String JNDI_NAME="ejb/TestString";

   public et.bo.interfaces.TestString create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
