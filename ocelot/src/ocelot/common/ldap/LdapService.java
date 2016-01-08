/**
 * 	@(#)LdapService.java   2006-9-9 下午06:27:26
 *	 。 
 *	 
 */
package ocelot.common.ldap;

import ocelot.framework.base.dto.IBaseDTO;

/**
 * @author 赵一非
 * @version 2006-9-9
 * @see
 */
public interface LdapService {

	/**
	 * 查询ldap
	 * @param id
	 * @version 2006-9-9
	 * @return
	 */
	public IBaseDTO search(String id);
	
	/**
	 * 增加信息 ldap
	 * @param
	 * @version 2006-9-9
	 * @return
	 */
	public void add(IBaseDTO dto);
	/**
	 * 修改信息 ldap
	 * @param
	 * @version 2006-9-9
	 * @return
	 */
	public void update(IBaseDTO dto);
	/**
	 * 删除信息 ldap
	 * @param
	 * @version 2006-9-9
	 * @return
	 */
	public void delete(IBaseDTO dto);
	
	
}
