/*
 * @(#)file      AclEntryImpl.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   4.11
 * @(#)date      04/09/15
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


package com.sun.jmx.snmp.IPAcl;



import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;
import java.net.UnknownHostException;

import java.security.Principal; 
import java.security.acl.AclEntry; 


/**
 * Represent one entry in the Access Control List (ACL).
 * This ACL entry object contains a permission associated with a particular principal.
 * (A principal represents an entity such as an individual machine or a group).
 *
 * @see java.security.acl.AclEntry
 * @version     4.11     12/19/03
 * @author      Sun Microsystems, Inc
 */

class AclEntryImpl implements AclEntry, Serializable {
  
  private AclEntryImpl (AclEntryImpl i) throws UnknownHostException {
	setPrincipal(i.getPrincipal());
	permList = new Vector();
	commList = new Vector();
	
	for (Enumeration en = i.communities(); en.hasMoreElements();){
	  addCommunity((String)en.nextElement());
	}
	
	for (Enumeration en = i.permissions(); en.hasMoreElements();){
	  addPermission((java.security.acl.Permission)en.nextElement());
	}
	if (i.isNegative()) setNegativePermissions();
  }
  
  /**
   * Contructs an empty ACL entry.
   */
  public AclEntryImpl (){
	princ = null;
	permList = new Vector();
	commList = new Vector();
  }
  
  /**
   * Constructs an ACL entry with a specified principal.
   *
   * @param p the principal to be set for this entry.
   */
  public AclEntryImpl (Principal p) throws UnknownHostException {
	princ = p;
	permList = new Vector();
	commList = new Vector();
  }
  
  /**
   * Clones this ACL entry.
   *
   * @return a clone of this ACL entry.
   */
  public Object clone() {
	AclEntryImpl i;
	try {
	  i = new AclEntryImpl(this);
	}catch (UnknownHostException e) {
	  i = null;
	}
	return (Object) i;
  }
  
  /**
   * Returns true if this is a negative ACL entry (one denying the associated principal
   * the set of permissions in the entry), false otherwise.
   *
   * @return true if this is a negative ACL entry, false if it's not.
   */
  public boolean isNegative(){
	return neg;
  }
  
  /**
   * Adds the specified permission to this ACL entry. Note: An entry can 
   * have multiple permissions.
   *
   * @param perm the permission to be associated with the principal in this 
   *        entry
   * @return true if the permission is removed, false if the permission was 
   *         not part of this entry's permission set. 
   *
   */
  public boolean addPermission(java.security.acl.Permission perm){
	if (permList.contains(perm)) return false;
	permList.addElement(perm);
	return true;
  }
  
  /**
   * Removes the specified permission from this ACL entry.
   *
   * @param perm the permission to be removed from this entry. 
   * @return true if the permission is removed, false if the permission 
   *         was not part of this entry's permission set. 
   */
  public boolean removePermission(java.security.acl.Permission perm){
	if (!permList.contains(perm)) return false;
	permList.removeElement(perm);
	return true;
  }
  
  /**
   * Checks if the specified permission is part of the permission set in 
   * this entry. 
   *
   * @param perm the permission to be checked for.
   * @return true if the permission is part of the permission set in this 
   *         entry, false otherwise. 
   */
  
  public boolean checkPermission(java.security.acl.Permission perm){
	return (permList.contains(perm));
  }
  
  /**
   * Returns an enumeration of the permissions in this ACL entry.
   *
   * @return an enumeration of the permissions in this ACL entry. 
   */
  public Enumeration permissions(){
	return permList.elements();
  }
  
  /**
   * Sets this ACL entry to be a negative one. That is, the associated principal 
   * (e.g., a user or a group) will be denied the permission set specified in the
   * entry. Note: ACL entries are by default positive. An entry becomes a negative
   * entry only if this setNegativePermissions method is called on it. 
   *
   * Not Implemented.
   */
  public void setNegativePermissions(){
	neg = true;
  }
  
  /**
   * Returns the principal for which permissions are granted or denied by this ACL
   * entry. Returns null if there is no principal set for this entry yet.
   *
   * @return the principal associated with this entry. 
   */
  public Principal getPrincipal(){
	return princ;
  }
  
  /**
   * Specifies the principal for which permissions are granted or denied by 
   * this ACL entry. If a principal was already set for this ACL entry, 
   * false is returned, otherwise true is returned. 
   *
   * @param p the principal to be set for this entry.
   * @return true if the principal is set, false if there was already a 
   *         principal set for this entry. 
   */
  public boolean setPrincipal(Principal p) {
	if (princ != null ) 
	  return false;
	princ = p;
	return true;
  }
  
  /**
   * Returns a string representation of the contents of this ACL entry. 
   *
   * @return a string representation of the contents. 
   */
  public String toString(){
	return "AclEntry:"+princ.toString();
  }
  
  /**
   * Returns an enumeration of the communities in this ACL entry.
   *
   * @return an enumeration of the communities in this ACL entry.
   */
  public Enumeration communities(){
	return commList.elements();
  }
  
  /**
   * Adds the specified community to this ACL entry. Note: An entry can 
   * have multiple communities.
   *
   * @param comm the community to be associated with the principal
   *        in this entry. 
   * @return true if the community was added, false if the community was
   *         already part of this entry's community set. 
   */
  public boolean addCommunity(String comm){
	if (commList.contains(comm)) return false;
	commList.addElement(comm);
	return true;
  }
  
  /**
   * Removes the specified community from this ACL entry. 
   *
   * @param comm the community  to be removed from this entry. 
   * @return true if the community is removed, false if the community was 
   *         not part of this entry's community set. 
   */
  public boolean removeCommunity(String comm){
	if (!commList.contains(comm)) return false;
	commList.removeElement(comm);
	return true;
  }
  
  /**
   * Checks if the specified community is part of the community set in this 
   * entry. 
   *
   * @param  comm the community to be checked for. 
   * @return true if the community is part of the community set in this 
   *         entry, false otherwise. 
   */
  public boolean checkCommunity(String comm){
	return (commList.contains(comm));
  }

  private Principal princ = null;
  private boolean neg     = false;
  private Vector permList = null;
  private Vector commList = null;
}









