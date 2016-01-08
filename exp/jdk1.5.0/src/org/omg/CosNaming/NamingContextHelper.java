package org.omg.CosNaming;


/**
* org/omg/CosNaming/NamingContextHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/org/omg/CosNaming/nameservice.idl
* Wednesday, September 15, 2004 10:28:47 AM GMT
*/


/** 
 * A naming context is an object that contains a set of name bindings in 
 * which each name is unique. Different names can be bound to an object 
 * in the same or different contexts at the same time. <p>
 * 
 * See <a href="http://www.omg.org/technology/documents/formal/naming_service.htm">
 * CORBA COS 
 * Naming Specification.</a>
 */
abstract public class NamingContextHelper
{
  private static String  _id = "IDL:omg.org/CosNaming/NamingContext:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.CosNaming.NamingContext that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.CosNaming.NamingContext extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (org.omg.CosNaming.NamingContextHelper.id (), "NamingContext");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.CosNaming.NamingContext read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_NamingContextStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.CosNaming.NamingContext value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static org.omg.CosNaming.NamingContext narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.omg.CosNaming.NamingContext)
      return (org.omg.CosNaming.NamingContext)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.omg.CosNaming._NamingContextStub stub = new org.omg.CosNaming._NamingContextStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static org.omg.CosNaming.NamingContext unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.omg.CosNaming.NamingContext)
      return (org.omg.CosNaming.NamingContext)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.omg.CosNaming._NamingContextStub stub = new org.omg.CosNaming._NamingContextStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
