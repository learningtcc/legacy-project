package org.omg.CORBA;


/**
* org/omg/CORBA/WStringSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/org/omg/PortableInterceptor/CORBAX.idl
* Wednesday, September 15, 2004 10:28:43 AM GMT
*/


/** An array of WStrings */
public final class WStringSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public WStringSeqHolder ()
  {
  }

  public WStringSeqHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.omg.CORBA.WStringSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.omg.CORBA.WStringSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.omg.CORBA.WStringSeqHelper.type ();
  }

}
